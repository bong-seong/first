package model.dao;

import java.sql.Statement;
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
			
			ps = con.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS );
			
			ps.setString(1, dto.getMid() );
			ps.setString(2, dto.getMpwd() );
			ps.setString(3, dto.getMemail() );
			ps.setString(4, dto.getMimg() );
		
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys(); // pk 값을 ps로 받기
			if( rs.next() ) { 
				int pk = rs.getInt(1);
				setPoint("회원가입축하", 100 , pk );
			}
				// 포인트 지급 [ 내용 , 개수 , 방금회원가입한 회원번호[ pk ] ]
				/*
				 	- insert 이후에 자동으로 생성된 auto key 찾기 => pk 호출
				 	아래로 변경
				 	con.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS );
				 	2. 생성된 pk 결과 담기
				 	rs = ps.getGeneratedKeys();
				 	3. 검색된 레코드에서 pk 호출
				 	rs.next() ---> rs.getInt(1); 
				 */
				
				
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
	
	
	// 5. 특정 회원 1명 찾기 [ + 보유포인트 ] 
	public MemberDto getMember( String mid ) {
		String sql = "select m.mno , m.mid , m.mimg , m.memail, sum(p.mpamount)"
					+ " from member m , mpoint p"
					+ " where m.mno = p.mno and m.mid = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, mid);
			rs = ps.executeQuery();
			
			if( rs.next() ) { // 비밀번호 제외한 검색된 레코드 1개를 dto 만들기
				// 결과 필드 : mno[1] , mid[2] , mimg[3] , memail[4] , mpoint[5]
				MemberDto dto = new MemberDto( 
						rs.getInt(1) , rs.getString(2) , null , 
						rs.getString(3) , rs.getString(4) );
				
				dto.setMpoint( rs.getInt(5) );
				
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
	
	// 8. 포인트 함수 [ 1. 지급내용 , 2. 지급개수 , 3. 대상 ]
	public boolean setPoint( String content , int point , int mno ) {
		
		String sql = "insert into mpoint( mpcomment , mpamount , mno )"
				+ " values ( ? , ? , ? )";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, content);
			ps.setInt(2, point);
			ps.setInt(3, mno);
					
			ps.executeUpdate();
			
			return true; 
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	// 9. 회원탈퇴 [ 인수 : mid , mpwd 반환 : 성공실패 ]
	public boolean delete( String mid , String mpwd) {
		
		String sql = "delete from member where mid = ? and mpwd = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false; 
	}
	
	
	// 10. 회원수정 [ 인수 : mid , mpwd , newmpwd , memail 반환 : 성공실패 ] 
	public boolean update( String mid , String mpwd , String newmpwd , String memail , String newmimg ) {
		
		String sql = "update member set mpwd = ? , memail = ? , mimg = ? where mid = ? and mpwd = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, newmpwd);
			ps.setString(2, memail);
			ps.setString(3, newmimg);
			ps.setString(4, mid);
			ps.setString(5, mpwd);
			
			int count = ps.executeUpdate(); // 수정된 레코드 수 반환
			if( count == 1 ) { return true; } // 레코드 1개 수정 성공시 true 
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	// 11. 회원id --> 회원 mno 반환
	public int getMno( String mid ) {
		
		String sql = "select mno from member where mid = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, mid);
			
			rs = ps.executeQuery();
			
			if( rs.next() ) { return rs.getInt(1); }
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}
	
}




















