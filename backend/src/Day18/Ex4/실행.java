package Day18.Ex4;

public class 실행 {
	public static void main(String[] args) {
		
		// 1. 계산기 객체 생성
		Calculator calculator = new Calculator();
		
		// 2. 유저1 객체 생성
		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(calculator);
		user1Thread.start();
		
		// 3. 유저2 객체 생성
		User2Tread user2Tread = new User2Tread();
		user2Tread.setCalculator(calculator);
		user2Tread.start();
		
		
	}
}
