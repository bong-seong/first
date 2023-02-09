package Day07.Ex4;

import java.util.Scanner;

public class Ex4_회원시스템_객체 { // class s

	public static void main(String[] args) { // main s
		
		Scanner scanner = new Scanner(System.in);
		
		Member[] memberList = new Member[3];	// Member 객체 3개를 저장할수 있는 배열 선언
												// Member객체 String 개 저장할수 있다
		while( true ) { // while s
			
			// * 출력
			System.out.println("번호\t회원명\t전화번호");
			for( int i=0; i<memberList.length; i++ ) {
				if( memberList[i] != null ) {
					System.out.println( i + "\t" + memberList[i].name + "\t" + memberList[i].phone );
				}
			}
			
			System.out.print("1. 회원등록 / 2. 회원삭제 >>> ");
			int ch = scanner.nextInt();
			if( ch == 1 ) {
				System.out.printf("회원명 : "); 	String inputname = scanner.next();
				System.out.printf("전화번호 : "); 	String inputphone = scanner.next();
				
				for( int i=0; i<memberList.length; i++ ) {
					if( memberList[i] == null ) {
						Member member = new Member();	// 1. 객체 생성
						member.name = inputname; 		// 2. 객체에 입력받은 값을 해당 필드에 대입
						member.phone = inputphone;		// 3. 객체에 입력받은 값을 해당 필드에 대입
						memberList[i] = member;			// 4. 객체를 배열에 저장
						break;
					}
						
				}
				// [ X ] name + "," + phone
				// [ O ] 객체 만들기
				
				
						
				
			}else if( ch == 2 ) {
				
			}else {
				
			}
			
		} // while e 
		
	} // main e
	
} // class e
