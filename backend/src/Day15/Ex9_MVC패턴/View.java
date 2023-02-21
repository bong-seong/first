package Day15.Ex9_MVC패턴;

import java.util.Scanner;

public class View {

	// 싱글톤
	private static View view = new View();
	private View() {}
	public static View getInstance() {
		return view;
	}
	
	
	private Scanner scanner = new Scanner(System.in);
	
	public void index() {
		
		while( true ) {
			System.out.println("1. 등록[C] / 2. 출력[R] / 3. 수정[U] / 4. 삭제[D] ");
			
			int ch = scanner.nextInt();
			if( ch == 1 ) { signup(); }
			else if( ch == 2 ) { list(); }
			else if( ch == 3 ) {}
			else if( ch == 4 ) {}
		}
	}
	
	
	public void signup() {
		
		System.out.println("------- 등록[C] -------");
		System.out.print("아이디 : ");
		String mid = scanner.next();
		
		System.out.print("비밀번호 : ");
		String mpw = scanner.next();
		
		boolean result = Controller.getInstance().signup(mid, mpw);
		
		if( result ) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
	}
	
	
	public void list() {
		
	}
	
}
