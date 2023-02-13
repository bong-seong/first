package Day09.Ex1;

public class 실행 {
	public static void main(String[] args) {
		
		// 1. 객체 만들기
		Member member = new Member();
			// 2. 멤버의 필드 호출 가능
		System.out.println( member.name );
			// 3. 멤버안에 있는 (로컬)변수 호출 불가능 
		// System.out.println( member.inputName ); 
		
	}
}
