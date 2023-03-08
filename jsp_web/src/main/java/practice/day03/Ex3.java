package practice.day03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex3
 */

//urlPatterns = "/ServletEx01", loadOnStartup = 1
@WebServlet(urlPatterns ="/Ex3" , loadOnStartup = 2) // <-- 해당 클래스 [ 자원 ] URL 정의 , localhost:8080/jsp_web/Ex3
public class Ex3 extends HttpServlet { // <-- HttpServlet 클래스에게 상송
	private static final long serialVersionUID = 1L;
       
    // 생성자
    public Ex3() {
        super();
    }

    
    // 1. POST 메소드
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		System.out.println("POST 메소드에서 통신받았습니다.");
 	}
    
    // 2. GET 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 메소드에서 통신받았습니다.");
	}

	// 3. PUT 메소드
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PUT 메소드에서 통신받았습니다.");
	}

	// 4. DELETE 메소드
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DELETE 메소드에서 통신받았습니다.");
	}

}
