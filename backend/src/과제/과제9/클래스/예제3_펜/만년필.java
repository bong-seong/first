package 과제.과제9.클래스.예제3_펜;

public class 만년필 extends 펜 {

	// 1. 필드
	boolean installation;
	
	
	// 2. 생성자
	public 만년필() {}
	public 만년필( String model, int thickness ) {
		this.model = model;
		this.thickness = thickness;
	}
	
	// 3. 메소드
	
	public void 사용() {
		System.out.println("만년필을 사용해 편지를 씁니다.");
		this.installation = false;
	}
	
	public void 잉크() {
		this.installation = true;
		System.out.println("잉크를 묻힙니다.");
	}
}
