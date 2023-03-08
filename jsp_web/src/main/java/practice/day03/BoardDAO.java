package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static BoardDAO dao = new BoardDAO();
	public static BoardDAO getInstance() {
		return dao;
	}
	
	private BoardDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsp_web",
					"root", "1234");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	// 1. 등록 [ C ]
	public boolean onwirte( BoardDTO dto ) {
		
		String sql = "insert into ex3 ( bcontent , bwriter ) values ( ? , ? )";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getBcontent() );
			ps.setString(2, dto.getBwriter() );
			
			ps.executeUpdate();
			
			return true ;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	// 2. 읽기 [ R ] 
	public ArrayList<BoardDTO> onprint() {
		
		ArrayList<BoardDTO> list = new ArrayList<>();
		
		String sql = "select * from ex3";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				BoardDTO dto = new BoardDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
				);
				
				list.add(dto);
			}
			return list;
					
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	
	
	// 4. 삭제 [ D ]
	public boolean ondelete( int bno ) {
		
		String sql = "delete from ex3 where bno = ? ";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, bno);
			
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false; 
	}
	
	
	public boolean onupdate( int bno , String bcontent ) {
		
		String sql = "update ex3 set bcontent = ? where bno = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, bcontent);
			ps.setInt(2, bno);
			
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false ;
	}
	
	//------------------------------------------------------------------------------
	
	
	
	// 1. 제품등록 [ C ] 
	public boolean onadd( ProductDTO dto ) {
		
		String sql = "insert into product ( name, price ) values ( ? , ? )";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getName() );
			ps.setInt(2, dto.getPrice() );
			
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false; 
		
	}
	
	
	// 2. 제품출력 [ R ] 
	public ArrayList<ProductDTO> getProduct(){
		
		ArrayList<ProductDTO> list = new ArrayList<>();
		
		String sql = "select * from product";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				ProductDTO dto = new ProductDTO(
						rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4) );
				
				list.add(dto);
			}
			return list ;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}
	
	
	// 3. 제품수정 [ U ] 
	public boolean prod_update( String name , int price , int seq ) {
		
		String sql = "update product set name = ? , price = ? where seq = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setInt(2, price);
			ps.setInt(3, seq);
			
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	// 4. 제품삭제 [ D ]
	public boolean prod_delete( int seq ) {
		
		String sql = "delete from product where seq = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, seq);
			
			ps.executeUpdate();
			
			return true ;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false; 
	}
	
	
}
