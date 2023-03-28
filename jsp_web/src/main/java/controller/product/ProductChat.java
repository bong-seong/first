package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.ChatDto;


@WebServlet("/product/chat")
public class ProductChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductChat() { super(); }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pno = Integer.parseInt( request.getParameter("pno") );
		int mno = MemberDao.getInstance().getMno( (String)request.getSession().getAttribute("login") );
		
		ArrayList<ChatDto> result = ProductDao.getInstance().getChatList(pno, mno);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString( result );
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print( jsonArray );
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 1.
		String ncontent = request.getParameter("ncontent"); 
		int pno = Integer.parseInt( request.getParameter("pno") );
		int from_mno = MemberDao.getInstance().getMno( (String)request.getSession().getAttribute("login") ); 
		int to_mno = Integer.parseInt( request.getParameter("to_mno") );
		
		// 2. DTO
		ChatDto dto = new ChatDto(0, ncontent, null, pno, from_mno, to_mno);
			System.out.println("dto : " + dto);
		
		// 3. DAO
		boolean result = ProductDao.getInstance().setChat( dto );
		response.getWriter().print(result);
		
	}

}
