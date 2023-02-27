package Day18.Ex4;

public class User2Tread extends Thread {
	
	private Calculator calculator; // 필드
	
	public User2Tread() { // 생성자
		setName("User2Thread");
	}
	
	
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(50);
	}
	
}
