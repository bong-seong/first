package 과제.중고거래.view;

import java.util.Scanner;

public class Front {

	// * 싱글톤
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() { return front; }
	
	private Scanner scanner = new Scanner(System.in);
	
	// 1. 로그인페이지
	public void index() {
		while( true ) {
			System.out.print("1. 회원가입 / 2. 로그인 >> ");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) {}
			else if( ch == 2 ) {}
			
			
		}
	}
	
	// 2. 메인페이지
		// 제품출력
	
		// 메뉴 :  마이페이지 / 제품등록 / 제품 상세보기 / 로그아웃 
	
	// 3. 제품 등록페이지
	
	// 4. 제품 상세페이지 
	
	// 5. 마이페이지
		// 개인 쪽지 목록 출력
	
	// 6. 쪽지 상세페이지
	
}


