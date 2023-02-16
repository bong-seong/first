package 과제.자율미니프로젝트.controller;

import java.util.ArrayList;

import 과제.자율미니프로젝트.model.Member;


public class Mcontroller {
	public static ArrayList<Member> MemberDB = new ArrayList<>();
	public static int logSession = -1;
	
	// mno 찾기
	public int mno(String id) {
		int mno = -1;
		for(Member m : Mcontroller.MemberDB) {
			if(m.id.equals(id)) {
				mno = m.mno;
			}
		}
		return mno;
	}
	// 이름찾기
	public String findName(int mno) {
		String name = "";
		for(Member m : Mcontroller.MemberDB) {
			if(mno==m.mno) {
				name = m.name;
			}
		}
		return name;
	}
	
	// id찾기
		public String findId(int mno) {
			String id = "";
			for(Member m : Mcontroller.MemberDB) {
				if(mno==m.mno) {
					id = m.id;
				}
			}
			return id;
		}
	
	// 로그인
	public int login(String id, String pw) {
		for(Member m : MemberDB) {
			if(m.id.equals(id)) {
				if(m.pw.equals(pw)) {
					logSession = m.mno;
					int mno = m.mno;
					return mno;
				}
			}
		}
		return 0;
	}
	
	// 아이디 찾기
	public String findId(String name,String phone) {
		for(Member m : MemberDB) {
			if(m.name.equals(name)) {
				if(m.phone.equals(phone)) {
					return m.id;
				}
			}
		}
		return null;
	}
	
	// 비밀번호 찾기
	public String findPw(String id,String phone) {
		for(Member m : MemberDB) {
			if(m.id.equals(id)) {
				if(m.phone.equals(phone)) {
					return m.pw;
				}
			}
		}
		return null;
	}
	
	// 로그아웃
	public boolean logout() {
		logSession = 0; //필드에 저장된 로그인 성공한 회원 객체 지우기 [null 대입하면 GC가 메모리 자동 제거]
		return true;
	}
	
	
}
