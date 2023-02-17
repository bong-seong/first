package 과제.과제9.클래스.예제2_캐릭터;

public class 전사 extends 캐릭터 {

	
	// 1. 필드
	// 2. 생성자
	public 전사() {}
	public 전사( int 체력 , int 마력 , int 스테미너 ) {
		this.체력 = 체력;
		this.마력 = 마력;
		this.스테미너 = 스테미너;
	}
	// 3. 메소드
	
	public void 칼() {
		System.out.println("칼을 휘두른다.");
	}
	
	public void 방패() {
		System.out.println("방패로 막는다");
	}
	
}
