package 과제.과제9.클래스.예제1_동물;

public class 비둘기 extends 동물 {
	
	
	// 2. 생성자
		public 비둘기() {}
		public 비둘기( String 털색상, String 다리갯수 ) {
			this.털색상 = 털색상;
			this.다리갯수 = 다리갯수;
		}
		
		@Override
		public void 먹는다() {
			System.out.println("비둘기 바닥에있는 과자를 먹습니다.");
		}
		
		@Override
		public void 운다() {
			System.out.println("비둘기가 구구구구하고 웁니다.");
		}
		
		
		public void 움직인다() {
			System.out.println("비둘기가 날아가다 떨어집니다.");
		}

}
