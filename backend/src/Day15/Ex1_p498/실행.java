package Day15.Ex1_p498;

public class 실행 {

	public static void main(String[] args) {
		
		Member obj1 = new Member("blue");
		System.out.println( obj1 );
		
		Member obj2 = new Member("blue");
		System.out.println( obj2 );
		
		Member obj3 = new Member("red");
		System.out.println( obj3 );
		
		System.out.println( obj1.equals(obj2) );
		System.out.println( obj1.equals(obj3) );
		
	}
	
}

/*

	자바에는 다양한 API
	java.base 모듈 
		- java.lang
			-object 클래스
				- 자바 클래스의 최상위 클래스
				- 자바의 모든 클래스는 Object 자직이거나 자손 클래스
				
				- 메소드
					1. 객체명A.equals(객체명B)	: 두 객체의 주소비교


*/