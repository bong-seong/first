package Day11.Ex1;

public class Phone {
	
	// 클래스 멤버
		// 1. 인스턴스멤버 : 객체를 이용한 멤버 사용
		// 클래스 객체명 = new 생성자() ---> 객체명.멤버
	
		// 2. 정적멤버[ static ] : 객체 없이 이용하는 멤버
		// 클래스명.멤버
	
	// 1. 멤버 종류
		// 1. 필드		: 객체의 데이터 저장하는곳
			// 접근제한자 (static/final) 타입 변수명;
	public String model;
	public String color;
		// 2. 생성자		: 객체 생성시 초기화 담당 [ 지역변수 ]
			// 접근제한자 클래스명( 매개변수1, 매개변수2) { }
			// * 생성자가 1개도 없을때 기본생성자 자동 추가
			// * 생성자가 1개 이상이면 기본생성자 직접 추가
	public Phone() {}
	public Phone( String model , String color ) {
		this.model = model;
		this.color = color;
		System.out.println("-- 부모클래스 생성자 실행");
	}
		// 3. 메소드		: 객체의 행위 [ vs 지역변수 ]
			// 접근제한자 반환타입 메소드명( 매개변수1, 매개변수2 ) { }
	
	public void bell() { // 모든곳에서 호출 가능한 함수[메소드] , 매개변수x 리턴x 
		System.out.println("벨이 울립니다.");
	}

	public void sendVoice( String messeage ) { // 모든곳에서 호출 가능, 매개변수1 , 리턴x
		System.out.println("자기 : " + messeage );
	}
	
	public void receiveVoice( String messeage ) {
		System.out.println("상대방 : " + messeage );
	}
	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
	// 2. 접근제한자
		// public : 	모든 곳에서 호출 가능
		// private : 	해당 클래스에서만 호출 가능
		// default : 	동일한 패키지 내에서만 호출 가능
		// protected : 	동일한 패키지 내에서만 호출 가능 [ * 자식 예외 ]
}
