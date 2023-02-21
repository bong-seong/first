package Day15.Ex9_MVC패턴;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {

	// * 싱글톤 : DAO 싱글톤 사용하는 이유 : 프로그램 내 DB 연동 1번만 해서 하나의 연동 객체 사용
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
	
	
	// 1. 필드
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	// 2. 생성자
	private MemberDAO() {
		
		try {
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/day15",
					"root",
					"1234");
			System.out.println("DB연결 성공");
			
		}
		catch( Exception e) {
			System.out.println("연결 실패" + e.getMessage() );
		}
	}
	
	
	// 3. SQL 처리 메소드
	
		// 1. 회원가입 메소드 [ 인수 : DTO( id , pw ) , 반환 : 성공[true] , 실패[false] ]
	public boolean signup( MemberDTO dto  ) {
		
		// 1. SQL 작성.
		String sql = "insert into member ( mid , mpw ) values ( ? , ? )";
		
		// 2. 연동 DB에 SQL 대입한다. [ ps -> 매개변수 조작 가능 ]
		try {
			ps = conn.prepareStatement(sql);
			// 3. ps는 매개변수에 대한 조작 가능
			ps.setString( 1, dto.getMid() );
			ps.setString( 2, dto.getMpw() );
			// 4. ps가 sql 실행
			ps.executeUpdate();
			// 5. 결과 반환
			return true; // 문제 없었으면 저장 성공
		}
		catch( Exception e ) {
			System.out.println( "DB 오류 : " + e );
		}
		
		return false;
	}
	
	// ---------------------------------------------------------------------
	
	
	// 2. 모든 회원 출력 [ 인수 : x , 반환 : ArrayList 여러명회원 [ Member ] 
	public ArrayList<MemberDTO> list() {
		return null;
	}
	
}










