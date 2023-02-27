package Day18.Ex1_p596;

import java.awt.Toolkit;

import com.mysql.cj.protocol.a.TextResultsetReader;

public class 실행 {
	
	// p.596
		// main메소드() : 메인 thread 싱글스레드
	public static void main(String[] args) {
		
		// ---------------------------------------------- 1. 싱글스레드 ------------------------------------------
		// * 소리 코드가 실행되고 출력 코드 실행
		// 1. 소리 코드
		System.out.println("----- 1. 싱글스레드 시작 -----");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for( int i=0; i<5; i++ ) {
			toolkit.beep();
			try {
				Thread.sleep(500); // 스레드 0.5초 대기 상태
			}
			catch (Exception e) {
			
			}
		}
		
		// 2. 출력 코드
		for( int i=0; i<5; i++ ) {
			System.out.println("띵");
			try { Thread.sleep(500);}
			catch (Exception e) { }
		}
		// ----------------------------------------------------------------------------------------------------
		
		// ---------------------------------------------- 2. 멀티스레드 ------------------------------------------
		// Thread thread = new Thread( 구현 인터페이스 );
			// 익명 [ 이름이없는 ] 구현 객체
			// 1. 스레드 객체 생성
		System.out.println("----- 2. 멀티스레드 시작 -----");
		Thread thread = new Thread( new Runnable() {
			// 2. run 메소드를 구현
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for( int i=0; i<5; i++ ) {
					toolkit.beep();
					try { Thread.sleep(500);}
					catch (Exception e) {}
				} // for end
			} // run end
		}); // 생성자 end
		thread.start(); // 3. run 메소드 실행
		
		// 2. 출력 코드
		for( int i=0; i<5; i++ ){
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch ( Exception e) {}
		}
		// ----------------------------------------------------------------------------------------------------
		
		
		
		// ---------------------------------------------- 3. 멀티스레드 구현 2 ------------------------------------------
		System.out.println("----- 3. 멀티스레드 시작 -----");
		Thread thread2 = new Sound();
		thread2.start();
		
		for( int i=0; i<5; i++ ){
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch ( Exception e) {}
		}
		// ----------------------------------------------------------------------------------------------------
		
		
		
		// ---------------------------------------------- 4. 멀티스레드 구현 3 ------------------------------------------
		System.out.println("----- 4. 멀티스레드 시작 -----");
		Runnable runnable = new Sound2();
		Thread thread3 = new Thread( runnable );
		thread3.start();
		
		// 2. 출력 코드
		for( int i=0; i<5; i++ ){
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch ( Exception e) {}
		}
		// ----------------------------------------------------------------------------------------------------
		
		
		
		
	} // main end
} // class end
