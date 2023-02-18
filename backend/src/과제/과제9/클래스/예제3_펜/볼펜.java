package 과제.과제9.클래스.예제3_펜;

public class 볼펜 extends 펜 {
	
	// 1. 필드
	String color;
	
	// 2. 생성자
	public 볼펜() {}
	public 볼펜( String model, int thickness ) {
		this.model = model;
		this.thickness = thickness;
	}
	
	// 3. 메소드
	
	public void 사용() {
		System.out.println("볼펜 사용해 필기를합니다.");
	}
	
	public void 컬러( String color ) {
		System.out.println( color + " 색상을 선택하셨습니다.");
	}
	
	

}
