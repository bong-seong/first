package 과제.과제9.인터페이스.예제1_붓;

public class 빨간물감 implements 붓 {
	
	String color;
	
	public 빨간물감( String color ) {
		this.color = color;
	}
	
	@Override
	public void 그리기() {
		System.out.println( RED + "빨간색으로 그림을 그립니다." + RESET );
	}
	
}
