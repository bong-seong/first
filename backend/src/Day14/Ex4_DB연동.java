package Day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Ex4_DB연동 {
	
	public static void main(String[] args) {
		
		try {
			
			// 1. 연결 인터페이스
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/java",
					"root",
					"1234"
					);
			System.out.println(" [ DB 연동 성공 ] ");
			
			// 2. table 생성
			String sql = "create table member ("
								+ "no int , "
								+ "id varchar(20) , "
								+ "pwd varchar(20) "
						+ ");" ;
			
			// 3. DML DDL 조작 인터페이스에 연결된 DB연결구현객체에 SQL 대입 
			PreparedStatement ps = con.prepareStatement( sql );
			
			// 4. SQL 실행
			ps.execute();
			
			
			
		}catch ( Exception e ) {
			System.out.println(" [ DB 연동 실패 ] 사유 : " + e );
		}
		
	}
	

}

/*
 
 	JDBC : 자바와 데이터베이스 연결 드라이브
 		- 해당 DBMS 마다 라이브러리[.jar] 파일 필요
 		- 보관장소 : C://mysql-connector-java-8.0.XX
 	- 라이브러리 추가
 		1. 프로젝트 오른쪽클릭 -> build path -> configure build path
 		2. Libraries 탭에서 javaSE 버전 변경
 			1. [ javaSE-1.8 일 경우 생략 ]
 				1. javaSE - 17 
 				2. 더블클릭 -> javaSE-1.8 변경 -> apply
 			2. add External jars
 			3. mysql-connector-java-8.0.XX .jar 파일 찾아서 추가
 	- 2.
 		Connection : DB 연결 인터페이스로 다양한 객체를 제공
 		DriverManager : DB 연결 클래스 구현객체 제공
 			1. DriverManager.getConnection( DB주소 , 계정 , 비밀번호 )
 				- 일반예외 발생 ( 예외처리 필수 )
 				- mysql server주소 : jdbc:mysql://ip주소:포트번호/db명
 				
 
 */
