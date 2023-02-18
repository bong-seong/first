package 과제.과제9.클래스.예제3_펜;

public class 펜 {
	
	// 1.필드
	String model;
	int thickness;
	
	
	// 2. 생성자
	public 펜() {}
	public 펜( String model, int thickness ) {
		this.model = model;
		this.thickness = thickness; 
	}
	
	
	// 3. 메소드
	public void 사용() {
		System.out.println("펜을 사용해 종이에 글을 씁니다.");
	}
	
}
