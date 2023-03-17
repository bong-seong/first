package controller.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.BoardDto;
import model.dto.PageDto;


@WebServlet("/board/info") // ! : 프로젝트내 동일한 서블릿주소 있을경우 서버자체 안켜짐
public class Boardinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Boardinfo() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type = Integer.parseInt( request.getParameter("type") ); 
		
		if( type == 1 ) { // 전체 출력
			
			// ----------------- 카테고리 별 출력 ---------------------
			// 1. 카테고리 매개변수 요청 [ cno ]	2. gettotalsize / getBoardList 조건 전달 
			int cno = Integer.parseInt( request.getParameter("cno") );
			
			
			// ----------------- 검색 처리 ---------------------
			// 1. 검색에 필요한 매개변수 요청 [ key , keyword ]	/ 2. gettotalsize / getBoardList 조건 전달 
			String key = request.getParameter("key");			System.out.println("key : " + key);
			String keyword = request.getParameter("keyword");	System.out.println("keyword : " + keyword);
			
			// ----------------- page 처리 ---------------------
			// 1. 현재페이지[요청] , 2. 페이지당 표시할 게시물수 , 3. 현재페이지[ 게시물시작번호 , 게시물끝 ] 
			int page = Integer.parseInt( request.getParameter("page") );
			int listsize = Integer.parseInt( request.getParameter("listsize") ); // 화면에 표시할 게시물수 요청
			int startrow = (page-1)*listsize; // 해당 페이지에서의 게시물 시작번호
			
			// ---------------------- page 버튼 만들기 --------------------- //
			// 1. 전체페이지수[ 총게시물레코드수/페이지당 표시수 ] , 2. 페이지 표시할 최대버튼수 , 3. 시작버튼/마지막버튼 번호
				// 1. 검색이 없을때
			// int totalsize = BoardDao.getInstance().gettotalsize();
				// 2. 검색이 있을때
			int totalsize = BoardDao.getInstance().gettotalsize( key , keyword , cno );
			int totalpage = totalsize % listsize == 0 ? totalsize/listsize : totalsize/listsize+1 ;
			
			int btnsize = 5; // 최대 페이징버튼 출력수 
			int startbtn = ( (page-1) / btnsize ) * btnsize + 1 ;
			
			
					/*
					 		1페이지 : 1-1 / 5 + 1 				-> 0*5+1 		1
					 		2페이지 : 2-1 / 5 + 1				-> 0*5+1 		1
					 		3페이지 : 3-1 / 5 + 1				-> 0*5+1 		1
					 		4페이지 : 4-1 / 5 + 1				-> 0*5+1 		1
					 		5페이지 : 5-1 / 5 + 1				-> 0*5+1 		1
					 		6페이지 : 6-1 / 5 + 1				-> 1*5+1		6
					 		7페이지 : 7-1 / 5 + 1 				-> 1*5+1		6
					 */
			int endbtn = startbtn + (btnsize-1) ;
				// * 단 마지막버튼수가 총페이지수보다 커지면 마지막버튼수 = 총페이지수
			if( endbtn > totalpage ) {
				endbtn = totalpage;
			}
			
				// 1. 검색이 없을때 
			// ArrayList<BoardDto> list = BoardDao.getInstance().getBoardList( startrow , listsize );
				// 2. 검색이 있을때
			ArrayList<BoardDto> list = BoardDao.getInstance().getBoardList( startrow , listsize , key , keyword , cno );
				// 만약에 나머지가 0이면 몫 : 만약에 나머지가 있으면 몫+1 
			
			
					/*
					 	총 게시물 수 = 10 		, 페이지당 표시할 게시물수 = 3
					  	1. 총 페이지수 = 4 
					  		총 레코드수 / 페이지당 표시 게시물수 
					  			1. 나머지가 없으면 => 몫
					  			2. 나머지가 있으면 => 몫 + 1
					  			
					  	2. 페이지별 게시물시작 pk 번호
					  			1페이지 요청 -> (1-1)*3 => 0
					  			2페이지 요청 -> (2-1)*3 => 3
					  			3페이지 요청 -> (3-1)*3 => 6
					  	3. 시작버튼 , 마지막버튼 수 
					  		7페이지 
					  		1페이지 -> 12345
					  		2페이지 -> 12345
					  		3페이지 -> 12345
					  		4페이지 -> 12345
					  		5페이지 -> 12345
					  		6페이지 -> 67
					  		7페이지 -> 67
					 */
			
			
			
			// page Dto 만들기
			PageDto pageDto = new PageDto(
					page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, list);
			
			// java 형식 ---> js 형식
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString( pageDto );
			
			// 응답
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print( json );
			
		}else if ( type == 2 ) { // 개별출력
			
			int bno = Integer.parseInt( request.getParameter("bno") );	System.out.println("bno : " + bno );
			
			// Dao 처리
			BoardDto result = BoardDao.getInstance().getBoard(bno);
				System.out.println("servlet : " + result );
				
			// 형변환
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString( result );
			
			// 응답
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print( json );
			
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 업로드
		// 1. 업로드할 파일의 저장 위치 [ 경로 ]
			// 클라이언트[유저] ----- x -----> git [ 내프로젝트 ]
			// 			   ----- O -----> 서버 [ 배포된프로젝트 ]
		// 2. 경로 찾기
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
			System.out.println("path : " + path );
		// 3. 파일 복사 [ 입력받은(file) 대용량 바이트 복사하기 ]
		MultipartRequest multi = new MultipartRequest(
				request,
				path,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
		);
			System.out.println("multi : " + multi );
		// --------------------------------- 확인 ---------------------------------		
		
		int cno = Integer.parseInt(multi.getParameter("cno")); 		System.out.println( "cno : " + cno ); 
		String btitle = multi.getParameter("btitle");				System.out.println( "btitle : " + btitle );
		String bcontent = multi.getParameter("bcontent");			System.out.println( "bcontent : " + bcontent );
		String bfile = multi.getFilesystemName("bfile");			System.out.println( "bfile : " + bfile );
		
		// --------------------------------- 확인 ---------------------------------
			// 1. 회원제게시판 [ 로그인된 회원의 mno 필요! ]
			String mid = (String)request.getSession().getAttribute("login");
			
			// 2. mid ---> mno ( Dao )
			int mno = MemberDao.getInstance().getMno(mid);

			// 3. 만약에 회원번호가 존재하지 않으면 글쓰기 불가능
			if( mno <= 0 ) { response.getWriter().print("false"); }
		
		// DTO
		BoardDto dto = new BoardDto(btitle, bcontent, bfile, mno , cno);
			System.out.println("dto : " + dto );
		// DAO
		boolean result = BoardDao.getInstance().bwrite(dto);
			System.out.println("result : " + result );
		// 응답
		response.getWriter().print(result);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
		
		MultipartRequest multi = new MultipartRequest(
				request,
				path,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
		);
		
		// 수정할대상 + 수정된 정보 호출
		int bno = Integer.parseInt( multi.getParameter("bno") );
		int cno = Integer.parseInt( multi.getParameter("cno") );
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
		/*
		// 첨부파일의 수정 경우의수
			// 1. 기존에 첨부파일이 없었다. --> 새로운첨부파일 없다.	[ x ]
									--> 새로운첨부파일 있다. 	[ 업로드 , db 처리 ] 
			// 2. 기존에 첨부파일이 있어다. --> 
			 						--> 새로운첨부파일 없다.	[ 기존파일로 업데이트 처리 ]
			 						--> 새로운첨부파일 있다.	[ 업로드 , db처리 , 기존파일 삭제 ]
		*/
		
		// 1. 수정 전 기존 첨부파일명 가져오기 
		String oldfile = BoardDao.getInstance().getBoard(bno).getBfile();
		
		if( bfile == null ) { // 새로운 첨부파일이 없다. 
			bfile = oldfile;  // 기존 첨부파일명을 대입
		} else { // 새로운 첨부파일 있다. 
			
			
			// 2. 삭제할 첨부파일 경로 찾기
			String filepath = request.getSession().getServletContext().getRealPath("/board/bfile/"+ oldfile );
			// 3. 파일 삭제 처리
			File file = new File(path);
			if( file. exists() ) { file.delete(); } 
			
		}
		
		// dto
		BoardDto updatedto = new BoardDto(bno, btitle, bcontent, bfile, cno);
			System.out.println("updatedto : " + updatedto );
		// dao 
		boolean result = BoardDao.getInstance().bupdate( updatedto );
		
		
		// 응답
		response.getWriter().print(result);
			
		
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type = Integer.parseInt( request.getParameter("type") );
		int bno = Integer.parseInt( request.getParameter("bno") );
		
		// [ 공통 ] 삭제전 기존게시물의 첨부파일 명 구하기
		String bfile = BoardDao.getInstance().getBoard(bno).getBfile() ;
		
		boolean result = true;
		
		if( type == 1 ) { // db삭제 + 파일삭제
			
			// [1] db 삭제처리
			result = BoardDao.getInstance().bdelete( bno );
			
		}else if( type == 2 ) { // db 업데이트 + 파일삭제
			
			// [2] db 업데이트 처리
			result = BoardDao.getInstance().bfiledelete( bno );
			
		}
		// [삭제] 공통
		// 삭제/수정시 : 첨부파일 있을경우 같이 삭제
			// 1. 경로 찾아서
			// 2. 파일 객체화 [ ?? 다양한 파일 관려 메소드 제공 .length() , delete() , exists() ]
		if( result ) { // 만약에 db가 레코드 삭제 성공했다면
			String path = request.getSession().getServletContext().getRealPath("/board/bfile/"+bfile);
			File file = new File(path); // 객체화
			if( file.exists() ){ // 만약에 파일이 존재하면
				 file.delete(); // 파일 삭제
			}
		}
		response.getWriter().print(result);
	}
}


