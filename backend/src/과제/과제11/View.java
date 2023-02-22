package 과제.과제11;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
	
	private static View view = new View();
	private View() {}
	public static View getInstance() {
		return view;
	}
	
	private Scanner scanner = new Scanner(System.in);
	
	
	public void main() {
		while( true ) {
			System.out.println("---------- 마켓 ----------");
			System.out.println("1.관리자 / 2.사용자");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) { index(); }
			else if( ch == 2 ) { user_index(); }
		}
	}
	
	
	public void index() {
		while( true ) {
			
			try {
			System.out.println("1.등록[C] / 2.출력[R] / 3.수정[U] / 4.재고수정[U] / 5.삭제[D] / 6.뒤로가기");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) { add(); }
			else if( ch == 2 ) {
					System.out.println("---------- 제품정보 ----------");
					print(); 
				}
			else if( ch == 3 ) { edit(); }
			else if( ch == 4 ) { inven_edit(); } 
			else if( ch == 5 ) { delete(); }
			else if( ch == 6 ) { break; }
				
			}
			catch(Exception e ) {
				System.out.println("입력 형식이 다릅니다. 숫자를 입력해주세요" + e );
				scanner = new Scanner(System.in);
			}
		}
	}
	
	
	
	// 1. 제품 등록 --------------------------------------------------------------------------------
	public void add(){
		System.out.println("---------- 제품등록 ----------");
		System.out.print("제품명 : ");
		String name = scanner.next();
		
		System.out.print("제품가격 : ");
		int price = scanner.nextInt();
		
		System.out.println("제품재고 : ");
		int inven = scanner.nextInt();
		
		boolean result = Controller.getInstance().add(name, price, inven);
		
		if(result) {
			System.out.println("[ 제품 등록 완료 ]");
		}else {
			System.err.println("[ 제품 등록 실패 ]");
		}
	}
	// ------------------------------------------------------------------------------------------
	
	
	
	// 2. 모든 제품 출력 ----------------------------------------------------------------------------
	public void print() {
		System.out.println("제품번호\t\t제품명\t\t제품가격\t\t제품재고");
		
		ArrayList<ProductDTO> pd = Controller.getInstance().print();
		
		for( int i=0; i<pd.size(); i++ ) {
			System.out.printf("%d\t\t%s\t\t%d\t\t%d\n" , 
					pd.get(i).getSeq() , pd.get(i).getName() , pd.get(i).getPrice() , pd.get(i).getInven()
			);
		}
		
	}
	// ------------------------------------------------------------------------------------------
	
	
	
	// 3. 제품 수정 --------------------------------------------------------------------------------
	public void edit() throws Exception {
		System.out.println("---------- 제품수정 ----------");
		print();
		System.out.println();
		System.out.print("수정할 제품번호 : ");
		int seq = scanner.nextInt();
		
		System.out.println("해당 제품의 어떤 내용을 수정하시겠습니까?");
		System.out.println("1.제품이름 / 2.제품가격 / 3.이름,가격 두개모두");
		int ch = scanner.nextInt();
		
		String name = null;
		int price = 0;
		
		if( ch == 1 ) {
			System.out.print("새로운 제품명 : ");
			name = scanner.next();
		}
		else if( ch == 2 ) {
			System.out.print("새로운 제품 가격 : ");
			price = scanner.nextInt();
		}
		else if( ch == 3 ) {
			System.out.print("새로운 제품명 : ");
			name = scanner.next();
			System.out.print("새로운 제품 가격 : ");
			price = scanner.nextInt();
		}
		
		boolean result = Controller.getInstance().edit(seq, name, price, ch);
		
		if( result ) {
			System.out.println("정상 수정되었습니다.");
		}
		else {
			System.out.println("수정 실패");
		}
		
	}
	// ------------------------------------------------------------------------------------------
	
	
	
	// 4. 제품 재고 --------------------------------------------------------------------------------
	public void inven_edit() {
		System.out.println("---------- 제품재고 ----------");
		print();
		System.out.println();
		System.out.print("수정할 제품번호 : ");
		int seq = scanner.nextInt();
		
		System.out.print("수정할 재고 : ");
		int price = scanner.nextInt();
		
		boolean result = Controller.getInstance().inven_update(seq, price);
		
		if( result ) {
			System.out.println("정상 수정되었습니다.");
		}
		else {
			System.out.println("수정 실패");
		}
	}
	// ------------------------------------------------------------------------------------------
	
	
	
	// 5. 제품 삭제 --------------------------------------------------------------------------------
	public void delete() {
		System.out.println("---------- 제품삭제 ----------");
		print();
		System.out.println();
		System.out.print("삭제할 제품번호 : ");
		int seq = scanner.nextInt();
		
		boolean result = Controller.getInstance().delete(seq);
		
		if( result ) {
			System.out.println("정상 삭제되었습니다.");
		}
		else {
			System.out.println("삭제 실패");
		}
	}
	
	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	
	
	
	// 유저 메인 ------------------------------------------------------------------------------------
	public void user_index() {
		
		while( true ) {
	
			System.out.println("---------- 구매 ----------");
			user_print();
			System.out.println();
			System.out.println("0: 결제 / 장바구니추가: 제품번호입력  ||  뒤로가기 : -1");
			int seq = scanner.nextInt();
			
			if( seq == 0 ) { cart_print(); }
			else if( seq == -1 ) { break; }
			else { cart_add( seq ); }
			
		}
		
	}
	// ------------------------------------------------------------------------------------------
	
	
	
	// 전체 제품출력 유저ver ---------------------------------------------------------------------------
	public void user_print() {
		System.out.println("제품번호\t\t제품명\t\t제품가격\t\t상태");
		
		ArrayList<ProductDTO> pd = Controller.getInstance().print();
		
		for( int i=0; i<pd.size(); i++ ) {
			System.out.printf("%d\t\t%s\t\t%d\t\t%s\n" , 
					pd.get(i).getSeq() , pd.get(i).getName() , pd.get(i).getPrice() , 
					(pd.get(i).getInven() > 0) ? "판매중" : "재고부족" 
			);
		}
	}
	// ------------------------------------------------------------------------------------------
	
	
	
	// 장바구니 ------------------------------------------------------------------------------------
	public void cart_print() {
		
		System.out.println("---------- 장바구니 ---------");
		
		ArrayList<ProductDTO> user_pd = Controller.getInstance().cart_print();
		
		for( int i=0; i<user_pd.size(); i++ ) {
			System.out.printf("%s\t\t%d\n" ,
					user_pd.get(i).getName(), user_pd.get(i).getPrice() );
		}
	}
	// ------------------------------------------------------------------------------------------
	
	
	
	// 장바구니 추가 ---------------------------------------------------------------------------------
	public void cart_add( int seq ) {
		
		boolean result = Controller.getInstance().cart_add(seq);
		
		if(result) {
			System.out.println("장바구니에 추가되었습니다.");
		}else {
			System.err.println("[ 재고 부족 ] 장바구니 추가에 실패하였습니다.");
		}
	}
	// ------------------------------------------------------------------------------------------
	
	

}
