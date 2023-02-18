package 과제.과제9.인터페이스.예제2_충전기;

public class 핀5 implements 충전기 {

	
	String checked = "■";
	
	@Override
	public void 충전() {
		System.out.println("규격 외 폰을 충전합니다.");
		System.out.print("충전중 ");
		
		for( int j=0; j<=20; j++ ) {
			System.out.print( checked );
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println(" 100%");
		System.out.println("충전이 완료되었습니다.");
		
	}
}
