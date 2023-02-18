package 과제.과제9.클래스.예제1_동물;

import java.util.Scanner;

public class Front {
	
	Scanner scanner = new Scanner(System.in);
	동물 animal = new 동물();
	
	public void index() {
		while( true ) {
			System.out.println("------------- 동물사전 -------------");
			System.out.print("확인하고싶은 동물을 입력하세요 >> ");
			String animalCheck = scanner.next();
			
			if( animalCheck.equals("강아지") ) {
				animal = new 강아지("흰색" , "4개");
				animal_info( animal );
			}
			else if( animalCheck.equals("원숭이") ){
				animal = new 원숭이( "갈색" , "2개" );
				animal_info( animal );
			}
			else if( animalCheck.equals("비둘기") ) {
				animal = new 비둘기( "회색" , "2개" );
				animal_info( animal );
			}
			else { System.err.println("현재 등록되지 않은 동물입니다."); }
		}
	}
	
	
	// 상세페이지
	public void animal_info( 동물 animal ) {
		
		System.out.println("------------- 상세정보 -------------");
		System.out.println("털색상 : " + animal.털색상 );
		System.out.println("다리갯수 : " + animal.다리갯수 );
		System.out.print("먹을때 : "); animal.먹는다();
		System.out.print("울음소리 : "); animal.운다();
		System.out.print("움직일때 : ");
		if( animal instanceof 강아지 ) {
			강아지 temp = (강아지)animal;
			temp.움직인다();
		}else if( animal instanceof 원숭이 ) {
			원숭이 temp = (원숭이)animal;
			temp.움직인다();
		}else if( animal instanceof 비둘기 ) {
			비둘기 temp = (비둘기)animal;
			temp.움직인다();
		}
		System.out.println();
		System.out.println("나가기 : 숫자 \"0\"");
		int ch = scanner.nextInt();
		if( ch == 0 ) { return; }	
	}
	
	
}
