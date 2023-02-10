package 과제.과제4.controller;
// * 처리/제어 담당

import java.util.ArrayList;

import 과제.과제4.model.Member;
import 과제.과제4.view.Front;

public class Mcontroller {
		// * DB 대신할 [ 데이터 저장소 (리스트) ] 
		ArrayList<Member> memberDb = new ArrayList<>();
		// 1. 회원가입 로직
		
		public int signup(String id , String pwd , String confirmpwd , String name , String phone ) {
			// 1. 유효성검사
			if( !pwd.equals(confirmpwd) ) { return 1; } // 회원가입 실패 1
			
			// 2. 객체 만들어서
			Member member = new Member(id, confirmpwd, name, phone);

			// 3. DB 처리 [ 리스트 ]
			memberDb.add(member);
			return 0; // 회원가입 성공 0 
		}
		// 2. 로그인 로직
		public int login( String id , String pwd ) {
			for( int i=0; i<memberDb.size(); i++ ) {
				if( memberDb.get(i).id.equals( id ) ) {
					if( memberDb.get(i).pwd.equals( pwd ) ){ 
						return i ; // 회원 번호[인덱스] 반환
					}else {
						return -1; // 비밀번호가 틀림
					}
				} // if end 
			} // for end 
			return -2; // 아이디가 없음
		}
	
		// 3. 아이디 찾기 로직
		public String findId( String name, String phone ) {
			for( int i=0; i<memberDb.size(); i++ ) {
				if( memberDb.get(i).name.equals( name ) ) {
					if( memberDb.get(i).phone.equals( phone ) ) {
						return memberDb.get(i).id ; // 아이디 찾음 -> 아이디 반환
					}else {
						return "Y"; // 아이디는 찾았으나 번호가 일치하지않음 -> Y 반환
					}
				}
			}
			return "N" ; // 아이디 찾지못함 -> N 반환
		}
	
		// 4. 비밀번호 찾기 로직
		public String findPassword( String id , String phone ) {
			for( int i=0; i<memberDb.size(); i++ ) {
				if( memberDb.get(i).id.equals( id ) ) {
					if( memberDb.get(i).phone.equals( phone ) ) {
						return memberDb.get(i).pwd ;
					}else {
						return "Y";
					}
				}
			}
			return "N";
		}
		
		// 5. 작성자 찾기
		public String findWriter( int i ) {
			return memberDb.get(i).name;
		}
		
		
		
}
