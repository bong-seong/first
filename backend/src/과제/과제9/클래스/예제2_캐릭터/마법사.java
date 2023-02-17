package 과제.과제9.클래스.예제2_캐릭터;

public class 마법사 extends 캐릭터 {

	public 마법사() {}
	public 마법사( int 체력 , int 마력 , int 스테미너 ) {
		this.체력 = 체력;
		this.마력 = 마력;
		this.스테미너 = 스테미너;
	}
	// 3. 메소드
	

	public void 지팡이() {
		System.out.println("지팡이를 휘두른다.");
	}
	
	public void 마법() {
		System.out.println("마법을 사용합니다.");
	}
	
}
