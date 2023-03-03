package practice.day02;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet( urlPatterns = "/StudentServlet" , loadOnStartup = 2 )
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<StudentDTO> list = Dao.getInstance().getStudent();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String jsonArray = objectMapper.writeValueAsString( list );
		
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print( jsonArray );
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		double height = Double.parseDouble(request.getParameter("height")); 
		int age = Integer.parseInt(request.getParameter("age"));
		String reg_date = request.getParameter("reg_date");
		String gender = request.getParameter("gender");
		boolean agreed = Boolean.parseBoolean(request.getParameter("agreed"));
		String area = request.getParameter("area");
		String about_me = request.getParameter("about_me");
		
		System.out.println( name );
		
		StudentDTO dto = new StudentDTO(name, phone, height, age, reg_date, gender, agreed, area, about_me);
		
		boolean result = Dao.getInstance().setStudent(dto);
		
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
		
	}

}
