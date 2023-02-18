package 과제.과제9.인터페이스.예제2_충전기;

import java.util.Scanner;

public class Front {

	private static Front front = new Front();
	private Front() {};
	public static Front getInstance() {
		return front;
	}
	
	Scanner scanner = new Scanner(System.in);
	충전기 젠더;
	
	public void index() {
		while( true ){
			System.out.println("----- 휴대폰 충전 -----");
			System.out.println("충전하실 휴대폰 기종을 선택하여주세요 >> 1. 아이폰 / 2. 갤럭시 / 3. 그외규격(옛날폰)");
			
			int ch = scanner.nextInt();
			
			if( ch == 1) {
				젠더 = new 핀8();
				젠더.충전();
			}else if( ch == 2) {
				젠더 = new 핀C();
				젠더.충전();
			}else if( ch == 3 ) {
				젠더 = new 핀5();
				젠더.충전();
			}
		}
	}
	
}
