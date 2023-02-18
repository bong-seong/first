package 과제.과제9.인터페이스.예제1_붓;

public class 녹색물감 implements 붓 {
	
	String color;
	
	public 녹색물감( String color ) {
		this.color = color;
	}
	
	
	@Override
	public void 그리기() {
		System.out.println(GREEN + "녹색으로 그림을 그립니다." + RESET );
	}
	
}
