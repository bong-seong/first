package 과제.자율미니프로젝트.controller;

import 과제.자율미니프로젝트.model.Member;
import 과제.자율미니프로젝트.model.Professer;


public class Acontroller extends Mcontroller {
	
	
	// admin 계정 미리 한개 생성 1.로그인 2. 아이디찾기 3. 비밀번호찾기 / (hide) 4. 관리자로그인 /
	// ch => 4 일때 관리자로그인 
	
	int mno1 = 100;
	int mno2 = 200;
	
	// 1. 학생 / 교수 등록 ( ch 로 학생, 교수 선택 ) 
	public boolean add_smember( String id , String comfirmpw, String pw, String name, String phone ) {
			if( pw.equals(comfirmpw)) { // 패스워드 , 패스워드 확인 
				Member student = new Member(mno1, id, pw, name, phone); //학생 객체 생성
				MemberDB.add(student); // DB 저장
				mno1++;
				return true;
			}
			return false;
		}
	
		
	public boolean add_pmember( String id , String comfirmpw, String pw, String name, String phone ) {
			if( pw.equals(comfirmpw)) {
				Member professer = new Member(mno2, id, pw, name, phone); // 교수 객체 생성
				MemberDB.add(professer);
				mno2++;
				return true;
			}
		
		return false;
	}
	
	// 2. 강의등록
	public boolean subject_reg( String subject, String id) {
		
		int mno = mno(id);
		
		int suno = 0;
		if(Pcontroller.subjctDB.size()==0) {
			suno=0;
		}else {
			suno = Pcontroller.subjctDB.get(Pcontroller.subjctDB.size()-1).suno+1;
		}
		
		Professer subject1 = new Professer(suno, subject, mno);
		Pcontroller.subjctDB.add(subject1);
		
		return true;
	}
	
	
	
	
}
