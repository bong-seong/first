package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.dto.ProductDto;

public class ProductDao extends Dao {

	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() { return dao ; }
	
	// 1. 제품 등록
	public boolean write( ProductDto dto ) {
		
		// 1. 제품 우선 등록
		String sql = "insert into product( pname , pcomment , pprice , plat , plng , mno ) "
				+ " value ( ? , ? , ? , ? , ? , ? )";
		
		try {
			// insert 후 생성된 제품 pk 번호 호출
			ps = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS );
			
			ps.setString(1, dto.getPname() );
			ps.setString(2, dto.getPcomment() );
			ps.setLong(3, dto.getPprice() );
			ps.setString(4, dto.getPlat() );
			ps.setString(5, dto.getPlng() );
			ps.setInt(6, dto.getMno() );
			
			ps.executeUpdate();
			
			// insert 후 생성된 제품 pk 번호 호출
			rs = ps.getGeneratedKeys();
			if( rs.next() ) { // 만약에 생성된 제품 pk번호가 존재하면
				for( String pimgname : dto.getPimglist() ) {
					// dto 내 첨부파일명 리스트에 하나씩 첨부파일명을 insert 하기
					sql = "insert into pimg( pimgname , pno ) values ( ? , ? )";
					
					ps = con.prepareStatement(sql);
					
					ps.setString(1, pimgname); 
					ps.setInt(2, rs.getInt(1) );
					
					ps.executeUpdate();
					
				}
			}
			
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	// 2. 제품 호출
	public ArrayList<ProductDto> getProduct( String dong , String seo , String nam ,String book ){
		
		ArrayList<ProductDto> list = new ArrayList<>();
		
		String sql = "select p.* , m.mid , m.mimg from product p natural join member m "
				+ " where p.plng <= ? and p.plng >= ? and p.plat >= ? and p.plat <= ? ";
		
		try{
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dong);
			ps.setString(2, seo);
			ps.setString(3, nam);
			ps.setString(4, book);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				ArrayList<String> pimglist = new ArrayList<>();
				sql = "select * from pimg where pno = " + rs.getInt(1); // 동일한 제품번호의 이미지들을 호출
				
				ps = con.prepareStatement(sql);
				ResultSet rs2 = ps.executeQuery();
						
				
				while( rs2.next() ) {
					pimglist.add( rs2.getString(2) ); // 검색된 이미지이름을 리스트에 저장
				}
				
				ProductDto dto = new ProductDto( 
						rs.getInt(1) , rs.getString(2) , rs.getString(3), 
						rs.getInt(4) , rs.getInt(5) , rs.getString(6) , 
						rs.getString(7) , rs.getInt(8) , rs.getString(9) , 
						rs.getInt(10) , rs.getString(11) , rs.getString(12) , pimglist );
				
				list.add( dto );
						
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











