package 과제.과제1_연산자문제;

import java.util.Scanner;

public class 과제1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
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
		
		
		
		System.out.println("문제3 : 급여 계산");
		int basePay = sc.nextInt();
		int extraPay = sc.nextInt();
		int realPay = (int)(basePay + extraPay - (basePay*0.1));
		System.out.println("실수령액 : " + realPay );
		System.out.println("");
		
		
		
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
		
		
		
		System.out.println("문제7 : 하나의 정수를 입력받아 7의 배수이면서 짝수인지 출력");
		System.out.println("수를 입력하세요 : "); int i3 = sc.nextInt();
		String result3 = (i3%7 == 0) && (i3%2 == 0) ? "O" : "X" ; 
		System.out.println( result3 );
		
		System.out.println("문제8 : 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출럭") ;
		System.out.println("수를 입력하세요 : "); int i4 = sc.nextInt();
		String result4 = (i4%7 == 0) || (i4%2 == 1) ? "O" : "X" ;
		System.out.println( result4 );
		
		
		
		System.out.println("문제9 : 두개의 정수를 입력받아 더 큰 수 출력");
		System.out.println("첫번째 수를 입력하세요 : "); int i5 = sc.nextInt();
		System.out.println("두번째 수를 입력하세요 : "); int i6 = sc.nextInt();
		int result5 = (i5>i6) ? i5 : i6;
		System.out.println( "두 수중 더 큰수는 " + result5 + " 입니다.");
		
		
		
		System.out.println("문제10 : 반지름을 입력받아 원 넓이 출력하기");
		System.out.println("반지름을 입력하세요 : "); int i7 = sc.nextInt();
		System.out.println("원 넓이는 " + (i7*i7*3.14) + " 입니다.");
		
		
		
		System.out.println("문제11 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기");
		System.out.println("첫번째 실수를 입력하세요 : "); float f1 = sc.nextFloat();
		System.out.println("두번째 실수를 입력하세요 : "); float f2 = sc.nextFloat();
		System.out.println("첫번째 실수는 두번째 실수값의 " + (f1/f2*100) + " 퍼센트 입니다.");
		
		
		
		System.out.println("문제12 : 사다리꼴 넓이 구하기 [윗변과 밑변 높이를 입력받아 출력하기]");
		System.out.println("윗변을 입력하세요 : "); int i8 = sc.nextInt();
		System.out.println("밑변을 입력하세요 : "); int i9 = sc.nextInt();
		System.out.println("높이를 입력하세요 : "); int i10 = sc.nextInt();
		System.out.println("사다리꼴의 넓이는 " + ((i8*i9)*i10/2) + " 입니다.");
		
		
		
		System.out.println("문제13 : 키(정수)를 입력받아 표준체중 출력하기");
		System.out.println("키를 입력하세요 : "); int i11 = sc.nextInt();
		System.out.println( i11 + "cm 의 표준 체중은 " + (i11-100)*0.9 + "kg 입니다.");
		
	
		
		System.out.println("문제14 : 키와 몸무게를 입력받아 BMI 출력하기");
		System.out.println("키를 입력하세요 : "); int i12 = sc.nextInt();
		System.out.println("몸무게를 입력하세요 : "); int i13 = sc.nextInt();
		System.out.println("BMI : " + i13/((i12/100)*(i12/100)) );
		
		
		
		System.out.println("문제15 : inch 를 입력받아 cm 로 변환하기");
		System.out.print("인치를 입력하세요 : ");
		int i14 = sc.nextInt();
		System.out.println( i14 + "inch는 " + (i14*2.54) + "cm 입니다.");
		
		
		
		System.out.println("문제16 : 중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오");
		System.out.print("중간고사 점수 >>> ");
		int 중간고사 = sc.nextInt();
		System.out.print("기말고사 점수 >>> ");
		int 기말고사 = sc.nextInt();
		System.out.print("수행평가 점수 >>> ");
		int 수행평가 = sc.nextInt();
		double 합계 = (중간고사*0.3) + (기말고사*0.3) + (수행평가*0.4);
		System.out.printf( "총점 : %.2f" , 합계 );
		
		
		
		System.out.println("문제17 : 연산 순서 나열하고 printf() 에 출력되는 x와 y 값을 예측하시오");
		int x = 10;
		int y = x-- + 5 + --x;
		System.out.printf(" x의 값 : %d , y의값 : %d" , x , y );
		// 처음 후위 증감연산자와 +5 사이 덧셈연산이 먼저 진행 >> 10+5 >> 이후 x=9
		// --x 경우 선위 증감연산으로 + 실행전 실행 >> x=8 >> 5+8 >> 최종 10 + 5 + 8 >> x = 8 y =23;
		
		
		
		System.out.println("문제18 : 나이를 입력받아 나이가 10이상이면 학생, 20세이상이면 성인, 40세이상이면 중년으로 출력하기");
		System.out.printf("나이를 입력해주세요 : ");
		int age  = sc.nextInt();
		String 결과 = (age >= 10 && age <= 19) ? "학생" : (age >= 20 && age <= 39)? "성인" : "중년";
		System.out.println( "당신은 " + 결과 + "입니다.");
		
		
		
		System.out.println("문제19 : 국어, 영어, 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력, 평균(소수점 2자리 까지) 출력");
		System.out.println("국어 : ");
		int 국어 = sc.nextInt();
		System.out.println("영어 : ");
		int 영어 = sc.nextInt();
		System.out.println("수학 : ");
		int 수학 = sc.nextInt();
		int 총점 = 국어 + 영어 + 수학;
		double 평균 = (국어 + 영어 + 수학) / 3;
		System.out.printf("총점 : %d , 평균 : %.2f" , 총점 , 평균);
		
		
		
		System.out.println("문제20 : 아이디[문자열]와 비밀번호[문자열] 를 입력받아 아이디가 admin 이고 비밀번호가 1234 와 일치하면 로그인성공 아니면 로그인실패 출력");
		System.out.printf("아이디를 입력하세요 : ");
		String id = sc.next();
		System.out.printf("패스워드를 입력하세요 : ");
		String pwd = sc.next();
		String check = id.equals("admin") && pwd.equals("1234") ? "로그인성공" : "로그인실패" ;
		System.out.println( check );
		
		
		
		System.out.println("문제21 : 세 정수를 입력받아 가장 큰 수 출력");
		System.out.printf("첫번째 수를 입력하세요 : ");
		int soo1 = sc.nextInt();
		System.out.printf("두번째 수를 입력하세요 : ");
		int soo2 = sc.nextInt();
		System.out.printf("세번째 수를 입력하세요 : ");
		int soo3 = sc.nextInt();
		int 비교 = (soo1 > soo2) && (soo1 > soo3) ? soo1 : (soo2 > soo1 && soo2 > soo3) ? soo2 : soo3 ;
		System.out.println( "가장 큰 수는 " + 비교 + " 입니다.");
		
		
		
		System.out.println("가위 바위 보 게임");
		System.out.printf("player1 입력 >>> ");
		int p1 = sc.nextInt();
		System.out.printf("player2 입력 >>> ");
		int p2 = sc.nextInt();
		
		String result7 = (p1 == 0 && p2 == 2) || (p1 == 1 && p2 == 0) || (p1 == 2 && p2 == 1) ?  "player1 승리" 
			: (p1 == p2 ) ? "무승부" : "Player2 승리" ;  
		
		System.out.println( result7 );
		
		
	}
}







