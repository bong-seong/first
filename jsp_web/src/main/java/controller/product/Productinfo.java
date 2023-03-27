package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.ProductDto;


@WebServlet("/product/info")
public class Productinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Productinfo() { super(); }
    
    ObjectMapper mapper = new ObjectMapper();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");			
		String dong = request.getParameter("dong");		System.out.println( dong );
		String seo = request.getParameter("seo");		System.out.println( seo );
		String nam = request.getParameter("nam");		System.out.println( nam );
		String book = request.getParameter("book");		System.out.println( book );
		
		
		ArrayList<ProductDto> result = ProductDao.getInstance().getProduct( dong , seo , nam , book );
		
		String jsonArray = mapper.writeValueAsString(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print( jsonArray );
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// ---------------------------- commons.jar 사용시 ----------------------------//
		
		request.getParameter("UTF-8"); // 요청 한글타입
		
		// 1. 다운로드 할 서버 경로
		String path = request.getSession().getServletContext().getRealPath("/product/pimg");
		
		// 2. 해당 경로의 파일/폴더 객체화 [ setRepository 에서 대입하기 위해 ]
		File pathObject = new File(path);
		
		// 3. 업로드할 저장소 객체 생성
		DiskFileItemFactory factory = new DiskFileItemFactory(); 
		factory.setRepository( pathObject );		// 파일저장소 위치 대입
		factory.setSizeThreshold( 1024*1042*10 ); 	// 파일저장소에 저장할 수 있는 최대 용량 범위 10MB
		factory.setDefaultCharset("UTF-8");			// 파일 저장소 한글 인코딩 타입
		
		// 4. 파일업로드객체
		ServletFileUpload upload = new ServletFileUpload( factory );
		

		try {
			// 5. 매개변수 요청해서 리스트에 담기 [ 무조건 예외처리 발생 ] 
			List<FileItem> items = upload.parseRequest(request);
				// DB 에 저장할 데이터를 분류
				List<String> fieldList = new ArrayList<>();
				List<String> fileList = new ArrayList<>();
			
			// 6. 
			for( FileItem item : items ) { // 요청된 모든 매개변수들을 반복문 돌려서 확인
				if( item.isFormField() ) {
					// .isFormField() : 첨부파일이 아니면 true 첨부파일이면 false
					System.out.println("첨부파일 아닌 필드명 : " + item.getFieldName() );
					System.out.println("첨부파일 아닌 필드의 값 : " + item.getString() );
					
					fieldList.add( item.getString() ); // 리스트 저장
					
				}else {
					System.out.println("첨부파일 인 필드명 : " + item.getFieldName() );
					System.out.println("첨부파일 인 필드의 파일명 : " + item.getName() );
					
					// 9. 첨부파일 이름 식별이름 변경 
						// 1. 파일명의 공백이 존대하면 - 로 변경 [ .replaceAll("기존문자" , "새로운문자") 문자열 치환함수 ]
						// 2. UUID : 범용 고유 식별자 [ 중복이 없는 식별자 만들기 ] 
						// 최종 식별 파일명 : UUID 파일명
					String filename = UUID.randomUUID() + " " + item.getName().replaceAll(" ", "-");
					
					fileList.add( filename ); // 첨부된 파일의 이름을 요청해서 리스트 저장
					
					// 7. 저장할 경로+/+파일명 의 파일을 객체화 / 해당 파일 객체 저장
					File filepath = new File( path + "/" + filename );
					// 8. 해당 경로에 item 업로드하기 
					item.write( filepath );
					
				}
			}
			
			//
			System.out.println( fieldList.toString() );
			System.out.println( fileList.toString() );
			
			int mno = MemberDao.getInstance().getMno( (String)request.getSession().getAttribute("login") );
			
			ProductDto dto = new ProductDto( fieldList.get(0) , fieldList.get(1) , 
					Integer.parseInt( fieldList.get(2) )  , fieldList.get(3) , fieldList.get(4) , mno , fileList );
			
			System.out.println("dto : " + dto.toString() );
			
			// dao
			boolean result = ProductDao.getInstance().write(dto);
			response.getWriter().print(result);
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		// ----------------------------- cos.jar 사용시 ---------------------------- //
		/*
		String path = request.getSession().getServletContext().getRealPath("/product/pimg");
			System.out.println( path );
		
		MultipartRequest multi = new MultipartRequest(
				request,
				path,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
		);
		
		String pname = multi.getParameter("pname");						System.out.println( pname );
		String pcomment = multi.getParameter("pcomment");				System.out.println( pcomment );
		int pprice = Integer.parseInt( multi.getParameter("pprice") );	System.out.println( pprice );
		String plat = multi.getParameter("plat");						System.out.println( plat );
		String plng = multi.getParameter("plng");						System.out.println( plng );
		
		// 첨부파일 1개 이름 가져오기
		String pfile = multi.getFilesystemName("pfile");
			System.out.println( pfile );
		
		// 첨부파일 여러개 이름 가져오기 1 multiple x
		String pfile1 = multi.getFilesystemName("pfile1");
		String pfile2 = multi.getFilesystemName("pfile2");
		String pfile3 = multi.getFilesystemName("pfile3");
			System.out.println("s : " + pfile1 + " " + pfile2 + " " + pfile3 );
		
		
		// 첨부파일 여러개 이름 가져오기 2 multiple o
			// multiple input 에 등록된 여러 사진들의 이름 가져오기 불가능 [ cos.jar 제공 x ]
			// 다른 라이브러리 사용
		Enumeration pfiles =  multi.getFileNames(); // input type 이 file의 태그명 호출
		
		while( pfiles.hasMoreElements() ) {
			// 해당 목록 [pfiles] 에 요소 [ element ] 가 존재하면 true / 아니면 false 
			String s = (String)pfiles.nextElement();
			System.out.println( "s : " + s );
		}
		
		ProductDto dto = new ProductDto(pname, pcomment, pprice, plat, plng);
		boolean result = ProductDao.getInstance().write(dto);
		response.getWriter().print( result );
		*/
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
