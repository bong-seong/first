package 과제.과제9.인터페이스.예제3_카드리더기;

public class 편의점 implements 카드리더기 {
	
	int 잔고 = 10000;
	
	@Override
	public String 카드정보읽기( int ch ) {
		if( ch == 1 ) {
			System.out.println("현재카드 : 신한카드");
			return this.CARD_NAME_1; 
		}else if( ch == 2 ) {
			System.err.println("해당 카드는 잃어버렸습니다.");
			return null;
		}
		return null;
	}
	
	public void 결제( int ch ) {
		if( 잔고 > 999 ) {
			if( ch == 1 ) {
				잔고 -= 1000;
				System.out.println("콜라가 결제되었습니다.");
			}else if( ch == 2 ) {
				잔고 -= 1500;
				System.out.println("컵라면이 결제되었습니다.");
			}
		}else {
			System.out.println("잔액이 부족합니다.");
		}
	}
	
}
