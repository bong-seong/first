package hrd_기출문제1.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hrd_기출문제1.model.MemberDto;

public class Dao {

	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;
	
	public static Connection getConnection() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/xe",
				"root",
				"1234");
		return con;
	}
	
	public Dao() {
		try {
			con = getConnection();
		}catch (Exception e) {
			System.out.println( e );
		}
	}
	
	// 1. 마지막 회원번호+1 가져오기
	public int getcustno() {
		
		String sql = "select custno from member_tbl_02 order by custno desc limit 1";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				return rs.getInt(1)+1 ;
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}
	
	// 2. 회원등록
	public boolean join( MemberDto dto ) {
		
		String sql = "insert into member_tbl_02 (custname , phone , address , joindate , grade , city)"
				+ " values( ? , ? , ? , ? , ? , ? )";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getCustname() );
			ps.setString(2, dto.getPhone() );
			ps.setString(3, dto.getAddress() );
			ps.setString(4, dto.getJoindate() );
			ps.setString(5, dto.getGrade() );
			ps.setString(6, dto.getCity() );
			
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	// 3. 회원목록 가져오기
	public ArrayList<MemberDto> getMember(){
		
		ArrayList<MemberDto> list = new ArrayList<>();
		
		String sql = "select custno , custname , phone , address , joindate , "
				+ " if( grade = 'A' , 'VIP' , if( grade = 'B' , '일반' , '직원' ) ) as grade "
				+ " , city from member_tbl_02 ;";
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
						
				list.add( new MemberDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), 
						rs.getString(7) ) );
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	
	//4. 특정 회원 출력
	public MemberDto getM( int custno ) {
		
		String sql = "select * from member_tbl_02 where custno = "+ custno;
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if( rs.next() ) {
						
				return new MemberDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), 
						rs.getString(7) );
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	// 5. 회원 정보 수정
	public boolean update( MemberDto dto ) {
		
		
		String sql = "update member_tbl_02 set custno = ? , "
				+ " custname = ? , phone = ? , address = ? , joindate = ? , grade = ? , city = ? "
				+ " where custno = ? ";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, dto.getCustno() );
			ps.setString(2, dto.getCustname() );
			ps.setString(3, dto.getPhone() );
			ps.setString(4, dto.getAddress() );
			ps.setString(5, dto.getJoindate() );
			ps.setString(6, dto.getGrade() );
			ps.setString(7, dto.getCity() );
			
			ps.setInt(8, dto.getCustno() );
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	// 6. 매출 테이블
	
	public ArrayList<MemberDto> getSum(){
		
		ArrayList<MemberDto> list = new ArrayList<>();
		
		String sql = "select m.custno , m.custname , "
				+ " if(m.grade = 'A' , 'VIP' , if( m.grade = 'B' , '일반' , '직원' ) )as grade , "
				+ " sum( mo.price) as sum from member_tbl_02 m , money_tbl_02 mo "
				+ " where m.custno = mo.custno group by m.custno order by sum desc ";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				list.add( new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4) ) );
				
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
}
