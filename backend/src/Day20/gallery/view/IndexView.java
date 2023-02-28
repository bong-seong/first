package Day20.gallery.view;

import java.util.Scanner;

import Day20.gallery.controller.Mcontroller;

public class IndexView {

	
	private static IndexView index = new IndexView();
	private IndexView() {}
	public static IndexView getInstance() {
		return index;
	}
	
	private Scanner scanner = new Scanner(System.in);
	
	
	
	
	// 1. 메인페이지
	public void index() {
		while( true ) {
			System.out.println("--------------- 이젠 갤러리 ---------------");
			System.out.print("1. 로그인 / 2.회원가입 : ");
			
			try {
				int ch = scanner.nextInt();
				if( ch == 1 ) { login(); }
				else if( ch == 2 ) { signup(); }
			}catch (Exception e) {
				System.err.println("[알림] 잘못된 입력입니다.");
				scanner = new Scanner(System.in);
			}
		}
	}
	
	// 2. 회원가입
	public void signup() throws Exception { // 만일 해당 메소드에서 예외[오류] 발생하면 해당 메소드를 호출했던 곳으로 예외 이동
		System.out.println("--------------- 회원가입 ---------------");
		
		System.out.print("아이디 : ");
		String mid = scanner.next();
		
		System.out.print("비밀번호 : ");
		String mpw = scanner.next();
		
		System.out.print("이름 : ");
		String mname = scanner.next();
		
		System.out.print("전화번호 : ");
		String mphone = scanner.next();
		
		int result = Mcontroller.getInstance().signup(mid, mpw, mname, mphone);
		
		if ( result == 1 ) { System.out.println("[완료] 회원가입이 되었습니다.");}
		else if( result == 2 ) { System.out.println("[실패] 사용중인 아이디 입니다.");}
		else if( result == 3 ) { System.out.println("[실패] 시스템오류 : 관리자에게 문의하여주세요");}
	}
	
	
	// 3. 로그인 페이지
	public void login() throws Exception {
		System.out.println("--------------- 로그인 ---------------");
		
		System.out.print("아이디 : ");
		String mid = scanner.next();
		
		System.out.print("비밀번호 : ");
		String mpw = scanner.next();
	
		boolean result = Mcontroller.getInstance().login(mid, mpw);
		
		if( result ) { 
			System.out.println("로그인 성공");
			// 게시물 초기메뉴로 이동
			BoardView.getInstance().index();
		}
		else { System.out.println("로그인 실패, 아이디와 비밀번호를 확인해주세요"); }
	}
	
	
	
	
}
