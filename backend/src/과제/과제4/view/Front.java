package 과제.과제4.view;
// * 입출력 : print, scanner

import java.util.Scanner;

import 과제.과제4.controller.Bcontroller;
import 과제.과제4.controller.Mcontroller;
import 과제.과제4.model.Board;

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
			// Mcontroller의 memberDb 리스트에 인덱스값을 전달하여 memberDb.get(result).id 리턴받음
			// 이후 writer 에 id 값 저장
			String writer = mc.findWriter( result ); 			System.err.println("로그인 성공 !!!");
			System.out.println(  writer + "님 환영합니다."); 
			
			while( true ) {
				System.out.println("---------------------------- 커뮤니티 ----------------------------");
				System.out.println("번호\t\t조회수\t\t작성자\t\t제목");
				totalView();
				System.out.println();
				System.out.println("메뉴 >> 1. 글쓰기 / 2. 게시물보기 / 3. 로그아웃"); int ch = scanner.nextInt();
				
				if( ch == 1 ) { writePost( result ); } // 글작성 함수 실행시 인덱스값( result ) 인수로전달
				else if( ch == 2 ) { viewPost( writer ); } // 글 보기 함수에 앞서 반환받은 String id 값을 전달 
				else if( ch == 3 ) {
					System.err.println("[로그아웃] 안녕하가세요, " + writer + "님");
					break ; // while 반복문 종료
				} // 로그아웃
				else { System.err.println(" !!!! 알수없는 행동입니다. !!!! "); }
			}
			
			
			
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
		}else if( result.equals("N") ) {
			System.err.println("존재하지 않는 회원입니다.");
		}else {
			System.out.println("패스워드 : " + result );
		}
	}
	
	
	// 전체 게시물 출력
	void totalView() { 
		// public 선언된 boardDb 리스트 호출하여 전체 게시물 출력
		for( int i=0; i<bc.boardDb.size(); i++ ) {
			System.out.println( i + "\t\t" + bc.boardDb.get(i).count + "\t\t" + bc.boardDb.get(i).id + "\t\t" + bc.boardDb.get(i).title );
		}
	}
	
	// 1-1. 게시물 작성하기
	void writePost( int i ) { 
		System.out.println("---------------------------- 새 글 작성하기 ----------------------------");
		System.out.print("제목 : "); String title = scanner.next(); 
		scanner.nextLine();
		System.out.print("내용 : "); String content = scanner.nextLine();
		
		String id = mc.findWriter( i ); // 전달받은 인수값으로 아이디찾기 함수를 사용해 db에서 id (String) 값 반환받음
		String result = bc.savePost(title, content, id );
		if( result == null ) { System.out.println( id + "님의 글이 작성되었습니다."); }
	}
	
	// 1-2. 게시물 보기
	void viewPost( String writer ) { // 작성자 인수값으로 받음 
		String id = writer; // 모델에 설계한 필드명과 동일하게 맞추어줌 ( 단순 헷갈림 방지 )
		System.out.print("열람 하실 글의 번호를 입력해주세요 >> "); int ch = scanner.nextInt();
		// post 에 가져온 객체를 저장 boardDb.get(ch); 
		Board post =  bc.viewPost(ch, id);
		System.out.println("---------------------------- " + "[ " + ch + " ]" + post.title + " ----------------------------");
		System.out.println("제목 : " + post.title );
		System.out.println("작성자 : " + post.id );
		System.out.println("내용 : " + post.content );
		System.out.println();
		System.out.println("메뉴 >> 1. 삭제하기 / 2. 수정하기 / 3. 뒤로가기"); int postCh = scanner.nextInt();
		
		if( postCh == 1 ) { 
			String delete = bc.delPost( ch , id); // bc.delPost 에 인수값으로 글 인덱스(ch)와 작성자아이디 전달 
			if ( delete.equals("del")) { 		  // 이후, controller 에서 유효성 체크 후 결과값 리턴받음
				//리턴받은 값이 "del" 일경우 삭제안내메시지 프린트 
				System.err.println("해당 글이 삭제되었습니다.");
			}else { // 아닐경우 삭제실패 안내메시지 프린트
				System.err.println("경고 : 본인이 작성한 글만 삭제 가능합니다.!!");
			}
		}
		else if( postCh == 2 ) {
			System.out.println("---------------------------- 수정하기 ----------------------------");
			System.out.print("수정할 내용 : ");
			scanner.nextLine();
			String editContent = scanner.nextLine();
			// 새로운 content 를 입력받아 함수의 인수값으로 전달
			String edit = bc.editPost( ch, id, editContent);
			if ( edit.equals("edit") ) {
				System.err.println("글이 수정되었습니다.");
			}else {
				System.err.println("경고 : 본인이 작성한 글만 수정 가능합니다.!!");
			}
		}
		else if( postCh == 3 ) {} // 별다른 조치를 하지 않았지만 해당함수를 호출한곳에서 while 반복문을 돌아 로그아웃된것처럼 보여짐..
		
	}
	
	
	
	
}
