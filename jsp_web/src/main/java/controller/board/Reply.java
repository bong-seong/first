package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.ReplyDto;


@WebServlet("/board/reply")
public class Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Reply() { super(); }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type = Integer.parseInt( request.getParameter("type") );
		int bno = Integer.parseInt( request.getParameter("bno") );
		int rindex = 0;
		if( type == 1 ) {
			
		}else if( type == 2 ) {
			rindex = Integer.parseInt( request.getParameter("rindex") );
		}
		
		ArrayList<ReplyDto> result = BoardDao.getInstance().getReplyList( bno , rindex );
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString( result );
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print( jsonArray );
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 
		request.setCharacterEncoding("UTF-8");
		int bno = Integer.parseInt( request.getParameter("bno") );
		int mno = MemberDao.getInstance().getMno( (String)request.getSession().getAttribute("login") ); 
		String rcontent = request.getParameter("rcontent");
		
		int type = Integer.parseInt( request.getParameter("type") );
		
		ReplyDto dto = null;
		if( type == 1 ) {
			dto = new ReplyDto(rcontent, mno, bno);
				System.out.println("dto : " + dto );
		}else if ( type == 2 ) {
			int rindex = Integer.parseInt(request.getParameter("rindex"));
			
			dto = new ReplyDto( rcontent , mno , bno );
			dto.setRindex(rindex);
		}
		
		// 3. 
		boolean result = BoardDao.getInstance().rwrite(dto);
		
		// 4. 
		response.getWriter().print(result);
		
	}

}
