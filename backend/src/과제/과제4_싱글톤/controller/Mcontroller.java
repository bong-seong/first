package 과제.과제4_싱글톤.controller;

import java.util.ArrayList;


import 과제.과제4_싱글톤.model.Member;

// * 1개만 있어도 되는지 생각

public class Mcontroller {
	
	// * 싱글톤 : 다른곳에서 해당 객체를 공유 메모리
		// 1. 본인 클래스로 본인 객체 만들기
	private static Mcontroller mc = new Mcontroller();
		// 2. 외부에서 생성자를 사용할수 없도록 생성자 private 
	private Mcontroller() {}
		// 3. 객체는 외부로부터 차단하고 getInstance 함수를 통해 객체를 내보낸다. [ 유효성검사 위해 ]
	public static Mcontroller getInstance() {
		return mc;
	}
	
	// DB 대신 ArrayList
	private ArrayList<Member> memberDB = new ArrayList<>();
	// 로그인 한 회원의 객체를 저장 [ *동시접속 문제점 발생!! ]
		// 사용목적 : 페이지가 바뀌더라도 정보 저장 [ * 메소드가 종료되더라도 정보는 저장 ]
	private Member loginSession = null;
	
	public Member getLoginSession() {
		return loginSession;
	}
	// 1. 회원가입 처리
	public int signup( String id , String pw , String confirmpw , String name , String phone ) {
		
		// 1. 유효성검사 [ 생략 ]
		if( !pw.equals(confirmpw) ) { return 1; }
		// 2. DB 저장 
			// 1. 객체화 [ 입력받은 데이터 4개와 , 회원마다 글을 저장할 리스트 메모리 초기화 ]
		Member m = new Member(id, pw, name, phone, new ArrayList<>() );
				// id , pw , name , phone : 스택영역에 저장된 힙주소 전달
				// new ArrayList<>() : 힙영역에 생성된 힙주소 전달
			// 2. 리스트에 저장
		memberDB.add(m);
		return 0;
	}
	
	// 2. 로그인 처리
	public int login( String id, String pw ) {
		
		for( int i=0; i<memberDB.size(); i++ ) {
			if( memberDB.get(i).getId().equals( id ) ) { // i번째 인덱스의 아이디와 입력받은 아이디가 같으면
				if( memberDB.get(i).getPw().equals( pw )) {
					// i번째 인덱스의 비밀번호와 입력받은 비밀번호와 같으면 로그인 성공 [ !로그인 성공했다 흔적/식별 ]
					loginSession = memberDB.get(i); // 로그인 성공한 회원 객체를 필드에 저장 
					return i;
				}else {
					return -1;
				}
			}
		}
		
		return -2;
	}
	
	// 3. 아이디찾기 처리
	public String findID( String name, String phone ) {
		for( Member m : memberDB ) { // memberDB에는 여러개의 member 객체가 들어있고 하나씩 member 객체를 꺼내기 반복
			if( m.getName().equals(name) && m.getPhone().equals(phone) ) {
				return m.getId(); // 위 조건이 일치할 경우 찾은 아이디 반환 
			}
		}
		return null;
	}
	
	// 4. 비밀번호찾기 처리
	public String findPw( String id , String phone ) {
		for( Member m : memberDB ) { // * 자료형 
			if( m.getId().equals(id) && m.getPhone().equals(phone) ) {
				return m.getPw(); // 위 조건이 일치할 경우 찾은 비밀번호 반환
			}
		}
		return null;
	}
	// 5. 로그아웃
	public boolean logOut() {
		loginSession = null; // 필드에 저장된 로그인 성공 회원 객체를 지우기 [ null 대입하면 GC가 메모리 자동제거 ]
		return true;
	}

	
}
