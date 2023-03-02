package jsbweb.index;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class index_test
 */
@WebServlet("/Indextest")
public class Indextest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Indextest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. HTTP 객체 [ request : JS에게 요청 , respones : JS에게 응답 ]
			// 1. request.getParameter("매개변수명"); 
			// 2. respones.getWirter().print( 데이터 );
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String data = request.getParameter("data"); // ajax( data : { "매개변수명" : 데이터 } )
		System.out.println("JS에게 get방식으로 받은 데이터 : " + data );
				
		response.getWriter().print("GET 방식으로 잘받았습니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		String data = request.getParameter("data"); // ajax( data : { "매개변수명" : 데이터 } )
		System.out.println("JS에게 post방식으로 받은 데이터 : " + data );
		
		response.getWriter().print("POST 메소드 방식으로 잘받았습니다.");
		
	}

}
