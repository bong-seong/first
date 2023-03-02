package jsp_web.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
}
