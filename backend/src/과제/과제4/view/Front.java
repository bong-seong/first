package 과제.과제4.view;
// * 입출력 : print, scanner

import java.util.Scanner;

import 과제.과제4.controller.Bcontroller;
import 과제.과제4.controller.Mcontroller;

public class Front {
	
	Scanner scanner = new Scanner(System.in);
	Mcontroller mc = new Mcontroller();
	Bcontroller bc = new Bcontroller();
	
	// 1. 메인페이지
	public void index() {
		while( true ) {
			System.out.print("1. 회원가입 / 2. 로그인 / 3. 아이디 찾기 / 4. 비밀번호 찾기 >>> ");
			int ch = scanner.nextInt();
			if( ch == 1 ) { signup(); }
			else if( ch == 2 ) { login(); }
			else if( ch == 3 ) { findId(); }
			else if( ch == 4 ) { findPassword(); }
			else { System.err.println(" !!!! 알수없는 행동입니다. !!!! "); }
		}
	}
	
	// 2. 회원가입 페이지
	void signup() {
		System.out.print("아이디 : ");		String id = scanner.next();
		System.out.print("비밀번호 : ");		String pwd = scanner.next();
		System.out.print("비밀번호 확인 : ");	String confirmpwd = scanner.next();
		System.out.print("이름 : ");			String name = scanner.next();
		System.out.print("전화번호 : ");		String phone = scanner.next();
		
		int result = mc.signup( id, pwd, confirmpwd , name , phone );
		if (result == 1) { System.err.println("[알림] 회원가입 실패"); }
		else if( result == 0 ) { System.err.println("[알림] 회원가입 성공"); }
		
		
	}
	// 3. 로그인 페이지
	void login() {
		System.out.print("아이디 : "); String id = scanner.next();
		System.out.print("비밀번호 : "); String pwd = scanner.next();
	
		int result = mc.login(id, pwd);
		if( result >= 0 ) { // 0~자
			// 게시판으로 이동
			System.err.println("로그인 성공 !!!");
			
			System.out.println("---------------------------- 커뮤니티 ----------------------------");
			System.out.println("번호\t\t조회수\t\t작성자\t\t제목");
			System.out.println();
			System.out.println("메뉴 >> 1. 글쓰기 / 2. 게시물보기 / 3. 로그아웃"); int ch = scanner.nextInt();
			
			if( ch == 1 ) { writePost( result ); }
			else if( ch == 2 ) { viewPost(); }
			else if( ch == 3 ) { index(); } // 로그아웃
			else { System.err.println(" !!!! 알수없는 행동입니다. !!!! "); }
			
			
			
		}else if( result == -1 ) {
			System.err.println("[알림] 비밀번호가 다릅니다.");
		}else if( result == -2 ) {
			System.err.println("[알림] 존재하지 않는 아이디입니다.");
		}
	}
	
	// 4. 아이디 찾기 페이지
	void findId() {
		System.out.print("이름 : ");		String name = scanner.next();
		System.out.print("전화번호 : ");	String phone = scanner.next();
		
		String result = mc.findId(name, phone);
		
		if( result.equals("Y")) {
			System.err.println("전화번호가 일치하지 않습니다.");
		}else if( result.equals("N")) {
			System.err.println("존재하지 않는 회원입니다.");
		}else {
			System.out.println("아이디 : " + result );
		}
		
	}
	// 5. 비밀번호 찾기 페이지
	void findPassword() {
		System.out.print("아이디 : ");	String id = scanner.next();
		System.out.print("전화번호 : ");	String phone = scanner.next();
		
		String result = mc.findPassword(id, phone);
		
		if( result.equals("Y")) {
			System.err.println("전화번호가 일치하지 않습니다.");
		}else if( result.equals("N")) {
			System.err.println("존재하지 않는 회원입니다.");
		}else {
			System.out.println("패스워드 : " + result );
		}
	}
	
	
	// 1-1. 게시물 작성하기
	void writePost( int i ) { 
		System.out.println("---------------------------- 새 글 작성하기 ----------------------------");
		System.out.println("제목 : "); String title = scanner.next(); 
		scanner.nextLine();
		System.out.println("내용 : "); String content = scanner.nextLine();
		
		String writer = mc.findWriter( i );
		String result = bc.savePost(title, content, writer);
		if( result == null ) { System.out.println( writer + "님의 글이 작성되었습니다."); }
	}
	
	// 1-2. 게시물 보기
	void viewPost() { }
	
	
	
	
}
