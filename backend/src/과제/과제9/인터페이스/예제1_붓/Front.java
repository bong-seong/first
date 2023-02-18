package 과제.과제9.인터페이스.예제1_붓;

import java.util.Scanner;

public class Front {
	
	private static Front front = new Front();
	private Front() {};
	public static Front getInstance() {
		return front;
	}
	
	붓 붓;
	
	Scanner scanner = new Scanner(System.in);
	
	
	public void index() {
		while( true ) {
			
			System.out.println("색상을 선택해주세요 >> 1. 빨간색  / 2. 파란색 / 3. 녹색 / 4. 기본색상");
			
			int ch = scanner.nextInt();
			붓 result = color_change( ch );
			
			if( result instanceof 빨간물감 ) {
				빨간물감 붓 = (빨간물감)result;
				붓.그리기();
			}else if( result instanceof 파란물감 ) {
				파란물감 붓 = (파란물감)result;
				붓.그리기();
			}else if( result instanceof 녹색물감 ) {
				녹색물감 붓 = (녹색물감)result;
				붓.그리기();
			}
			
			
		}
	}
	
	public 붓 color_change( int ch ) {
		
		if( ch == 1 ) {
			붓 = new 빨간물감("빨간색");
			빨간물감 빨간색 = (빨간물감)붓;
			System.out.println("현재 컬러 " + 빨간색.color );
			return 빨간색;
			
		}else if(ch == 2 ) {
			붓 = new 파란물감("파란색");
			파란물감 파란색 = (파란물감)붓;
			System.out.println("현재 컬러 " + 파란색.color );
			return 파란색;
			
		}else if( ch == 3 ) {
			붓 = new 녹색물감("녹색");
			녹색물감 녹색 = (녹색물감)붓;
			System.out.println("현재 컬러 " + 녹색.color );
			return 녹색;
		}else if( ch == 4 ) {
			붓.setDefault();
		}
		
		return null;
	}
}
