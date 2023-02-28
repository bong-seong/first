package Day20.gallery.model.dao;

import Day20.gallery.model.dto.MemberDTO;

public class MemberDAO extends DAO {
	
	// 1. 싱글톤
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return dao;
	}
	
	// 기능 메소드
	
	// 1. 아이디 중복체크 [ 아이디 검색 ]
	public boolean idCheck( String mid ) {
		
		String sql = "select * from member where mid = ? ";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, mid);
			rs = ps.executeQuery();
			
			if( rs.next() ) { return true; } // 검색된 레코드가 있으면 [ 중복된 아이디 ] 
			else { return false; }
			
		}catch (Exception e) {
			System.out.println("DB 오류 : " + e );
		}
	
		return true;
	}
	
	
	// 2. 회원가입 
	public int signup( MemberDTO dto ) {
		
		String sql ="insert into member( mid, mpw , mname, mphone ) values ( ? , ? , ? , ? )";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getMid() );
			ps.setString(2, dto.getMpw() );
			ps.setString(3, dto.getMname() );
			ps.setString(4, dto.getMphone() );
			
			ps.executeUpdate();
			
			return 1;
		
		}catch (Exception e) {
			System.out.println("DB 오류 : " + e );
		}
		
		return 3; 
	}
	
	// 3. 로그인 [ 반환 : 로그인 성공한 회원번호 반환 ]
		// - 로그인[로그인 되어있는 동안 저장되는] 세션 : 1. 회원번호 2. Logindto[ 회원번호 , 포인트 , 등급 ]
	public int login( String mid , String mpw ) {
		
		String sql = "select * from member where mid = ? and mpw = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, mid);
			ps.setString(2, mpw);
			
			rs = ps.executeQuery();
			
			if( rs.next() ) { 
				return rs.getInt(1); 
			}
			else { return 0; }
		}catch (Exception e) {
			System.out.println("DB 오류 : " + e );
		}
		
		return 0; 
	}

	
}
