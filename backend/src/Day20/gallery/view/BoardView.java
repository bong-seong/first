package Day20.gallery.view;

import java.util.ArrayList;
import java.util.Scanner;

import Day20.gallery.controller.Bcontroller;
import Day20.gallery.controller.Mcontroller;
import Day20.gallery.model.dto.BoardDTO;
import Day20.gallery.model.dto.CategoryDTO;


public class BoardView {
	
	private static BoardView bv = new BoardView();
	private BoardView() {}
	public static BoardView getInstance() {
		return bv;
	}
	
	private Scanner scanner = new Scanner(System.in);
	
	// 1. 게시물 [ 모든게시물 ]
	public void index() {
		while( true ) {
			System.out.println("--------------- 이젠 갤러리 ---------------");
			
			boardPrintRecent();// 최신 게시물 3개 출력
			System.out.println(); System.out.println();
			categoryPrint(); // 모든 갤러리 출력
			System.out.println(); System.out.println();
			System.out.println("-1: 로그아웃 / 0: 갤러리추가 / 이동할 갤러리 번호 선택 : ");
			int ch = scanner.nextInt();
			if( ch == -1 ) { 
				Mcontroller.getInstance().setLoginSession(0); // 로그인세션 초기화
				System.out.println("[로그아웃] 안녕히가세요!!");
				break;
			}
			if( ch == 0 ) {
				categoryAdd();
			}else if( ch > 0 ) {
				boardPrint(ch);
			}
			
		}
		
	}
	
	// 2. 카테고리 추가
	public void categoryAdd() {
		System.out.println("--------------- 갤러리 추가 ---------------");
		System.out.print("추가할 갤러리 이름 : ");
		
		scanner.nextLine();
		String cname = scanner.nextLine();
		
		boolean result = Bcontroller.getInstance().categoryAdd(cname);
		if( result ) {System.out.println("등록성공, 갤러리가 추가 되었습니다.");}
		else {System.out.println("등록실패, 관리자에게 문의하세요");}
	}

	// 3. 모든 카테고리=갤러리 [ 갤러리 1개 = dto 1개 / 갤러리여러개 = dto 여러개 = 배열 혹은 리스트 ] 호출
	public void categoryPrint() {
		
		ArrayList<CategoryDTO> clist = Bcontroller.getInstance().categoryPrint(); 
		
		/*
		for( int i=0; i<clist.size(); i++ ) {
			System.out.print( clist.get(i).getCno() + " - " + clist.get(i).getCname() + "\t");
			if( i % 4 == 0 ) { System.out.println();} // 4개마다 줄바꿈
		}
		*/
		
		int count = 0;
		for( CategoryDTO dto : clist ) {
			System.out.print( dto.getCno() + " - " + dto.getCname() + "\t");
			count++;
			if( count % 4 == 0 ) { System.out.println();} // 4개마다 줄바꿈
		}
		
				
	}

	
	
	// 4. 게시물 등록 페이지
	public void boardAdd( int cno ) {
		System.out.println("--------------- 게시물 쓰기 ---------------");
		System.out.println("제목 : "); String btitle = scanner.next();
		System.out.println("내용 : "); String bcontent = scanner.next();
		
		int mno = Mcontroller.getInstance().getLoginSession();
		
		boolean result = Bcontroller.getInstance().boardAdd( btitle, bcontent , cno );
		if( result ) { System.out.println("글 등록 성공");}
		else { System.out.println("글 등록 실패");}
	}
	
	
	// 5. 최신 게시물 
	public void boardPrintRecent() {
		
		ArrayList<BoardDTO> blist = Bcontroller.getInstance().boardPrintRecent();
		System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s" , "번호" , "제목" ,"작성자" , "조회수" , "갤러리" , "작성일\n");
		for( BoardDTO dto : blist ) {
			System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n" , 
					dto.getBno() , dto.getBtitle() , dto.getMid() , dto.getBview() , dto.getCname() , dto.getBdate() );
		}
	}
		
	
	
	
	// 6. 해당 카테고리의 모든 게시물 출력
	public void boardPrint( int cno ) {
		
		System.out.println("--------------- 선택한 갤러리 ---------------");
		
		ArrayList<BoardDTO> blist = Bcontroller.getInstance().boardPrint(cno);
		
		System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s" , "번호" , "제목" ,"작성자" , "조회수" , "작성일\n");
		for( BoardDTO dto : blist ) {
			System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\n" , 
					dto.getBno() , dto.getBtitle() , dto.getMid() , dto.getBview() , dto.getBdate() );
		}
		
		System.out.println();
		while( true ) {
			System.out.print("갤러리 메뉴 : 1.뒤로가기 / 2. 게시물쓰기 / 3. 게시물보기 : ");
			int ch = scanner.nextInt();
			
			if(ch == 1 ) { break; }
			else if( ch == 2 ) { boardAdd( cno ); }
			else if( ch == 3 ) { }
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
