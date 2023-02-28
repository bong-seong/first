package Day20.gallery.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DAO {

	// 1. JDBC 인터페이스 3개
	public Connection con;			// DB 연동 인터페이스
	public PreparedStatement ps;	// SQL 조작 인터페이스
	public ResultSet rs;			// SQL 결과 조작 인터페이스
	
	public DAO() {
		
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/boardDB",
					"root",
					"1234");
		} catch (Exception e) {
			System.out.println( e );
		}
	}
}
