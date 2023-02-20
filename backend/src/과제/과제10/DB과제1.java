package 과제.과제10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DB과제1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Connection con = null;
		
		while( true ) {
			
			try {
				System.out.println("1. DB 연결하기 / 2. SQL구문 직접 입력하기 / 3. 데이터추가하기");
				int ch = scanner.nextInt();
				
				if( ch == 1 ) {
					System.out.print("연동할 DB명 입력 : ");
					String db = scanner.next();
					System.out.println( db + "에 연결합니다.");
					
					con = DriverManager.getConnection(
								"jdbc:mysql://127.0.0.1:3306/"+db,
								"root",
								"1234"
							);
					System.out.println("정상적으로 연결되었습니다.");
					
				}
				else if( ch == 2 ) {
					
					System.out.print("-- sql 입력 : ");
					scanner.nextLine();
					String sql = scanner.nextLine();
					
					con.prepareStatement(sql).execute();
					System.out.println("구문이 실행되었습니다.");
					/*
					 	create table product (
					 		seq int not null auto_increment,
					 		name varchar(20),
					 		explanation varchar(100)
					 		price int,
					 		PRIMARY KEY (SEQ)
					 	);
					 	create table product ( seq int not null auto_increment, name varchar(20), explanation varchar(100), price int, PRIMARY KEY (SEQ) );
					 */
				}
				else if( ch == 3 ) {
					System.out.println("제품명 : "); String name = scanner.next();
					System.out.println("제품설명 : "); String explanation = scanner.next();
					System.out.println("제품가격 : "); int price = scanner.nextInt();
					
					String sql = "insert into product ( name, explanation , price ) values ( ? , ? , ? )";
					PreparedStatement ps = con.prepareStatement(sql);
					
					ps.setString(1, name);
					ps.setString(2, explanation);
					ps.setInt(3, price);
					
					ps.execute();
				}
			}
			catch( InputMismatchException e ) {
				System.out.println("숫자형식으로 입력해주세요");
			}
			catch( SQLException e) {
				System.out.println("[ SQL 오류 ] : " + e); 
			}
			catch( Exception e ) {
				System.out.println("DB 연결상태를 확인해주세요");
			}
			
		}
		
	}
	
}
 