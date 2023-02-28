package Day20.gallery.controller;

import Day20.gallery.model.dao.MemberDAO;
import Day20.gallery.model.dto.MemberDTO;

public class Mcontroller {

	private static Mcontroller mc = new Mcontroller();
	private Mcontroller() {}
	public static Mcontroller getInstance() {
		return mc;
	}
	
	
	private int loginSession = 0;
	
	public int getLoginSession() {
		return loginSession;
	}

	public void setLoginSession(int loginSession) {
		this.loginSession = loginSession;
	}
	// 1. 회원가입 처리 [ 아이디중복체크 ] 
	public int signup( String mid, String mpw, String mname, String mphone ) {
		
		// 1. 유효성검사 [ 글자수 , 중복체크 등등 ]
			// 1. 아이디 중복체크
		if( MemberDAO.getInstance().idCheck(mid) ) {
			return 2; // 중복된 아이디 
		}
		
		// 2. 객체화
		MemberDTO dto = new MemberDTO(0, mid, mpw, mname, mphone);
		
		// 3. 회원가입 DB처리 후 DB 처리 결과를 반환
		return MemberDAO.getInstance().signup(dto);
		
	}
	
	
	
	// 2. 로그인 처리
	public boolean login( String mid , String mpw ) {
		
		// 1. 유효성검사
		
		// 2. 
		int result = MemberDAO.getInstance().login(mid, mpw);
		
		// 3. 로그인 성공 증거 [ 로그인 정보 저장소 = 세션 ]
		if( result == 0 ) { return false; }
		else {
			loginSession = result;
			return true; 
		}
	}
	
}
