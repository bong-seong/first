package 과제.중고.controller;

import java.util.ArrayList;

import 과제.중고.model.Member;

public class Mcontroller {
	
	private static Mcontroller mc = new Mcontroller();
	private Mcontroller() {}
	public static Mcontroller getInstance() { return mc; }
	
	private ArrayList<Member> memberDb = new ArrayList<>();
	
	public ArrayList<Member> getMemberDB() { return memberDb; } 
	
	int m_seq = 0;
	// 1. 회원가입 처리
	public int signup( String id , String pw , String confirmpw , String name , String phone ) {
		// 유효성 체크 ( 비밀번호와 비밀번호 확인이 같으면 )
		if( !pw.equals(confirmpw)) {
			return -1;
		}
		Member member = new Member(m_seq, id, confirmpw, name, phone);
		memberDb.add(member);
		m_seq++;
		
		return 0;
	}
	
	// 2. 로그인 처리 
	public int login( String id, String pw ) {
		for( int i=0; i<memberDb.size(); i++ ) {
			if( memberDb.get(i).getId().equals(id) && memberDb.get(i).getPw().equals(pw) ) {
				return memberDb.get(i).getSeq();
			}
		}
		
		return -1;
	}
	

	
	
}
