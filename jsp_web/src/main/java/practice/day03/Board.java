package practice.day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/Ex3/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public Board() {
        super();
    }

    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청시 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. 매개변수 요청 [ AJAX data 속성에서 보내준 매개변수 이릅
		String content = request.getParameter("content");
			System.out.println("contnet : " + content );
		
		String writer = request.getParameter("writer");
			System.out.println("writer : " + writer );
			
		// 3. DTO 객체 [ 기본값 : int 필드의 0 / 객체 필드의 null ]
		BoardDTO dto = new BoardDTO( 0, content, writer, null );
			System.out.println( "dto : " + dto );
			
		// 4. DAO 호출해서 결과 저장
		boolean result = BoardDAO.getInstance().onwirte(dto);
			System.out.println("onwrite result : " + result );
			
		// 5. DAO 결과인 true , false 데이터를 response 객체 이용한 응답
		response.getWriter().print(result);
			
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<BoardDTO> list = BoardDAO.getInstance().onprint();
			System.out.println( list );
			
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(list);
			System.out.println("jsonArray : " + jsonArray );
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print( jsonArray );
		
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		// 1. 수정할 게시물 번호 요청
		int bno = Integer.parseInt( request.getParameter("bno") );
			System.out.println( "put 전달받음 : " + bno );

		// 2. 수정할 게시물 내용 요청
		String newContent = request.getParameter("newContent");
			System.out.println( "put 전달받음 : " + newContent );
		
		// 3. DAO 호츌해서 결과 얻기
		boolean result = BoardDAO.getInstance().onupdate(bno, newContent);
		
		// 4. 결과 응답하기
		response.getWriter().print(result);
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 삭제할 게시물 번호 요청
		int bno = Integer.parseInt( request.getParameter("bno") );
			System.out.println( "delete 전달받음 : " + bno );
	
		// 2. DAO 호출해서 결과 얻기
		boolean result = BoardDAO.getInstance().ondelete( bno );
		
		// 3. 결과 응답하기
		response.getWriter().print( result );
		
	}

}


/*

	JSP 서블릿에서 http 메소드 put , delete 사용시 필수 설정
		* 기본값 : 매개변수 요청 차단
	 1. Servers 폴더 클릭
	 2. server.xml 
	 3. 하단 Source 탭 클릭
	 4. 약 60 행 쯤 설정추가
	 원본 : <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
 	 수정 : <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" parseBodyMethods="POST,PUT,DELETE" URIEncoding="UTF-8" />
 	 
 */






