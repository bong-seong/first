package Day01;

public class Ex3_자료형 { // class START
	
	public static void main(String[] args) { // main START
		
		// 1. java 진수를 표현하는 방법
		int var1 = 0b1011; 		System.out.println("2진수 : " + var1 );  	// 1011[2진수] ---> 11 [10진수]
		int var2 = 0206; 		System.out.println("8진수 : " + var2 );	// 206 [8진수] ---> 11 [10진수]
		int var3 = 365;			System.out.println("10진수 : " + var3 );	// 365[10진수] ---> 365 [10진수]	
		int var4 = 0xB3;  		System.out.println("16진수 : " + var4 ); 	// 3B[16진수] ---> 179 [10진수]
		
		// 2. [ p.43 ] byte 자료형 [ -128 ~ 127 0도 양수에 포함되므로 127 ]
		byte b1 = -128; 		System.out.println("byte 자료형 : " + b1 );
		byte b2 = 127; 			System.out.println("byte 자료형 : " + b2 );
		// byte b3 = 128; 		// 오류발생 : 범위를 벗어난 데이터
		
		// 3. short 자료형 [ +- 3만2천 정도 ]
		short s1 = 32000; 		System.out.println("short 자료형 : " + s1 );
		//short s2 = 33000; 	// 오류발생 : 범위를 벗어난 데이터 
		
		// 4. int 자료형 [ +- 21억 정도 ]
		int i1 = 2000000000;	System.out.println("int 자료형 : " + i1 );
		//int i2 = 3000000000;	// 오류발생 : 범위를 벗어난 데이터
		
		// 5. [ p.43 ] long 자료형 [ +- 21억 이상 ]
		long l1 = 10; 			System.out.println("long 자료형 : " + l1 );
		//long l2 = 10000000000;// 오류발생 100억
			// 정수 기본타입 : int 		변수에 저장되기전 자료형이 명시되지 않은 데이터
			// 데이터 뒤에 L 붙이기 : int -> long 
			// 10000000000 --> int	// 10000000000L --> long 
		long l2 = 10000000000L; System.out.println("long 자료형 : " + l2 );
		
		// 6. [p.44] char 자료형 [ 각 국의 문자 0 ~ 65535 ]
		// 문자 ' '  // 문자열 " "
		char c1 = 'A'; 		System.out.println("char 자료형 : " + c1 );
		char c2 = 65; 		System.out.println("char 자료형 : " + c2 );
		char c3 = '가'; 		System.out.println("char 자료형 : " + c3 );
		char c4 = 44032;	System.out.println("char 자료형 : " + c4 );
		
		// 7. String 클래스 [ 문자 여러개 ( 문자열 ) 저장 클래스 ]
		String str1 = "안녕하세요"; 	System.out.println("String 클래스 : " + str1 );
		
		// 8. [p.48] float[ 소수 8자리표현] /double[소수 17자리표현] 자료형
			// float 데이터 뒤에 f 
		float f1 = 0.123456789123456789f;	System.out.println("float 자료형 : " + f1 ); 
		double d1 = 0.123456789123456789;	System.out.println("double 자료형 : " + d1 );
		
		// 9. [p.48] boolean 논리 [ true , false ]
		boolean bool1 = true; System.out.println("boolean 자료형 : " + bool1 );
		// boolean bool2 = 1; // 오류발생 : true 혹은 false만 저장 가능 
		
		
		
		
		
	} // main END

} // class END

/*
	- 용량 단위 
		Bit : 0 , 1
		Byte : 01010101 8bit = 1byte : 용량 최소단위 
		Kbyte : 1024byte ==> 1KB
		Mbyte : 1024Kbte ==> 1MB
		Gbyte : 1024Mbyte ==> 1GB
		
	- 최상위 bit -> 부호 역할 
			[최상위bit] 0101011
			0: 양수 1:음수
	
	 - 진수 : 컴퓨터의 표현단위 
	 	2진수 	: 0 , 1					: 기계어 / 이진코드 / bit		: 0b
	 	8진수		: 0 ~ 7					:							: 0
	 	10진수 	: 0 ~ 9					: 사람
	 	16진수	: 0 ~ 9 a b c d e f		: 메모리주소체계 
	
*/

