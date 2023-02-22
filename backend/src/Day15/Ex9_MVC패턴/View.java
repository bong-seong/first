package Day15.Ex9_MVC패턴;

import java.util.ArrayList;
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
			else if( ch == 3 ) { update(); }
			else if( ch == 4 ) { delete(); }
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
		
		System.out.println("-------------------------");
		System.out.println("회원번호\t\t아이디\t\t비밀번호");
		
		ArrayList<MemberDTO> result = Controller.getInstance().list();
		
		for( int i=0; i<result.size(); i++ ) {
			System.out.printf("%d\t\t%s\t\t%s\t\t\n" , result.get(i).getMno() , result.get(i).getMid() , result.get(i).getMpw() );
		}
		
	}
	
	
	public void update() {
		System.out.println("-------------------------");
		System.out.println("회원번호 : ");
		int mno = scanner.nextInt();
		
		System.out.println("새로운 비밀번호 : ");
		String mpw = scanner.next();
		
		boolean result = Controller.getInstance().update(mno, mpw);
		
		if( result ) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
	} // update end
	
	
	// 회원 삭제
	public void delete() {
		System.out.println("-------------------------");
		System.out.println("회원번호 : ");
		int mno = scanner.nextInt();
		
		boolean result = Controller.getInstance().delete(mno);
		
		if( result ) {
			System.out.println("회원탈퇴 성공");
		}else {
			System.out.println("회원탈퇴 실패");
		}
		
	}
	
	
}

















