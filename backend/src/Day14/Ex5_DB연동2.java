package Day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex5_DB연동2 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Connection conn = null ;// 여러 if{} 안에서 사용하기 위해 밖에 생성
		
		while( true ) {
			
			try { // 1. 예외가 발생할것 같은 코드 [ 예상: nextInt() 인데 문자열 입력시 예외 발생 ]
				System.out.println("1. DB연결 2. SQL구문 삽입 3. 매개변수 구문 삽입 :");
				int ch = scanner.nextInt();
				
				if( ch == 1 ) {
					System.out.print("연동할 DB명 입력 : ");
					String dbname = scanner.next();
					System.out.println( dbname + "에 연결합니다.");
					
					// * 
					conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/"+dbname ,
							"root",
							"1234" );
					System.out.println("연결 성공!!");
					
				}
				else if( ch == 2 ) {
					System.out.print("-- sql 입력 : ");
					scanner.nextLine(); // * scanner.next(); 앞에있으면 한번 더 써서 오류방지해주어야함
					String sql = scanner.nextLine();
					
					// * 연결된 DB 객체에 SQL 대입 [ PreparedStatement 매개변수 처리 ]
					conn.prepareStatement(sql).execute() ;
					
					// * sql 실행
					
					
				}
				else if( ch == 3 ) {
					System.out.println("번호 : ");		int mno = scanner.nextInt();
					System.out.println("아이디 : ");		String id = scanner.next();
					System.out.println("비밀번호 : ");		String pwd = scanner.next();
					// * sql 구문 작성
					String sql = "insert into member values ( ? , ? , ? );";
				//  String sql = "insert into member values ( mno , id , pwd );"
					PreparedStatement ps = conn.prepareStatement(sql);
					// * ? 매개변수에 데이터변수를 대입
					ps.setInt(1, mno);		// 1 : sql 구문에서 첫번짜 ? 자리 
					ps.setString(2, id);	// 2 : 두번째 ?
					ps.setString(3, pwd);	// 3 : 세번째 ?
					// * 실행
					ps.executeUpdate();
				}
				
			}catch( InputMismatchException e ){ // 2. try{ } 에서 예외 발생하면 실행되는 코드
				System.out.println("알수없는 번호 입니다.");
				scanner = new Scanner(System.in); // 기존에 입력된 데이터를 제거
			}catch( SQLException e ) {
				System.out.println(" [SQL 오류 ] : " + e );
			}catch( Exception e ) {
				System.out.println(" [ DB 연결 후 다시 실행 ] ");
			}
					
			
			
		}
		
		
	}

}
