package Day18.Ex3;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Ex1_p604 { // class start
	
	public static void main(String[] args) { // main start
		
		
		
		// 1. 
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		
//		for( int i=0; i<10; i++ ) {
//			toolkit.beep(); // 비프음 내기
//			
//			try {
//				Thread.sleep(100); // 3초간 해당 스레드를 일시정지 [ 3초간 cpu(명령어처리) 점유 불가 ]
//			}catch( Exception e ) {
//				System.out.println( e );
//			}
//		} // for end
		
		
		
		// 2. 콘솔에 시계 만들기
		while( true ) {
		
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat( "hh:mm:ss" );
			System.out.println( sdf.format(date) );
			try {
				Thread.sleep(1000);
			}catch( Exception e ) {}
			
		}
	
		// 3. 
		/*SumThread sumThread = new SumThread();
		sumThread.start();
		System.out.println( sumThread.getSum() );*/
		
		// 위의 경우는 계산 시작하자마자 바로 출력 -> 멀티쓰레드라 그럼
		
		
		/*
		 * SumThread sumThread = new SumThread(); sumThread.start(); try {
		 * sumThread.join(); // 계산시작 후 join 에 의해 합쳐짐 ( run() 메소드의 계산이 다 될때까지 기다리다가 완료 후
		 * 다시 흐름대로 ) }catch (Exception e) {
		 * 
		 * } System.out.println( sumThread.getSum() ); // 계산이 완료 된 후 의 sum 값을 가져오니 계산이
		 * 되어져있음
		 */		
		
		
		// 4.
		/*
		WorkThread workThreadA = new WorkThread("workThreadA"); // 스레드A 객체 생성
		WorkThread workThreadB = new WorkThread("workThreadB"); // 스레드B 객체 생성
		workThreadA.start(); // 스레드 A 실행
		workThreadB.start(); // 스레드 B 실행
		
		try {
			Thread.sleep(5000); // 5초간 일시정지
		}catch( Exception e) {} 
		workThreadA.work = false ; // 스레드A 필드 변경 스레드 양보상태
		
		try {
			Thread.sleep(5000);
		}catch( Exception e) {}
		workThreadA.work = true; // 스레드A 필드 변경 스레드 대기상태
		*/
		
		
	} // main end 
} // class end 










