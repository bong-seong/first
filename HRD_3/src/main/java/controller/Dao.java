package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	
	// 1. [ 참고 ] DB 연결 함수
	public static Connection getConnection() throws Exception {
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@//localhost:1521/xe" , "system" , "1234" 
				);
		
		return con ;
	}
	
	// 2. DB 조작 인터페이스
	private Connection con ;
	private PreparedStatement ps;
	private ResultSet rs ;
	
	// 3. 생성자를 통함 객체 생성시 DB 연동
	public Dao() {
		try {
			con = getConnection();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	// 4. 함수
	
	// 4-1 후보조회
	public List<Dto> getList() {
		
		List<Dto> list = new ArrayList<>();
		
		String sql = "select m.m_no , m.m_name , p.p_name , m.p_school , m.m_jumin , m.m_city , p.p_tel1 , p.p_tel2 , p.p_tel3 "
				+ " from tbl_member_202005 m , tbl_party_202005 p "
				+ " where m.p_code = p.p_code ";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				Dto dto = new Dto(
						rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), 
						rs.getString(7), rs.getString(8), rs.getString(9) );
				
				list.add(dto);
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
		
	}
	
	// 4-2 투표하기 
	public boolean vote( Dto dto ) {
		
		String sql = "insert into tbl_vote_202005 values ( ? , ? , ? , ? , ? , ? )";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString( 1 , dto.getV_jumin() );
			ps.setString( 2 , dto.getV_name() );
			ps.setString( 3 , dto.getM_no() );
			ps.setString( 4 , dto.getV_time() );
			ps.setString( 5 , dto.getV_area() );
			ps.setString( 6 , dto.getV_confirm() );
			
			ps.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
		
	}
	
	// 4-3 투표자검수조회
	public List<Dto> getConfirm(){
		
		List<Dto> list = new ArrayList<>();
		
		String sql = "select "
				+ "	v_jumin , "
				+ "	v_name , "
				+ "	m_no , "
				+ "	v_time , "
				+ "	v_confirm "
				+ " from tbl_vote_202005 "
				+ " where v_area = '제1투표장' ";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				Dto dto = new Dto(
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) );
				
				list.add(dto);

			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list ;
		
	}

	// 4-4 후보자 등수
	public List<Dto> getRank() {
		
		List<Dto> list = new ArrayList<>();
		
		String sql = "select m.m_no , m.m_name, count(v.v_confirm) "
				+ " from tbl_vote_202005 v , tbl_member_202005 m "
				+ " where v.m_no = m.m_no and v.v_confirm = 'Y' "
				+ " group by m.m_no , m.m_name "
				+ " order by count( v.v_confirm) desc ";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				Dto dto = new Dto( rs.getString(1), rs.getString(2), rs.getString(3) );
				
				list.add(dto);
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	
	
	
	
}
