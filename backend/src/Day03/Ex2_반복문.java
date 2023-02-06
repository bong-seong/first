package Day03;

public class Ex2_반복문 {
	public static void main(String[] args) {
		
		
		/*
		  
		  
		 
		 */
		
		
		// 1. [ p.124 ]
		int sum = 0;
		
		for( int i=0; i<99 ; i++ ) { sum += i; }
		
		System.out.println( sum );
		
		
		// 2. [ p.125 ]
		for( int i=1; i<=10; i++ ) {
			// i는 1부터 10까지 1씩 반복증가
			System.out.println( i );
		}
		
		
		// 3. [ p.126 ] 1~100 까지 누적합계
		int total = 0 ;
		for( int i=1; i<=100; i++ ) {
			// i는 1부터 100까지 1씩 반복증가
			System.out.print( i + " ");
			total += i; // total = total + i 
		}
		System.out.println("\n총 누적합계 : " + total );

		// 4. [ p.127 ] 0.1 ~ 1.0 사이의 실수 출력
		for( float x = 0.1f; x<= 1.0f; x+=0.1f ) {
			// x는 0.1 부터 1.0까지 0.1씩 증가, 반복
			System.out.print( x + " " );
		}
		
		
		
		System.out.println();
		// 5. [ p.127 ] for중첩 : 구구단
		for( int dan=2; dan<=9; dan++ ) {
			System.out.println("단 : " + dan );
			for( int gob=1; gob<=9; gob++ ) {
				System.out.print("\t곱 : " + gob );
				System.out.println( "\t\t"+ dan + "x" + gob + "=" + (dan*gob));
			}
		}
		
		
		// 6. break; 반복문탈출  ///  return; 함수종료
		while( true ) { // 무한루프
			int num = (int)(Math.random()*6)+1;
			System.out.println( num );
			if( num == 6 ) { // 만약에 난수가 6이면
				System.out.println("while{ } 탈출");
				break; // 가장 가까운 반복문 탈출
			}
		}
		
		
		// 7. [ p.135 ] 
			// 이름 : for()
			// break 이름;
			// 1. for1
		첫번째for : for(char upper = 'A'; upper <= 'Z'; upper++ ) {
			// 'A' ~ 'Z' 까지 문자 하나씩 증가 반복
			System.out.println( upper );
			// 2. for2
			두번째for : for( char lower = 'a'; lower <= 'z'; lower++ ) {
				System.out.println("\t " + lower );
				if( lower == 'g') {
					// 만약에 소문자 g 이면 
					// break; // 가장 가까운 반복문 탈출
					break 첫번째for; // 특정 for 탈출
				}
			}
		}
		
		
		// 8. [ p.136 ] continue
		forname : for( int i=1; i<=10; i++ ) {
			if( i%2 != 0 ) { // i가 홀수이면
				// continue; // 가장 가까운 반복문[증감식]으로 이동
				continue forname; // 특정 반복문[증감식]으로 이동
			} // 조건에 해당하면 아래 코드는 실행되지않는다.
			System.out.println( i + " ");
		}
		
		
	
	}	
}













