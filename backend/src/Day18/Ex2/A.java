package Day18.Ex2;

public class A extends Thread {
	@Override
	public void run() {
		
		
		while( true ) {
			System.out.println( "--A 메소드 스레드 : " + Thread.currentThread() );
			
			try {
				Thread.sleep(1000); // 현 스레드 1초간 일시정지
			}catch (Exception e) {
				System.out.println( e );
			}
		}
		
		
	}
}
