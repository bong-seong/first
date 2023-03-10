package Day07.Ex6;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex6_회원시스템_컬렉션프레임워크 { // class s
	
	public static void main(String[] args) { // main s
		
		Scanner scanner = new Scanner(System.in);
		
		// 배열 대신 컬렌션 프레임워크
		ArrayList<Member> memberList = new ArrayList<>(); // 가변길이
			// ArrayList : 리스트 선언시 사용되는 클래스
			// <클래스명> : 리스트 안에 항목의 들어갈 자료형/타입 ( 클래스 )
		while( true ) {
			
			// js (인수)=>{실행문;} 익명화살표 vs  람다식 JAVA : (인수)->{실행문;}
			/*
			memberList.forEach( ( o )->{ 
				System.out.println( o );
			});
			*/ 
			
			// 배열명.length : 배열내 길이 			[ 고정길이 ]
			// 리스트명.size() : 리스트내 요소들의 개수	[ 가변길이 ]
			System.out.println("번호\t회원명\t전화번호");
			for( int i=0; i<memberList.size(); i++ ) {
				System.out.println( i + "\t" + memberList.get(i).name + "\t" + memberList.get(i).phone );
			}
			
			System.out.printf("1. 회원등록 / 2. 회원삭제 >>> ");
			int ch = scanner.nextInt();
			if( ch == 1 ) {
				System.out.printf("회원명 : "); 	String name = scanner.next();
				System.out.printf("전화번호 : "); 	String phone = scanner.next();
				
				// "," 대신 객체
				Member member = new Member();
				member.name = name; member.phone = phone;
				memberList.add(member); // 리스트에 객체 추가 // js : push()
				
				
			}else if( ch == 2 ) {
				System.out.printf("삭제할 번호/인덱스 : ");
				int no = scanner.nextInt();
				memberList.remove( no );
			}else {
				
			}
		}
		
	} // main e

} // class e

