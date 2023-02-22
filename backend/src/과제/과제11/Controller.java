package 과제.과제11;

import java.util.ArrayList;

public class Controller {

	
	//* 싱글톤
	private static Controller c = new Controller();
	private Controller() {}
	public static Controller getInstance() {
		return c;
	}
	
	// 1. 제품 등록 --------------------------------------------------------------------------------
	public boolean add( String name, int price, int inven ) {
		
		ProductDTO dto = new ProductDTO(0, name, price, inven);
		return ProductDAO.getInstance().add(dto);
	}
	// ------------------------------------------------------------------------------------------
	
	
	// 2. 모든 제품 출력 ----------------------------------------------------------------------------
	public ArrayList<ProductDTO> print(){
		return ProductDAO.getInstance().print();
	}
	// ------------------------------------------------------------------------------------------
	
	
	// 3. 제품 수정 --------------------------------------------------------------------------------
	public boolean edit( int seq , String name , int price , int ch ) throws Exception {
		
		ProductDTO dto = new ProductDTO(seq, name, price);
		return ProductDAO.getInstance().edit(dto, ch); 
	}
	// ------------------------------------------------------------------------------------------
	
	
	// 4. 제품 재고 --------------------------------------------------------------------------------
	public boolean inven_update( int seq , int inven ) {
		return ProductDAO.getInstance().inven_update(seq, inven);
	}
	// ------------------------------------------------------------------------------------------
	
	
	// 5. 제품 삭제 --------------------------------------------------------------------------------
	public boolean delete( int seq ) {
		return ProductDAO.getInstance().delete(seq);
	}
	// ------------------------------------------------------------------------------------------
	
	
	
	public ArrayList<ProductDTO> cart_print(){
		return ProductDAO.getInstance().cart_print();
	}
	
	
	public boolean cart_add( int seq ) {
		
		ArrayList<ProductDTO> all = ProductDAO.getInstance().print();
		for( int i=0; i<all.size(); i++ ) {
			if( all.get(i).getSeq() == seq && all.get(i).getInven() > 0 ) {
				return ProductDAO.getInstance().cart_add(seq, all.get(i).getInven());
			}
		}
		
		return false;
	}
	
	
	
	
	
	
	
}
