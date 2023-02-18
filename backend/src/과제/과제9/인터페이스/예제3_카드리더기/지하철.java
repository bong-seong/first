package 과제.과제9.인터페이스.예제3_카드리더기;

public class 지하철 implements 카드리더기 {
	
	int 신한잔고;
	long 우리잔고;
	
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
	
	public long 잔액확인( String card ) {
		if( card.equals(this.CARD_NAME_1)) {
			System.out.println("남은 잔액 : " + this.신한잔고 );
		}else if( card.equals(this.CART_NAME_2) ) {
			System.out.println("남은 잔액 : " + this.우리잔고 );
		}
		return 0;
	}
	
	public void 충전( String card , int 금액 ) {
		if( card.equals(this.CARD_NAME_1)) {
			this.신한잔고 += 금액;
			System.out.println("잔액 : " + this.신한잔고 );
		}else if( card.equals(this.CART_NAME_2) ) {
			this.우리잔고 += 금액;
			System.out.println("잔액 : " + this.우리잔고 );
		}
	}
}

