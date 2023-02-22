package 과제.과제11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {

	private static ProductDAO dao = new ProductDAO();
	public static ProductDAO getInstance() {
		return dao;
	}
	
	// 1. 필드
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// DB Connect -------------------------------------------------------------------------------
	private ProductDAO() {
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pd", "root", "1234");
		}
		catch( Exception e ) {
			System.out.println("DB 연결 실패 " + e.getMessage() );
		}
	}
	// ------------------------------------------------------------------------------------------
	
	
	// 1. 제품 등록 --------------------------------------------------------------------------------
	public boolean add( ProductDTO dto ) {
		
		// 1. SQL 작성
		String sql = "insert into product ( name, price, inven ) values ( ? , ? , ?)";
		
		// 2. 연동 DB에 SQL 대입
		try {
			
			ps = conn.prepareStatement(sql);
			
			// 3. 매개변수조작
			ps.setString(1, dto.getName() );
			ps.setInt(2, dto.getPrice() );
			ps.setInt(3, dto.getInven() );
			
			// 4. SQL 실행
			ps.executeUpdate();
			
			// 5. 결과반환
			return true;
		}
		catch( Exception e ) {
			System.out.println("DB 에러 : " + e );
		}
		return false;
	}
	// ------------------------------------------------------------------------------------------

	
	
	// 2. 모든 제품 출력 ----------------------------------------------------------------------------
	public ArrayList<ProductDTO> print(){
		
		ArrayList<ProductDTO> list = new ArrayList<>();
		
		// 1. SQL 작성
		String sql = "select * from product";
		
		// 2. 연결된 DB에 작성된 SQL 대입
		try {
			ps = conn.prepareStatement(sql);
			
			// 3. 생략
			// 4. SQL 실행
			rs = ps.executeQuery();
			
			// 5. SQL 결과
			while( rs.next() ) {
				ProductDTO dto = new ProductDTO(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getInt(3), 
						rs.getInt(4));
				list.add(dto);	
			}	
		}
		catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		return list;
	}
	// ------------------------------------------------------------------------------------------
	
	
	// 3. 제품 수정 --------------------------------------------------------------------------------
	public boolean edit( ProductDTO dto , int ch ) throws Exception {
		
		String sql = null;
		
		if( ch == 1 ) {
			sql = "update product set name = ? where seq = ?";
			ps = edit_sql(sql);
			
			ps.setString(1, dto.getName() );
			ps.setInt(2, dto.getSeq() );
			
			ps.executeUpdate();
			
			return true;
		}
		else if( ch == 2 ) {
			sql = "update product set price = ? where seq = ?";
			ps = edit_sql(sql);
			
			ps.setInt(1, dto.getPrice() );
			ps.setInt(2, dto.getSeq() );
			
			ps.executeUpdate();
			
			return true;
		}
		else if( ch == 3 ) {
			sql = "update product set name = ?, price = ? where seq = ?";
			
			ps = edit_sql(sql);
			
			ps.setString(1, dto.getName() );
			ps.setInt(2, dto.getPrice() );
			ps.setInt(3, dto.getSeq() );
			
			ps.executeUpdate();
			
			return true;
		}
		
		return false;
	}
	
	public PreparedStatement edit_sql( String sql ) {
		
		try {
			ps = conn.prepareStatement(sql);
		}
		catch( Exception e ) {
			System.out.println("DB 에러 : " + e );
		} 
		
		return ps;
	}
	// ------------------------------------------------------------------------------------------
	
	
	// 4. 제품 재고 --------------------------------------------------------------------------------
	public boolean inven_update( int seq , int inven ) {
		
		String sql = "update product set inven = ? where seq = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, inven);
			ps.setInt(2, seq);
			
			ps.executeUpdate();
			
			return true;
		}
		catch( Exception e ) {
			System.out.println("DB 에러 : " + e );
		}
		
		return false; 
	}
	
	
	// ------------------------------------------------------------------------------------------
	
	
	// 5. 제품 삭제 --------------------------------------------------------------------------------
	public boolean delete( int seq ) {
		
		String sql = "delete from product where seq = ?";
		
		try {
		
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, seq);
			
			ps.executeUpdate();

			return true;
		}
		catch( Exception e ) {
			System.out.println("DB 에러 : " + e );
		}
		
		return false; 
	}
	
	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	
	
	// 유저 --------------------------------------------------------------------------------------
	// 유저가 선택한 제품을 담을 배열 
	ArrayList<ProductDTO> userList = new ArrayList<>();
	
	
	// 장바구니 출력 --------------------------------------------------------------------------------
	public ArrayList<ProductDTO> cart_print() {
		return userList;
	}
	// ------------------------------------------------------------------------------------------
	
	
	// 유저 제품 추가 --------------------------------------------------------------------------------
	public boolean cart_add( int seq , int inven ) {
		
		String sql1 = "update Product set inven = ? where seq = ?";
		String sql2 = "select * from product where seq = ?";
		
		try {
			ps = conn.prepareStatement(sql1);
			
			ps.setInt(1, inven-1);
			ps.setInt(2, seq);
			
			ps.executeUpdate();
			
			// ------------------------------------ //
			
			ps = conn.prepareStatement(sql2);
			
			ps.setInt(1, seq);
			
			rs = ps.executeQuery();
			
			rs.next();
			ProductDTO dto = new ProductDTO(
					rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			
			userList.add(dto);
			
			return true;
	
		}
		catch(Exception e ) {
			System.out.println("DB 에러 : " + e );
		}
		
		return false;
	}
	// ------------------------------------------------------------------------------------------
	
	
	
	
}
