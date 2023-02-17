package Day13.Ex4_p365;

public class 실행 {
	public static void main(String[] args) {
		
		/*
		 	
		 	A 엄마 B 아빠
		 		상속
		 		C나
		
		 */
		
		 
		
		// 1. 구현객체 만들기
		InterfaceCImpl impl = new InterfaceCImpl();
		
		// 2. 인터페이스 변수에 구현객체 대입 
		InterfaceA ia = impl;
		ia.methodA(); // 본인 추상메소드 호출 가능
		// ia.methodB(); // x
		// ia.methodC(); // x
		
		// 2. 
		InterfaceB ib = impl;
		// ib.methodA(); // x
		ib.methodB(); // 본인 추상메소드 호출 가능 
		// ib.methodC(); // x
		
		// 3.
		InterfaceC ic = impl;
		ic.methodA(); // 부모 가능
		ic.methodB(); // 부모 가능
		ic.methodC(); // 본인 가능 
		
	}
	
}
