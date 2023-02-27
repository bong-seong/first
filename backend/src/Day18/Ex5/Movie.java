package Day18.Ex5;

public class Movie extends Thread {
	
	public boolean stop = false;
	
	@Override
	public void run() {
		while( stop ) { // stop true 이면 실행
			System.out.println("-- 영화재생중 -- ");
			try {
				Thread.sleep(1000);
			}catch (Exception e) {}
		}
	}
}
