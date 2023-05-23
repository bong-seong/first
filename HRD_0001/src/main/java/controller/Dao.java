package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	
	// 1. 문항지에 있는 DB 연동 함수
	public static Connection getConnetion() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe", "system" , "1234" );
		return con;		
	}
	
	
	// 2. sql 조작 인터페이스
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 3. 생성자 [ 객체 생성시 DB 연동 함수 호출 ]
	public Dao() {
		try {
			con = getConnetion();
		} catch (Exception e) {
			System.out.println( e );
		}
	}
	
	// 4. 함수
	
	// 4-1 학생 목록 호출
	public List<Dto> getList() {
		List<Dto> list = new ArrayList<>();		
		String sql = "select * from student_tbl_03" ;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				Dto dto = new Dto( 	rs.getString(1), 
									rs.getString(2), 
									rs.getString(3), 
									rs.getString(4), 
									rs.getString(5) );
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println( "오류 : " + e );
		}
		return list;
	}
	
	// 4-2 성적 등록 함수
	public boolean add( Dto dto ) {
		
		String sql = "insert into exam_tbl_03 values( ? , ? , ? , ? , ? )";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString( 1 , dto.getSno() );
			ps.setInt( 2 , dto.getEkor() );
			ps.setInt( 3 , dto.getEmath() );
			ps.setInt( 4 , dto.getEeng() );
			ps.setInt( 5 , dto.getEhist() );
			
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.out.println( e );
		}
		
		return false;
	}
	
	// 4-3 학생성적 불러오기
	public List<Dto> getScore() {
		
		List<Dto> list = new ArrayList<>();
		
		String sql = "select "
				+ "	s.sno , "
				+ "	s.sname , "
				+ "	e.ekor , "
				+ "	e.emath , "
				+ "	e.eeng , "
				+ "	e.ehist , "
				+ "	( e.ekor + e.emath + e.eeng + e.ehist ) as total, "
				+ "	(( e.ekor + e.emath + e.eeng + e.ehist )/4) as avg, "
				+ "	RANK() OVER ( order by ( nvl( e.ekor , 0 )  + nvl( e.emath , 0 ) + nvl( e.eeng , 0 ) + nvl( e.ehist , 0 ) ) desc ) as rank "
				+ "	from student_tbl_03 s full outer join exam_tbl_03 e on s.sno = e.sno ";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				Dto dto = new Dto(
						rs.getString(1),
						rs.getString(2), 
						rs.getInt(3),
						rs.getInt(4), 
						rs.getInt(5), 
						rs.getInt(6), 
						rs.getInt(7),
						rs.getDouble(8),
						rs.getString(9));
				
				list.add(dto);
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

}
