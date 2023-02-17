package 과제.과제9.클래스.예제2_캐릭터;

public class 도적 extends 캐릭터 {

	
	public 도적() {}
	public 도적( int 체력 , int 마력 , int 스테미너 ) {
		this.체력 = 체력;
		this.마력 = 마력;
		this.스테미너 = 스테미너;
	}
	// 3. 메소드
	
	
	public void 단검() {
		System.out.println("단검을 휘두른다.");
	}
	
	public void 은신() {
		System.out.println("은신을 사용합니다.");
	}
	
}
