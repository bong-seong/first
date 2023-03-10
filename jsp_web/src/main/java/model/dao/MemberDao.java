package model.dao;

import java.util.ArrayList;

import model.dto.MemberDto;

public class MemberDao extends Dao {
	
	private static MemberDao dao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() { return dao ; }
	
	
	// 1. 회원가입
	public boolean signup( MemberDto dto ) {
		
		String sql = "insert into member ( mid , mpwd, memail, mimg )"
				+ " values ( ? , ? , ? , ? )";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getMid() );
			ps.setString(2, dto.getMpwd() );
			ps.setString(3, dto.getMemail() );
			ps.setString(4, dto.getMimg() );
			
			ps.executeUpdate();
			
			return true ;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false; 
	}
	
	
	// 2. 모든 회원정보 호출
	public ArrayList<MemberDto> infoPrint(){
		
		ArrayList<MemberDto> list = new ArrayList<>();
		
		String sql = "select * from member";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				
				MemberDto dto = new MemberDto(
						rs.getInt(1), rs.getString(2) , rs.getString(3) ,
						rs.getString(4) , rs.getString(5) );
				list.add(dto);
			}
		}catch (Exception e) { System.out.println(e); }
		
		return list;
	}
	
	
	// 3. 아이디 중복검사
	public boolean idCheck( String mid ) {
		
		String sql = "select * from member where mid = '" + mid + "'" ;
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// 만약에 검색 결과 레코드가 존재하면 중복 아이디
			if( rs.next() ) { return true; }
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return false; // 없으면 중복아이디 X 
	}
	
	
	// 4. 로그인 
	public boolean login( String mid , String mpwd ) {
		// 아이디 비밀번호 검증 
		String sql = "select * from member where mid = ? and mpwd = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			
			rs = ps.executeQuery();
			
			if( rs.next() ) { return true ;}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	// 5. 특정 회원 1명 찾기
	public MemberDto getMember( String mid ) {
		String sql = "select * from member where mid = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, mid);
			rs = ps.executeQuery();
			
			if( rs.next() ) { // 비밀번호 제외한 검색된 레코드 1개를 dto 만들기
				MemberDto dto = new MemberDto( 
						rs.getInt(1) , rs.getString(2) , null , rs.getString(4) , rs.getString(5) );
				
				return dto ;
			}
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return null; 
		
	}
	
	
	
	// 6. 아이디찾기
	public String findid( String memail ) {
		
		String sql = "select mid from member where memail = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, memail );
			rs = ps.executeQuery();
			
			if( rs.next() ) { return rs.getString(1); } // 찾은 아이디 반환
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return "false" ; // 없으면 false 
	}
	
	
	// 7. 비밀번호찾기
	public String findpwd( String mid , String memail , String updatePwd ) {
		
		String sql = "select mno from member where mid = ? and memail = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid );
			ps.setString(2, memail );
			
			rs = ps.executeQuery();
			
			if( rs.next() ) { 
				
				sql = "update member set mpwd = ? where mno = ?";
				
				ps = con.prepareStatement(sql);
				
				ps.setString(1, updatePwd);
				ps.setInt(2, rs.getInt(1) );
				
				int result = ps.executeUpdate();	// 업데이트한 레코드 개수 반환
				if( result == 1 ) { // 업데이트한 레코드가 1개 이면 
					// -- 이메일전송 테스트 되는 경우 만 -- // 
					// new MemberDto().sendEmail( memail, updatePwd ); // 임시비밀번호를 이메일로 보내기
					// return "true" ;
					// -- 이메일전송 테스트 안되는 경우 -- //
					return updatePwd;
				}
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return "false"; 
	}
}




















