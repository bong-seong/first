package 과제.과제1_연산자문제;

import java.util.Scanner;

public class 과제1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		/*
		System.out.println("문제1 : 강아지 console 출력");
		System.out.println("|\\_/|\n|q p|   /}\n( 0 )\"\"\"\\\n|\"^\"`    |\n||_/=\\\\__|");
		System.out.println("");
		
		System.out.println("문제2 : 입력받은 3개 데이터를 이용한 표 만들기");
		
		System.out.print("작성자 : "); 	String writer = sc.next();
		sc.nextLine();
		System.out.print("내용 : ");		String content = sc.nextLine();
		System.out.print("날짜 : ");		String date = sc.next();
		System.out.println("---------------- 방문록 ----------------");
		System.out.printf("|%3s | %6s | %15s | %6s \n" ,"번호","작성자","내용","날짜");
		System.out.printf("|%4d | %6s | %15s | %6s \n" ,1,writer,content,date);
		System.out.println("--------------------------------------\n");
		System.out.println("");
		*/
		
		/*
		System.out.println("문제3 : 급여 계산");
		int basePay = sc.nextInt();
		int extraPay = sc.nextInt();
		int realPay = (int)(basePay + extraPay - (basePay*0.1));
		System.out.println("실수령액 : " + realPay );
		System.out.println("");
		*/
		
		/*
		System.out.println("문제4 : 지폐 세기");
		System.out.println("금액 : "); int money = sc.nextInt();
		System.out.println(" - 십만원 : " + (money/100000)+ "장" );
		money -= (money/100000) * 100000;
		System.out.println(" - 만원 : " + (money/10000)+ "장" );
		money -= (money/10000) * 10000;
		System.out.println(" - 천원 : " + (money/1000)+ "장" );
		money -= (money/1000) * 1000 ; 
		System.out.println(" - 백원 : " + (money/100) + "장" );
		
		System.out.println("문제5 : 하나의 정수를 입력받아 7의 배수인지 출력");
		System.out.print("정수를 입력하세요 : "); int i1 = sc.nextInt();
		String result1 = i1%7 == 0 ? "O" : "X" ;
		System.out.println( "결과 : " + result1 );
		
		System.out.println("문제6 : 하나의 정수를 입력받아 홀수 인지 출력");
		System.out.print("정수를 입력하세요 : "); int i2 = sc.nextInt();
		String result2 = i2%2 == 1 ? "O" : "X" ;
		System.out.println( "결과 : " + result2 );
		*/
		
		/*
		System.out.println("문제7 : 하나의 정수를 입력받아 7의 배수이면서 짝수인지 출력");
		System.out.println("수를 입력하세요 : "); int i3 = sc.nextInt();
		String result2 = (i3%7 == 0) && (i3%2 == 0) ? "O" : "X" ; 
		System.out.println( result2 );
		
		System.out.println("문제8 : 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출럭") ;
		System.out.println("수를 입력하세요 : "); int i4 = sc.nextInt();
		String result3 = (i4%7 == 0) || (i4%2 == 1) ? "O" : "X" ;
		System.out.println( result3 );
		*/
		
		/*
		System.out.println("문제9 : 두개의 정수를 입력받아 더 큰 수 출력");
		System.out.println("첫번째 수를 입력하세요 : "); int i5 = sc.nextInt();
		System.out.println("두번째 수를 입력하세요 : "); int i6 = sc.nextInt();
		int result4 = (i5>i6) ? i5 : i6;
		System.out.println( "두 수중 더 큰수는 " + result4 + " 입니다.");
		*/
		
		/*
		System.out.println("문제10 : 반지름을 입력받아 원 넓이 출력하기");
		System.out.println("반지름을 입력하세요 : "); int i7 = sc.nextInt();
		System.out.println("원 넓이는 " + (i7*i7*3.14) + " 입니다.");
		*/
		
		/*
		System.out.println("문제11 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기");
		System.out.println("첫번째 실수를 입력하세요 : "); float f1 = sc.nextFloat();
		System.out.println("두번째 실수를 입력하세요 : "); float f2 = sc.nextFloat();
		System.out.println("첫번째 실수는 두번째 실수값의 " + (f1/f2*100) + " 퍼센트 입니다.");
		*/
		
		/*
		System.out.println("문제12 : 사다리꼴 넓이 구하기 [윗변과 밑변 높이를 입력받아 출력하기]");
		System.out.println("윗변을 입력하세요 : "); int i8 = sc.nextInt();
		System.out.println("밑변을 입력하세요 : "); int i9 = sc.nextInt();
		System.out.println("높이를 입력하세요 : "); int i10 = sc.nextInt();
		System.out.println("사다리꼴의 넓이는 " + ((i8*i9)*i10/2) + " 입니다.");
		*/
		
		/*
		System.out.println("문제13 : 키(정수)를 입력받아 표준체중 출력하기");
		System.out.println("키를 입력하세요 : "); int i11 = sc.nextInt();
		System.out.println( i11 + "cm 의 표준 체중은 " + (i11-100)*0.9 + "kg 입니다.");
		*/
	
		System.out.println("문제14 : 키와 몸무게를 입력받아 BMI 출력하기");
		System.out.println("키를 입력하세요 : "); int i12 = sc.nextInt();
		System.out.println("몸무게를 입력하세요 : "); int i13 = sc.nextInt();
		System.out.println("BMI : " + i13/((i12/100)*(i12/100)) );
				
		
	}
}







