package Day11.Ex7_타입변환;

import java.util.ArrayList;

import Day11.Ex6.HankookTire;
import Day11.Ex6.KumhoTire;
import Day11.Ex6.Tire;

public class 실행2 {
	public static void main(String[] args) {
		
		// 1. 참조타입의 자동타입 변환
		Tire tire = new Tire();
		KumhoTire kumhoTire = new KumhoTire();
		HankookTire hankookTire = new HankookTire();
		
		// 1. 참조타입의 자동타입 변환
		Tire temp = tire;
			Tire temp2 = kumhoTire;
				Tire temp3 = hankookTire;
					Object temp4 = temp3;
					
		// 2. 강제타입 변한
		Tire tire2 = (Tire)temp4;
			KumhoTire kumhoTire2 = (KumhoTire)tire2;
				HankookTire hankookTire2 = (HankookTire)tire2;
				
		// 3. 매개변수 , 리턴타입
		Tire tire3 = 함수1( kumhoTire2 );
		KumhoTire result = (KumhoTire)함수2( (KumhoTire)temp2 );
		
		// 4. 배열 , ArrayList
		ArrayList<KumhoTire> kumhoList = new ArrayList<>();
		kumhoList.add(kumhoTire);	// o
		// kumhoList.add(hankookTire); // x
		// kumhoList.add( tire );	// x 
		// ----- > 
		ArrayList<Tire> tireList = new ArrayList<>();
		tireList.add(kumhoTire);
		tireList.add(hankookTire); // o 
		tireList.add( tire );	// o 
		
		
				
	} // main e
	
	public static KumhoTire 함수1( Tire tire ) { return new KumhoTire(); }
	public static Tire 함수2( KumhoTire kumhoTire ) { return new Tire(); }
	
}
