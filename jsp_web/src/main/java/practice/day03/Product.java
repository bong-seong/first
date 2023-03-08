package practice.day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

//urlPatterns = "/ServletEx01", loadOnStartup = 1
@WebServlet(urlPatterns = "/Ex3/Product" , loadOnStartup = 1 )
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Product() {
        super();
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
    	
    	String name = request.getParameter("name");
    	int price = Integer.parseInt( request.getParameter("price"));
    	
    	ProductDTO dto = new ProductDTO( 0, name, price, null );
    	
    	boolean result = BoardDAO.getInstance().onadd(dto);
    	
    	response.getWriter().print(result);
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<ProductDTO> list = BoardDAO.getInstance().getProduct();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(list);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print( jsonArray );
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int seq = Integer.parseInt( request.getParameter("seq" ) );
		
		String newname = request.getParameter("newname");
		int newprice = Integer.parseInt( request.getParameter("newprice"));
		
		boolean result = BoardDAO.getInstance().prod_update(newname, newprice, seq);
		
		response.getWriter().print(result);
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int seq = Integer.parseInt( request.getParameter("seq") );
		
		boolean result = BoardDAO.getInstance().prod_delete(seq);
		
		response.getWriter().print(result);
		
	}

}
