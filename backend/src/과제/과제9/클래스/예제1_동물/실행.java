package 과제.과제9.클래스.예제1_동물;

public class 실행 {
	
	public static void main(String[] args) {
		
		
		동물 강아지 = new 강아지("흰색", "4개");
		
		System.out.println("강아지의 털 색상은 " + 강아지.털색상 );
		System.out.println("강아지의 다리 갯수는 " + 강아지.다리갯수 );
		
		강아지.먹는다();
		강아지.운다();
		강아지 temp1 = (강아지)강아지;
		temp1.움직인다();
		System.out.println("-------------------------------------------");
		
		동물 원숭이 = new 원숭이("갈색", "2개");
		
		System.out.println("원숭이의 털 색상은 " + 원숭이.털색상 );
		System.out.println("원숭이의 다리 갯수는 " + 원숭이.다리갯수 );
		
		원숭이.먹는다();
		원숭이.운다();
		원숭이 temp2 = (원숭이)원숭이;
		temp2.움직인다();
		System.out.println("-------------------------------------------");
		
		동물 비둘기 = new 비둘기("회색", "2개");
		
		System.out.println("비둘기의 털 색상은 " + 비둘기.털색상 );
		System.out.println("비둘기의 다리 갯수는 " + 비둘기.다리갯수 );
		
		비둘기.먹는다();
		비둘기.운다();
		비둘기 temp3 = (비둘기)비둘기;
		temp3.움직인다();
		
		
		
	}
	
}
