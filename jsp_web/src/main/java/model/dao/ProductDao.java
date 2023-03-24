package model.dao;

import java.util.ArrayList;

import model.dto.ProductDto;

public class ProductDao extends Dao {

	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() { return dao ; }
	
	// 1. 제품 등록
	public boolean write( ProductDto dto ) {
		
		String sql = "insert into product( pname , pcomment , pprice , plat , plng ) value ( ? , ? , ? , ? , ?)";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getPname() );
			ps.setString(2, dto.getPcomment() );
			ps.setLong(3, dto.getPprice() );
			ps.setString(4, dto.getPlat() );
			ps.setString(5, dto.getPlng() );
			
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	// 2. 제품 호출
	public ArrayList<ProductDto> getProduct( String dong , String seo , String nam ,String book ){
		
		ArrayList<ProductDto> list = new ArrayList<>();
		
		String sql = "select * from product where plng <= ? and plng >= ? and plat >= ? and plat <= ?";
		
		try{
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dong);
			ps.setString(2, seo);
			ps.setString(3, nam);
			ps.setString(4, book);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				list.add( new ProductDto(
						rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getLong(4), rs.getInt(5), rs.getString(6),
						rs.getString(7), rs.getInt(8), rs.getString(9)
				));
			}
		
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return list ;
	}
	
	
	// 3. 찜하기
	public boolean setplike( int pno , int mno ) {
		
		// 1. 등록할지 취소할지 검색 먼저하기
		String sql = "select * from plike where pno = "+pno+" and mno = "+mno;
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if( rs.next() ) { // 이미 찜하기를 한 제품
				
				sql = "delete from plike where pno = "+pno+" and mno = "+mno ;
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return false;
				
			}else {
				
				sql = "insert into plike ( pno , mno ) values ( "+pno+" , "+mno+" )";
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return true;
			
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	// 4. 현재 회원이 해당 제품의 찜하기 상태 확인
	public boolean getplike( int pno , int mno ) {
		
		String sql = "select * from plike where pno = "+pno+" and mno = "+mno;
		
			try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if( rs.next() ) { return true ; }
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
}











