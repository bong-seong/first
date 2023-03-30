package hrd_기출문제1.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hrd_기출문제1.model.MemberDto;


@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Join() { super(); }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int custno = Integer.parseInt( request.getParameter("custno") );
		String custname = request.getParameter("custname"); System.out.println( custname );
		String phone = request.getParameter("phone");		System.out.println( phone );
		String address = request.getParameter("address");	System.out.println( address );
		String joindate = request.getParameter("joindate"); System.out.println( joindate );
		String grade = request.getParameter("grade");		System.out.println( grade );
		String city = request.getParameter("city");			System.out.println( city );
		
		MemberDto dto = new MemberDto(custno, custname, phone, address, joindate, grade, city);
		
		Dao dao = new Dao();
		
		boolean result = dao.update( dto );
		
		if( result ) {
			response.sendRedirect("/hrd_exam1/update.jsp?custno="+custno );
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String custname = request.getParameter("custname"); System.out.println( custname );
		String phone = request.getParameter("phone");		System.out.println( phone );
		String address = request.getParameter("address");	System.out.println( address );
		String joindate = request.getParameter("joindate"); System.out.println( joindate );
		String grade = request.getParameter("grade");		System.out.println( grade );
		String city = request.getParameter("city");			System.out.println( city );
		
		MemberDto dto = new MemberDto(0, custname, phone, address, joindate, grade, city);
		
		Dao dao = new Dao(); 
		
		boolean result = dao.join(dto);
		
		// 성공시 다시 가입 페이지 이동
		if( result ) {
			response.setCharacterEncoding("UTF-8");
			response.sendRedirect("http://192.168.17.34:8080/hrd_exam1/join.jsp");
		}
	}

	

}
