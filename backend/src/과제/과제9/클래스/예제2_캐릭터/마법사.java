package 과제.과제9.클래스.예제2_캐릭터;

public class 마법사 extends 캐릭터 {

	
	
	public 마법사() {}
	public 마법사( String 현재전직 , int 체력 , int 마력 , int 스테미너 ) {
		this.현재전직 = 현재전직;
		this.체력 = 체력;
		this.마력 = 마력;
		this.스테미너 = 스테미너;
	}
	// 3. 메소드
	
	@Override
	public void 공격() {
		System.out.println("지팡이를 휘두른다.");
	}
	
	public void 스킬() {
		System.out.println("마법을 사용합니다.");
	}
	
}
