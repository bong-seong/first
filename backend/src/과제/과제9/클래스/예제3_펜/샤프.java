package 과제.과제9.클래스.예제3_펜;

public class 샤프 extends 펜 {

	// 1. 필드
	boolean installation;
	int use_sharp;
	
	// 2. 생성자
	public 샤프() {}
	public 샤프( String model, int thickness ) {
		this.model = model;
		this.thickness = thickness;
	}
	
	// 3. 메소드
	
	public void 사용() {
		this.use_sharp--;
		System.out.println("샤프를 사용해 그림을 그립니다.");
		if( use_sharp <= 0 ) {
			System.err.println("사용 횟수를 모두 소진하였습니다.");
			this.installation = false;
		}
		
	}
	
	public void 샤프심() {
		this.installation = true;
		System.out.println("샤프심을 끼웁니다.");
		this.use_sharp = 5;
	}
	
}
