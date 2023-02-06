package 과제.과제2;

import java.util.Scanner;

public class 과제2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 각 제품 재고
		int coke = 300; 			int sprite = 400; 		int fanta = 500;
		byte cokeCount = 10;		byte spriteCount = 8;	byte fantaCount = 15;
		byte cokeOrder = 0;			byte spriteOrder = 0;	byte fantaOrder = 0; 
		
		while( true ) {
			System.out.println("제품을 선택하세요 ");
			System.out.println("1. 콜라 / 2. 사이다 / 3.환타 / 4. 결제 / 5. 종료");
			System.out.print(" >>> ");
			byte item = scanner.nextByte(); 
			
			if( item == 1 ) {
				
				if( cokeCount > 0 ) {
					cokeOrder++; cokeCount --;
					System.out.println("콜라를 선택하셨습니다. : " + cokeOrder + "개");
					System.out.println("잔여수량 : " + cokeCount );
				}else {
					System.err.println("남은 수량이 없습니다.");
				}
				
			}else if( item == 2 ){
				
				if( spriteCount > 0 ) {
					spriteOrder++; spriteCount --;
					System.out.println("사이다를 선택하셨습니다. : " + spriteOrder + "개");
					System.out.println("잔여수량 : " + spriteCount );
				}else {
					System.err.println("남은 수량이 없습니다.");
				}
				
			}else if( item == 3 ) {
				
				if( fantaCount > 0 ) {
					fantaOrder++; fantaCount --;
					System.out.println("환타를 선택하셨습니다. : " + fantaOrder + "개");
					System.out.println("잔여수량 : " + fantaCount );
				}else {
					System.err.println("남은 수량이 없습니다.");
				}
				
			}else if( item == 4 ) {
				System.out.println("장바구니");
				System.out.println("-----------------------------");
				
				int total = (coke*cokeOrder) + (sprite*spriteOrder) + (fanta*fantaOrder) ;
				
				if( cokeOrder == 0 && spriteOrder == 0 && fantaOrder == 0 ) {
					System.err.println("선택하신 제품이 없습니다.");
				}else {
					System.out.println("제품명\t수량\t가격");
					if( cokeOrder > 0 ) { System.out.println("콜라\t"+ cokeOrder + "\t" + (coke*cokeOrder) ); } 
					if( spriteOrder > 0 ) { System.out.println("사이다\t"+ spriteOrder + "\t" + (sprite*spriteOrder) ); }
					if( fantaOrder > 0 ) { System.out.println("환타\t"+ fantaOrder + "\t" + (fanta*spriteOrder) ); }
		
					System.out.println("총 가격 : " + total );
				}
				System.out.println(" ");
				System.out.println("결제 하시겠습니까? 1.결제하기 / 2.취소하기");
				byte paySelect = scanner.nextByte();
				if( paySelect == 1 ) {
					System.out.print(" >>> 지불할 금액을 입력해주세요 : ");
					int pay = scanner.nextInt();
					
					if( total < pay ) {
						System.out.println( pay + "를 지불하셨습니다.");
						System.out.println( "거스름 돈 : " + (pay-total) );
						cokeOrder = 0; spriteOrder = 0; fantaOrder = 0; total = 0;
					}else {
						System.err.println("금액이 부족하여 결제가 취소됩니다.");
						cokeCount += cokeOrder;
						spriteCount += spriteOrder;
						fantaCount += fantaOrder;
						cokeOrder = 0; spriteOrder = 0; fantaOrder = 0;
					}
				}else {
					System.err.println("결제를 취소하셨습니다.");
					cokeCount += cokeOrder;
					spriteCount += spriteOrder;
					fantaCount += fantaOrder;
					cokeOrder = 0; spriteOrder = 0; fantaOrder = 0;
				}
				
				
				
			}else if( item == 5 ) {
				System.err.println("구매를 종료합니다.");
				break;
			}else {
				System.err.println("올바른 값을 입력해주세요.");
			}
			
		}
		
	}
	
}
