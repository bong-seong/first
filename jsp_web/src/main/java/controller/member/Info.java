package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;
import model.dto.UserListDto;


@WebServlet("/member")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Info() { super(); } 

    // 1. 회원가입
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// ---------------------- 첨부파일 있을때 -------------------- //
    	/*
    	 	request는 첨부파일(대용량)에 대한 요청이 불가능 --> 외부 라이브러리
    	 	1. 프로젝트 build path cos.jar 추가
    	 	2. 프로젝트 WEB-INF -> lib -> cos.jar 추가
    	 	-----------
    	 	MultipartRequest 클래스 제공
    	 		1. 요청방식 : HTTP request
    	 		2. 저장폴더 : 1.프로젝트[git] 2.서버[워크스페이스] // 수업에서는 서버에 올림
    	 			서버폴더 경로 찾기 : request.getSession().getServletContext().getRealPath("(webapps생략)폴더명");
    	 		3. 첨부파일 허용 범위 용량 [ 바이트단위 ]
    	 		4. 첨부파일 요청 한글 인코딩
    	 		5. 첨부파일 파일명 중복일 경우 뒤에 숫자 자동 붙임
    	 	
    	 		1024*1024*10 : 10MB
    	 	-----------
    	 	
    	 	용량
    	 		1bit : 0 , 1
    	 		1byte : 01010101		8bit --> 1byte
    	 		1KB : 1024byte
    	 		1MB : 1024kb
    	 		1GB : 1024mb
    	 */
    	// * 현재 작업중인 프로젝트내 경로
    	String path = "C:\\Users\\504\\git\\first\\jsp_web\\src\\main\\webapp\\member\\mimg";
    	// * 현재 서버에 배포된 프로젝트내 폴더 경로
    	String uploadpath = request.getSession().getServletContext().getRealPath("/member/mimg");
    	System.out.println( uploadpath );
    	
    	// * 파일만 업로드
    	MultipartRequest multi = new MultipartRequest(
    			request, 						// 요청방식
    			uploadpath, 					// 첨부파일 가져와서 저장할 서버내 폴더
    			1024*1024*10, 					// 첨부파일 허용 범위 용량 [ 바이트단위 ]
    			"UTF-8",						// 첨부파일 한글 인코딩
    			new DefaultFileRenamePolicy() 	// 동일한 첨부파일명이 있으면 뒤에 숫자 붙여 식별
    	);
    	
    	// 그외 매개변수 요청 [ request --> multi / form 하위태그 name 식별자 ]
    	String mid = multi.getParameter( "mid" ); // 호출할 input의 name 
    	String mpwd = multi.getParameter("mpwd");
    	String memail = multi.getParameter("memail");
    	String mimg = multi.getFilesystemName("mimg"); // 첨부파일된 파일명 호출
    	
    	MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
    		System.out.println( "dto : " + dto );
    	
    	boolean result = MemberDao.getInstance().signup(dto);
    	response.getWriter().print(result);
    		System.out.println( result );
    	
    	// ---------------------- 첨부파일 없을때 -------------------- //
    	/*
    	// 1. ajax 에게 데이터 요청
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		String memail = request.getParameter("memail");
		String mimg = request.getParameter("mimg");
		
		// 2. DTO 만들기
		MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
		System.out.println("dto : " + dto );
		
		// 3. DAO 호출하고 결과 받기
		boolean result = MemberDao.getInstance().signup(dto);
		
		// 4. 결과 응답하기
		response.getWriter().print(result);
		*/
	}

    
    // 2. 로그인 / 회원정보 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			// 검색처리
			
			String key = request.getParameter("key");
			String keyword = request.getParameter("keyword");
		
			
			int page = Integer.parseInt( request.getParameter("page") );			// 호출한 페이지 전달받기
			int listsize = Integer.parseInt( request.getParameter("listsize") );	// 리스트에 출력할 레코드 수 사이즈 받기 
			int startrow = (page-1)*listsize;										// 시작 레코드 번호
			
			// 1. 토탈사이즈 
			int totalsize = MemberDao.getInstance().user_count( key , keyword );	// DAO 에게 total count 수 요청 
			int totaluser = totalsize % listsize == 0 ? totalsize/listsize : totalsize/listsize+1 ; // 총 유저수에따른 페이지수 구하기
			
			int btnsize = 5; // 표시할 버튼의 갯수 지정
			int startbtn = ( (page-1) / btnsize ) * btnsize + 1 ; // 시작 버튼 번호구하기 
			
			int endbtn = startbtn + (btnsize-1); // 끝 버튼번호 구하기 
			
			if( endbtn > totaluser ) { // 끝 버튼이 총 페이지수를 넘어갈 수 없게 처리
				endbtn = totaluser;
			}
			
			
			// Dao 호출하여 MemberDto 구성 
			ArrayList<MemberDto> list = MemberDao.getInstance().infoPrint( startrow , listsize , key , keyword );
			
			// 페이지 , 리스트사이즈 , 버튼 정보 , MemberDto 등 다양한 자료형을 한번에 담기위한 UserListDto 구성 
			UserListDto dto = new UserListDto(page, listsize, startrow, totalsize, totaluser, btnsize, startbtn, endbtn, list);
			
			// 형변환
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString( dto );
			
			// 리턴
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print( json );
		
		
	}

	
	// 3. 회원 정보 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 업로드 코드 구현
			// 1. 업로드 할 파일을 해당 서버 경로로 업로드
		String path = request.getSession().getServletContext().getRealPath("/member/mimg");
			// 2. 객체
		MultipartRequest multi = new MultipartRequest(
				request, 
				path , 
				1024*1024*10 , 
				"UTF-8" , 
				new DefaultFileRenamePolicy() 
		);
		
		String mid = (String)request.getSession().getAttribute("login");		System.out.println("mid : " + mid);
    	String mpwd = multi.getParameter("mpwd");								System.out.println("mpwd : " + mpwd);
    	String newmpwd = multi.getParameter("newmpwd");							System.out.println("newmpwd" + newmpwd);
    	String memail = multi.getParameter("memail");							System.out.println("memail : " + memail);
    	String newmimg = multi.getFilesystemName("newmimg"); 					System.out.println("newmimg : " + newmimg);
    	String defaultimg = multi.getParameter("defaultimg");					System.out.println("defaultimg : " + defaultimg);
    	
    	// 3. 만약에 새로운 첨부파일이 없으면
    	if( newmimg == null ) {
    		// 기존 이미지 파일 그대로 사용
    		newmimg = MemberDao.getInstance().getMember( mid ).getMimg();
    	}
    	if( defaultimg.equals( "true" ) ){ // 기본프로필 사용
    		newmimg = null;
    	}
    	
    	
    	boolean result = MemberDao.getInstance().update(mid, mpwd, newmpwd, memail, newmimg);
    	response.getWriter().print(result);
    	
	}
	
	
	/*
	 	첨부파일 없을때
	 	// 1. 로그인된 회원 정보수정
			// 1. 필요한 데이터 요청
		String mid = (String)request.getSession().getAttribute("login");
			System.out.println("mid : " + mid );
		String mpwd = request.getParameter("mpwd");
			System.out.println("mpwd : " + mpwd );
		String newmpwd = request.getParameter("newmpwd");
			System.out.println("newmpwd : " + newmpwd );
		String memail = request.getParameter("memail");
			System.out.println("memail : " + memail );
		
		// 2. Dao 에게 요청 후 결과 받기
		boolean result = MemberDao.getInstance().update(mid, mpwd, newmpwd , memail);
			System.out.println("result : " + result );
			
		// 3. 결과 ajax 에게 보내기
		response.getWriter().print(result);
	 
	 */

	
	// 4. 회원 탈퇴
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 로그인된 회원탈퇴
			// 1. 로그인된 회원아이디 가져오기 [ 세션(object) ]
		String mid = (String)request.getSession().getAttribute("login");
		String mpwd = request.getParameter("mpwd");
			System.out.println( "mid : " + mid );
		// 2. Dao에게 요청후 결과 받기
		boolean result = MemberDao.getInstance().delete(mid,mpwd);
			System.out.println("result : " + result );
		// 3. 결과 ajax 에게 보내기 
		response.getWriter().print(result);
	}

}
