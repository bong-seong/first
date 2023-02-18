package 과제.과제9.인터페이스.예제3_카드리더기;

import java.util.Scanner;

public class Front {

	카드리더기 카드;
	Scanner scanner = new Scanner(System.in);
	
	
	public void index() {
		while( true ) {
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("1. 편의점가기 / 2. 은행가기 / 3. 지하철타기");
			
			int ch = scanner.nextInt();
			
			if( ch == 1 ) { convenience_store(); }
			else if( ch == 2 ) { bank(); }
			else if( ch == 3 ) { subway(); }
		}
	}
	
	public void convenience_store() {
		while( true ) {
			System.out.println("어서오세요, 편의점입니다." );
			편의점 card = new 편의점();
			String result = card_select( card );
			if( result == null ) { break; }
			while( true ) {
				System.out.println("현재 잔고 : " + card.잔고 );
				System.out.println("1. 콜라(1000원) / 2. 컵라면(1500원) / 3. 카드선택");
				int ch = scanner.nextInt();
				
				if( ch == 1 ) { card.결제( ch ); }
				else if( ch == 2 ) { card.결제( ch );}
				else if( ch == 3) { break; }
			}
		}
	}
	
	public String card_select( 카드리더기 card ) {
		System.out.println("카드를 선택해주세요 1. 신한 / 2. 우리 / 3. 나가기");
		int ch = scanner.nextInt();
		if( ch == 1 ) { 
			String 카드정보 = card.카드정보읽기( ch );
			return 카드정보;
		}else if( ch == 2 ) {
			String 카드정보 = card.카드정보읽기( ch );
			return 카드정보;
		}else if( ch == 3 ) {
			return null;
		}
		return null;
	}
	
	public void bank() {
		
		은행 card = new 은행();
		
		while( true ){
			System.out.println("어서오세요, 은행입니다.");
			String result = card_select( card );
			if( result == null ) { break; }
			while( true ) {
				if( result.equals( 카드리더기.CARD_NAME_1 )) {
					System.out.println("현재 잔고 : " + card.신한잔고);
				}else if( result.equals( 카드리더기.CART_NAME_2 ))
					System.out.println("현재 잔고 : " + card.우리잔고);
				System.out.println("1. 입금하기 / 2. 출금하기 / 3. 카드선택");
				int ch = scanner.nextInt();
				
				if( ch == 1 ) {
					System.out.println("입금하실 금액을 입력하세요");
					int 금액 = scanner.nextInt();
					card.입금(result, 금액);
				}
				else if( ch == 2 ) {
					System.out.println("출금하실 금액을 입력하세요");
					int 금액 = scanner.nextInt();
					card.출금(result, 금액);
				}
				else if( ch == 3 ) { break; }
			}
		}
	}
	
	
	public void subway() {
		
		지하철 card = new 지하철();
		
		while( true ) {
			System.out.println("어서오세요, 지하철입니다." );
			String result = card_select( card );
			if( result == null ) { break; }
			while( true ) {
				System.out.println("1. 잔액확인하기 / 2. 금액충전하기 / 3. 카드선택");
				int ch = scanner.nextInt();
				
				if( ch == 1 ) { card.잔액확인(result); }
				else if( ch == 2 ) {
					System.out.println("충전할 금액을 입력해주세요");
					int 금액 = scanner.nextInt();
					card.충전(result, 금액);
				}else if( ch == 3) { break; }
			}
		}
	}
	
	
	
}
