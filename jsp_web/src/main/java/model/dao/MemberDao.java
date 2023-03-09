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
}




















