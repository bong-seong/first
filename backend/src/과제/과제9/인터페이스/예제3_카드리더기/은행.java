package 과제.과제9.인터페이스.예제3_카드리더기;

public class 은행 implements 카드리더기 {
	
	
	int 신한잔고;
	long 우리잔고;
	
	
	
	public 은행() {}
	public 은행( int 신한잔고 ) {
		this.신한잔고 = 신한잔고;
	}
	public 은행( long 우리잔고 ) {
		this.우리잔고 = 우리잔고;
	}
	
	
	
	@Override
	public String 카드정보읽기( int ch ) {
		if( ch == 1 ) {
			System.out.println("현재카드 : 신한카드");
			return this.CARD_NAME_1; 
		}else if( ch == 2 ) {
			System.out.println("현재카드 : 우리카드");
			return this.CART_NAME_2;
		}
		return null;
	}
	
	public void 입금( String cardInfo , int 금액 ) {
		if( cardInfo.equals( this.CARD_NAME_1 ) ) {
			this.신한잔고 += 금액;
			System.out.println("입금이 완료되었습니다.");
		}else if( cardInfo.equals( this.CART_NAME_2 )) {
			this.우리잔고 += 금액;
			System.out.println("입금이 완료되었습니다.");
		}
	}
	
	public void 출금( String cardInfo , int 금액 ) {
		if( cardInfo.equals( this.CARD_NAME_1 ) ) {
			if( this.신한잔고 <= 0 ) {
				System.out.println("금액이 부족합니다.");
			}else {
				this.신한잔고 -= 금액;
			}
		}else if( cardInfo.equals( this.CART_NAME_2 )) {
			if( this.우리잔고 <= 0 ) {
				System.out.println("금액이 부족합니다.");
			}else {
				this.우리잔고 -= 금액;
			}
		}
		System.out.println("출금이 완료되었습니다.");
	}
}
