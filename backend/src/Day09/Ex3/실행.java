package Day09.Ex3;

public class 실행 {
	public static void main(String[] args) {
		
		// 1. 객체
		
			// 1. 객체의 필드를 초기화 하는 방법
				// 1. 필드 [ 직접 ] 
		Car car = new Car();
		car.gas = 5;
		
				// 2. 생성자 [ 간접 ] : 객체의 필수 데이터 
		Car yourCar = new Car(5);
		
				// 3. 메소드 [ 간접 ] : 객체 생성후 데이터 
		Car myCar = new Car();
		myCar.setGas( 5 );
		
		if ( myCar.isLeftGas() ) {
			System.out.println("출발합니다.");
			myCar.run();
		}
		System.out.println("gas를 주입하세요");
	}
	
	
}
