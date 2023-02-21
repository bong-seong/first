package Day15.Ex1_p498;

public class Member {

	// 1. 필드
	public String id;
	
	// 2. 생성자
	public Member( String id ) {
		this.id = id;
	}
	
	// 3. 메소드
	// 주소번지 비교가 아닌 내부 값 비교로 재정의
	@Override
	public boolean equals(Object obj) {
		
		// if( obj instanceof Member target) { // javaSE 16( jdk 16 )이상일때 사용 가능한 방식
			// 부모객체 instanceof 자식클래스 변환객체명
		if( obj instanceof Member) {
			
			Member target = (Member)obj;
			if( id.equals(target.id) ) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
}
