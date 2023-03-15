package controller.board;

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


@WebServlet("/board/info") // ! : 프로젝트내 동일한 서블릿주소 있을경우 서버자체 안켜짐
public class Boardinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Boardinfo() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type = Integer.parseInt( request.getParameter("type") ); 
		
		if( type == 1 ) { // 전체 출력
			
			ArrayList<BoardDto> list = BoardDao.getInstance().getBoardList();
			
			// java 형식 ---> js 형식
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString( list );
			
			// 응답
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print( json );
			
		}else if ( type == 2 ) { // 개별출력
			
			int bno = Integer.parseInt( request.getParameter("bno") );	System.out.println("bno : " + bno );
			
			// Dao 처리
			BoardDto dto = BoardDao.getInstance().getBoard(bno);

			// 형변환
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString( dto );
			
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
	
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}


