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
		
		ArrayList<MemberDTO> list = new ArrayList<>();
		
		// 1. SQL 작성
		String sql = "select * from member";
		// 2. 연결된 DB에 작성된 SQL 대입
		try{
			ps = conn.prepareStatement(sql);
		
			// 3. SQL 조작 [ 매개변수 없으므로 패스 ]
			
			// 4. SQL 실행 [ SQL 결과를 rs 인터페이스에 저장 ]
			rs = ps.executeQuery();	// 검색된 레코드들 존재
			
			// 5. SQL 결과
				// 레코드 -- 자바형태 --> 객체 DTO // 레코드1개 -> DTO 1개 -> 회원 1개
				while( rs.next() ) { // rs.next() : 다음 레크도르 이동 [ 없으면 false ] // 마지막 레코드까지 무한루프 

					// 레코드 --> 객체화 [ rs.get~~( 필드순서번호 ) ]
					MemberDTO dto = new MemberDTO( 
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3));
					// 1개 객체를 --> 리스트 담기 
					list.add(dto);
				}
			
		}
		catch( Exception e ) {
			System.out.println( "DB 오류 : " + e );
		}
		
		
		
		return list ;
	}
	
	
	// 3. 비밀번호 수정 [ 인수 : mno , newmpw  반환 : true or fasle ] 
	public boolean update( int mno , String mpw ) {
		
		// 1. SQL 작성
		String sql = "update member set mpw = ? where mno = ?";
		
		// 2. 연결 DB에 SQL 대입
		try {
			ps = conn.prepareStatement(sql);
			
			// 3. SQL 조작
			ps.setString( 1 , mpw ); 
			ps.setInt( 2 , mno );
			
			// 4. SQL 실행
			ps.executeUpdate(); // insert , update, delete -> executeUpdate();
								// select -> ps.executeQuery();
			
			// 5. SQL 결과
			return true;
		}
		catch (Exception e) {
			System.out.println("DB 오류 : " + e );
		}
		
		return false;
	}
	
	
	// 4. 회원탈퇴 [ 인수 : 회원번호 반환 : 성공 , 실패 ]
	public boolean delete( int mno ) {
		
		// 1. SQL 작성
		String sql = "delete from member where mno = ?";
		
		// 2. 연결 DB에 SQL 대입
		try {
			ps = conn.prepareStatement(sql);
			
			// 3. SQL 조작
			ps.setInt(1, mno);
			
			// 4. SQL 실행
			ps.executeUpdate();
			
			// 5. 결과
			return true;
			
		}
		catch( Exception e ) {
			System.out.println("DB 오류 : " + e );
		}
		return false;
	}
	
	
	
	
	
	
	
}










