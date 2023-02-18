package 과제.과제9.클래스.예제2_캐릭터;

public class 캐릭터 {
	
	// 1. 필드
	String 현재전직;
	int 체력;
	int 마력;
	int 스테미너;
	
	// 2. 생성자
	public 캐릭터() {}
	public 캐릭터( String 현재전직, int 체력 , int 마력 , int 스테미너 ) {
		this.현재전직 = 현재전직;
		this.체력 = 체력;
		this.마력 = 마력;
		this.스테미너 = 스테미너;
	}
	
	
	// 3. 메소드
	public void 공격() {
		System.out.println("공격합니다.");
	}

}
