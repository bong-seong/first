package 과제.과제9.클래스.예제1_동물;

public class 원숭이 extends 동물 {

	
	// 2. 생성자
		public 원숭이() {}
		public 원숭이( String 털색상, String 다리갯수 ) {
			this.털색상 = 털색상;
			this.다리갯수 = 다리갯수;
		}
		
		@Override
		public void 먹는다() {
			System.out.println("원숭이가 밥을 먹습니다.");
		}
		
		@Override
		public void 운다() {
			System.out.println("원숭이가 우끼끼하고 웁니다.");
		}
		
		
		public void 움직인다() {
			System.out.println("원숭이가 두발로 걷습니다.");
		}
	
}
