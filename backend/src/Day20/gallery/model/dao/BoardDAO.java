package Day20.gallery.model.dao;

import java.util.ArrayList;

import Day20.gallery.model.dto.BoardDTO;
import Day20.gallery.model.dto.CategoryDTO;

public class BoardDAO extends DAO {
	
	// 1. 싱글톤
	private static BoardDAO dao = new BoardDAO();
	private BoardDAO() {}
	public static BoardDAO getInstance() {
		return dao;
	}
	
	
	// 1. 카테고리 추가 
	public boolean categoryAdd( String cname ) {
		
		String sql = "insert into category ( cname ) values ( ? )";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, cname);
			
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		return false;
	}

	
	// 2. 카테고리 프린트
	public ArrayList<CategoryDTO> categoryPrint(){
		
		ArrayList<CategoryDTO> clist = new ArrayList<>();
		
		String sql = "select * from category";
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) { // rs.next() : 다음레코드 [ 존재하면 true / 없으면 false ]
				// 레코드 ---> dto // rs.get타입( 필드순서번호 )
				CategoryDTO dto = new CategoryDTO( rs.getInt(1), rs.getString(2) );
				
				clist.add(dto);
			}
			
			return clist;
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		return null;
	}
	
	
	// 3. 게시물 등록
	public boolean boardAdd( String btitle, String bcontent, int mno , int cno ) {
		
		String sql = "insert into board( btitle, bcontent, mno_fk , cno_fk ) values ( ? , ? , ? , ? )";
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setInt(3, mno);
			ps.setInt(4, cno);
			
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		return false;
	}
	
	// 4. 최신 게시물 출력
	public ArrayList<BoardDTO> boardPrintRecent(){
		
		ArrayList<BoardDTO> blist = new ArrayList<>();
		
		String sql = "select  b.bno , b.btitle, b.bcontent, b.bdate, b.bview, m.mid , c.cname"
					+ " from member m , category c , board b"
					+ " where b.mno_fk = m.mno and b.cno_fk = c.cno order by b.bdate desc limit 3;";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				BoardDTO dto = new BoardDTO(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getInt(5), 
						rs.getString(6), 
						rs.getString(7)
				);
				blist.add(dto);
			}
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		return blist;
		
	}
	
	// 5. 해당 카테고리의 모든 게시물 출력
	public ArrayList<BoardDTO> boardPrint( int cno ){
		
		ArrayList<BoardDTO> blist = new ArrayList<>();
		
		String sql = "select  b.bno , b.btitle, b.bcontent, b.bdate, b.bview, m.mid , c.cname"
					+ " from member m , category c , board b"
					+ " where b.mno_fk = m.mno and b.cno_fk = c.cno and b.cno_fk = ? ";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, cno);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				BoardDTO dto = new BoardDTO(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getInt(5), 
						rs.getString(6), 
						rs.getString(7)
				);
				blist.add(dto);
			}
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		return blist;
		
	}
	
	// 6. 해당 게시물 출력
	
	
}
