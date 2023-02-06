package Day04;

import java.util.Random;
import java.util.Scanner; // 해당 클래스를 사용하기 위한 패키지로 부터 클래스 가져오기

public class Ex1_가위바위보 {
	
	public static void main(String[] args) {
		
		
		// .!!! 3. 입력객체 [ 클래스 위에 import java.util.Scanner; 필수 ]
		Scanner scanner = new Scanner(System.in);
		
		// 8. 변수의 사용범위 : 지역변수 특징 { } 밖으로 못나감
		int pwin = 0;
		int cwin = 0;
		int play = 0;
		// * : while 
		
		while(true) { // 1. 무한루프 [ 종료조건 : ]
			// 2. 출력
			System.out.print(" 가위(0) 바위(1) 보(2) 종료(3) : ");
			// 3. 입력 : Scanner 클래서 -> scanner 객체 필요 !!
			// 4. 저장[변수]
			byte player = scanner.nextByte(); // 입력받은 데이터를 byte 형으로 가져오기
			System.out.println( " >> player 낸수 : " + player );
			// 5. 제어문[ 흐름 제어 - 경우의수 ( 정상입력(0~2), 종료(3) ) ] 
			if( player == 3 ) {
				System.out.println(" --- 종료 --- "); 
				if( pwin > cwin ) { 
					System.out.println("최종 스코어 Player : " + pwin + "\tBot : " + cwin );
					System.out.println(" 최종 Player 승리 !!! ");
				}
				else if( pwin < cwin ) {
					System.out.println("최종 스코어 Player : " + pwin + "Bot : " + cwin );
					System.out.println(" 최종 Bot 승리 !!! ");
				}
				else { System.out.println(" 무승부 ");}
				break; // 반복문 탈출
			}
			
			// 6. 난수 생성 [ 1. Math 클래스 2. Random 클래스 ]
			Random random = new Random();
			int bot = random.nextInt(2); // 0~2 사이의 int 형 난수 생성
			System.out.println(" >> bot 낸 수 : " + bot );
			
			// 7. 승리 판단 
				// [ player 이기는 수 	p:0 c:2 / p:1 c:0 / p:2 c:1 ]
				// [ bot 이기는 수 	p:0 c:1 / p:1 c:2 / p:2 c:0 ]
				// [ 비기는 수 		p:0 c:0 / p:1 c:1 / p:2 c:2 ] 
			if( (player == 0 && bot == 2) || (player == 1 && bot == 0) || (player == 2 && bot == 1) ) {
				System.out.println(" Player 승리!! ");
				pwin++;
			}else if( player == bot ) {
				System.out.println( " Draw " );
			}else {
				System.out.println(" Bot 승리!! ");
				cwin++;
			}
			// * 플레이수 증가
			play++ ;
			
			
		} // while END [ break ]
		
		
	}

}


/*
 	* 예제에서 아래의 주요 내용 정리하기 
 	
 	1. 승리자 판단 코드 보지않고 가능해야함
 	2. 지역변수의 특징 파악
 	3. Scanner 클래스, Random 클래스 예제 정리 
 */











