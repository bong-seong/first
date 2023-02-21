package Day15.Ex4_p512;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

public class System클래스 {

	public static void main(String[] args) {
		
		// 1. 
		
		System.out.println("출력");	// 콘솔에 출력
		System.err.println("에러");	// 콘솔에 에러[빨강] 출력
		
		int value = 100; // int에 100 대입 가능 : 이상없다.
		// int value2 = "100" // int에 "100" 대입 불가능 : 문자열이기때문에 불가능
				// 문자열 --> 기본타입 변환
		int value3 = Integer.parseInt("100");	// "100" -> 100 변환
		
		
		try { // try{} 에 예외가 발생할 것 같은 코드 [*경험]
			int value4 = Integer.parseInt("1oo");	// "1oo" -> 변환 X
		}
		catch( NumberFormatException e ) { // try{} 에서 에외[오류] 발생했을때 catch{ } 실행 
			System.err.println("에러내용");
			System.err.println( e.getMessage() );
		}
		
		
		// 2. p514
		int speed = 0;
		int KeyCode = 0;
		
		while( true ) {
			
			if( KeyCode != 13 && KeyCode != 10 ) { // 엔터[ 13,10 ] 가 아니고
				if( KeyCode == 49 ) {	// 숫자1의 코드는 49
					speed++;
				}else if( KeyCode == 50 ) { // 숫자2의 코드는 50
					speed--;
				}else if( KeyCode == 51 ) { // 숫자3의 코드는 51
					//break;
					System.exit(0);	// 0:정상종료 , 1 or -1 : 비정상종료 으로 관례적으로 뜻함
				}
				
			}
			System.out.println("현재 속도 : " + speed );
			System.out.println("1.증속 / 2. 감속 / 3. 중지");
			
			try {
			KeyCode = System.in.read();	// 입력받아 코드로 반환 [ * 예외처리 필수 ]
			}
			catch( Exception e ){
				System.out.println("에러 : " + e );
			}
			
		}
		
		
		// p.516
		
		
		
	}
	
}
