package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vote")
public class vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public vote() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 한글인코딩
		request.setCharacterEncoding("UTF-8");
		
		String v_jumin = request.getParameter("v_jumin");
		String v_name = request.getParameter("v_name");
		String m_no = request.getParameter("m_no");
		String v_time = request.getParameter("v_time");
		String v_area = request.getParameter("v_area");
		String v_confirm = request.getParameter("v_confirm");
		
		// 3. Dto 생성
		Dto dto = new Dto(v_jumin, v_name, v_time, v_area, v_confirm, m_no);
		
		// 4. Dao 처리
		Dao dao = new Dao();
		boolean result = dao.vote( dto );
		
		if( result ) {
			response.sendRedirect("/HRD_3/index.jsp");
		}else {
			response.sendRedirect("/HRD_3/vote.jsp");
		}
		
	}

}
