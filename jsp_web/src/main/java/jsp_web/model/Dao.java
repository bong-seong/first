package jsp_web.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	
	// 1. 내부객체
	private static Dao dao = new Dao();
	public static Dao getInstance() {
		return dao;
	}
	
	Connection con ;
	PreparedStatement ps;
	ResultSet rs;
	
	private Dao() {
		try {
			// * [웹서버] : 해당 MYSQL 드라이버[라이브러리] 찾기
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsp_web",
					"root", "1234");
			System.out.println("DB연동 성공");
		}catch (Exception e) {
			System.out.println("DB연결 실패 : " + e );
		}
	}
	
	// 2. SQL 메소드
	public boolean setData( String data ) {
		// 1. SQL 작성
		String sql = "insert into ex1 values ( ? )";
		
		// 2. SQL 대입
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, data);
			ps.executeUpdate();
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return false; 
	}
	
	// 데이터 둘 호출 [ 1개 : String / 여러개 : ArrayList<String> ]
	public ArrayList<String> getData(){
		
		ArrayList<String> list = new ArrayList<>();
		
		String sql = "select * from ex1";
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				list.add( rs.getString( 1 ));
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
}
