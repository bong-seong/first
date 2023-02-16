package Day11.Ex3;

public class sportCar extends Car {
	@Override
	public void speedUp() {
		super.speedUp(); // 부모 메소드 호출 
	}
	
	/*
	@Override
	public void stop() { // 오류 : stop 메소드가 final 이라서 재정의 불가능
		super.stop();
	}
	*/

}
