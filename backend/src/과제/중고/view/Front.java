package 과제.중고.view;

import java.util.Scanner;

import 과제.중고.controller.Mcontroller;
import 과제.중고.model.Member;

public class Front {

	// * 싱글톤
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() { return front; }
	
	private Scanner scanner = new Scanner(System.in);
	
	
	// 1. 로그인메뉴 페이지
	public void index() {
		while( true ) {
			System.out.println("---------- 오이마켓 -----------");
			System.out.println("메뉴 >> 1. 로그인 / 2. 회원가입");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) { login_page(); }
			else if( ch == 2 ) { signup_page(); }
			
		}
	}
	
	
	// 2. 회원가입 페이지
	public void signup_page() {
		System.out.println("---------- 회원가입 -----------");
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("비밀번호 : ");		String pw = scanner.next();
		System.out.println("비밀번호 확인 : ");	String confirmpw = scanner.next();
		System.out.println("이름 : ");		String name = scanner.next();
		System.out.println("전화번호 : ");		String phone = scanner.next();
		
		int result = Mcontroller.getInstance().signup(id, pw, confirmpw, name, phone);
		
		if( result == -1 ) {
			System.out.println("[알림] 회원등록에 실패하였습니다.");
		}else {
			System.out.println("[알림] 회원등록 완료!! 환영합니다.");
		}
		
	}
	
	
	// 3. 로그인 페이지
	public void login_page() {
			System.out.println("---------- 로그인 -----------");
			System.out.println("아이디 : ");		String id = scanner.next();
			System.out.println("비밀번호 : ");		String pw = scanner.next();
			
			int result = Mcontroller.getInstance().login(id, pw);
			
			if( result == -1 ) { System.out.println("[알림] 로그인실패, 다시한번 확인해주세요");}
			else { System.out.println("환영합니다, 즐거운 쇼핑되세요 😎"); main_page( result ); }
	}
	
	// 4. 로그인 후 메인페이지
	public void main_page( int seq ) {
		while( true ) {
			int loginSession =  Mcontroller.getInstance().getMemberDB().get(seq).getSeq();
			System.out.println("---------- MAIN -----------");
			System.out.println("안녕하세요, " + Mcontroller.getInstance().getMemberDB().get(seq).getName() + "님!" + "\t\t");
			System.out.println(	"회원번호 : " + loginSession +"\t\t메세지함 : ");
			System.out.println();
			System.out.println("무엇을 하시겠습니까 ?");
			System.out.println("메뉴 >> 1. 마이페이지 / 2. 전체상품보기 / 3. 상품등록하기 / 4. 로그아웃");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) {}
			else if( ch == 2 ) {}
			else if( ch == 3 ) {}
			else if( ch == 4 ) {
				System.out.println("이용해주셔서 감사합니다. 안녕히가세요.");
				break;
			}
			
		}
	}
	
	// 마이페이지
	
	// 전체상품보기 페이지
	
	// 제품 등록하기 페이지
	public void reg_page(){
		System.out.println("등록할 제품명을 입력해주세요 >> ");
		
	}
	
	
	
	
	
}
