package Day09.Ex10_게시판.view;


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Day09.Ex10_게시판.controller.Bcontroller;
import Day09.Ex10_게시판.model.Board;


public class Front {
	
	// 1. 싱글톤 객체 [ 1. 프로그램내 하나의 객체 - 공유 메모리 ]
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() {
		return front;
	}
	
	// 필드 : 입력 객체
	private Scanner scanner = new Scanner(System.in);
	
	// 2. index 함수
	public void index() {
		while( true ) {
			print_page();
			System.out.println(" 1. 쓰기 / 2. 상세 : ");
			int ch = scanner.nextInt(); // 지역변수
			if( ch == 1 ) { write_page(); }
			else if( ch == 2 ) { view_page(); }
		}
	}
	
	// 3. 쓰기 페이지 함수
	private void write_page() {
		System.out.println("----------- 글쓰기 -----------");
		System.out.print("제목 : "); String title = scanner.next();
		scanner.nextLine();
		System.out.print("내용 : "); String content = scanner.nextLine();
		System.out.println("작성자 : "); String writer = scanner.next();
		System.out.println("비밀번호 : "); String password = scanner.next();
		Date date = new Date();
		int view = 0;
		
		boolean result = Bcontroller.getInstance().write(title, content, writer, password, date, view);
		
		if (result ) {
			System.err.println(" 새 글이 작성되었습니다. ");
		}else {
			System.err.println(" 글쓰기 실패 ");
		}
		
	}
	
	// 4. 출력 페이지 함수
	private void print_page() {
		System.out.println("번호\t\t조회수\t\t작성자\t\t제목\t\t작성일");
		
		// 1. 싱글톤 객체를 통해 boardDb 리스트 객체 반환 받기
		ArrayList<Board> result = Bcontroller.getInstance().getBoardDb();
		
		// 2. 반환된 리스트객체 수 만큼 반복
		for( int i=0; i<result.size(); i++ ) {
			// 3. 리스트내 i번째 객체를 출력
			System.out.println( i + "\t\t" + result.get(i).toString() );
		}
		System.out.println();
	}
	
	private void view_page() {
		System.out.println("게시물 번호 : "); int bno = scanner.nextInt();
		Board result = Bcontroller.getInstance().view( bno );
		System.out.println( "제목 : " + result.getTitle() );
		System.out.println( "작성자 : " + result.getWriter() + "\t작성일 : " + result.getDate() + "\t조회수 : " + result.getView() );
		System.out.println("내용 : " + result.getContent() );
		System.out.println();
		System.out.println(" >> 1.뒤로가기 2.삭제 3.수정 : ");
		int ch = scanner.nextInt(); 
		if( ch == 1 ) { return; }
		else if( ch == 2 ) {
			System.out.println("패스워드 : "); String password = scanner.next();
			String result2 = Bcontroller.getInstance().password_check(password, bno);
			if( result2.equals("Y") ) {
				System.err.println("글이 삭제되었습니다.");
			}else {
				System.err.println("패스워드가 일치하지 않습니다.");
			}
		}
		else if( ch == 3 ) {
			System.out.println("수정할 내용 : "); String content = scanner.next();
			
		}
	}
	
}
