package 과제.과제3;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {

	public static void main(String[] args) {
		
		// * 입력객체
		Scanner scanner = new Scanner(System.in);
		
		// * [ Book 객체를 여러개 저장할 리스트 ]
		ArrayList<Book> bookList = new ArrayList<>();
		ArrayList<Member> memberList = new ArrayList<>();
		
		while( true ) {
			
			// 로그인 체크
			System.out.println("어서오세요, 이젠 도서관입니다.");
			System.out.println("무엇을 도와드릴까요 ? [ 1. 로그인 / 2. 회원가입 / 3. 나가기 ]");
			System.out.print(" >>> ");
			int chMenu = scanner.nextInt();
			
			
			if( chMenu == 1 ) {
				
				System.out.println("--------------------------- 로그인 ---------------------------- ");
				System.out.print("아이디 : "); 	String user = scanner.next();
				System.out.print("패스워드 : ");	String pwd = scanner.next();
				for( int i=0; i<memberList.size(); i++ ) {
					if( memberList.get(i).user.equals(user) &&  memberList.get(i).pwd.equals(pwd) ) {
						// 모든 도서목록 출력
						System.out.println("--------------------------- 이젠 도서관 ---------------------------- ");
						System.out.println("번호\t\t대여여부\t\t도서장르\t\t도서명");
						System.out.println("----------------------------------------------------------------- ");
						
						
						for( int j=0; j<bookList.size(); j++ ) {
							System.out.println( j + "\t\t" + ( bookList.get(j).state ? "대여가능" : "대여중" ) + "\t\t" + bookList.get(i).genre + "\t\t" + bookList.get(i).name );		
						}
						
						System.out.println();
						System.out.println("메뉴 > 1. 도서대여 / 2. 도서반납 / 3. 도서등록[관리자]");
						System.out.print(" >>> ");
						int ch = scanner.nextInt();
						
						if( ch == 1 ) {
							
							// 도서대여
							System.out.print("대여할 도서 번호를 입력해주세요 >> ");
							int no = scanner.nextInt();
							if( bookList.get(no).state == true ) { // 입력받은 번호의 도서의 state 값이 true( 대여가능 ) 일 경우 
								System.err.println( bookList.get(no).name + "을(를) 대여하였습니다.");
								bookList.get(no).state = false; // 대여중으로 변경
								
								Member member = new Member();
								member.rentList.add(null);
								
							}else {
								System.err.println("[알림] 이미 대여된 도서입니다.");
							}
							
							
							
						}else if( ch == 2 ) {
							
							System.out.print("반납할 도서 번호를 입력해주세요 >> "); int no = scanner.nextInt();
							if( bookList.get(no).state == false ) {
								System.err.println( bookList.get(no).name + "을(를) 반납하였습니다.");
								bookList.get(no).state = true;
							}else {
								System.err.println("[알림] 대여가 불가능한 도서입니다.");
							}
							
						}else if( ch == 3 ) {
							System.out.println("--- 등록 페이지 --- ");
							
							// 1. 입력받기 
							System.out.print("등록할 도서명을 입력하세요 >> "); 	String name = scanner.next();
							System.out.print("도서의 장르를 입력하세요 >> ");		String genre = scanner.next();
																			boolean state = true;
							
							// 2. 서로 다른 자료형의 변수들을 하나의 자료형으로 만들기 [ 클래스 ] --> Book 으로 묶기
							Book book = new Book();
							book.name = name; book.genre = genre; book.state = state;
							
							// 3. 배열 or 리스트 저장
							bookList.add( book );
							
							
							
						}else {
							System.err.println("[알림] 알수 없는 행동 입니다.");
						}
						
						
						
					}else {
						System.err.println("아이디 또는 비밀번호를 확인해주세요!! [ 로그인 실패 ]");
					}
				}
				
			}else if ( chMenu == 2 ){
				
				System.out.println("--------------------------- 회원 가입 ---------------------------- ");
				
				Member member = new Member();
				
				System.out.print("아이디를 입력해주세요 >> ");		String user = scanner.next();
				System.out.print("패스워드를 입력해주세요 >> ");	String pwd = scanner.next();
				System.out.print("이름을 입력해주세요 >> ");		String name = scanner.next();
				System.out.print("전화번호를 입력해주세요 >> ");	String phone = scanner.next();
				
				member.user = user; member.pwd = pwd; member.name = name; member.phone = phone;
				memberList.add(member);
				
				System.err.println( member.name +"님의 가입이 완료되었습니다.");
				
				
			}else if ( chMenu == 3 ) {
				System.err.println("안녕히가세요");
				break;
			}else {
				System.err.println("[알림] 알수 없는 행동 입니다.");
			}
			
			
			
			
		}
		
	}
	
}
