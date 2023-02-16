package 과제.자율미니프로젝트.view;

import java.util.Scanner;

import 과제.자율미니프로젝트.controller.Acontroller;
import 과제.자율미니프로젝트.controller.Mcontroller;
import 과제.자율미니프로젝트.controller.Pcontroller;
import 과제.자율미니프로젝트.controller.Stcontroller;
import 과제.자율미니프로젝트.model.Professer;
import 과제.자율미니프로젝트.model.Student;

public class Front {
	Pcontroller pcontroller = new Pcontroller();
	Mcontroller mcontroller = new Mcontroller();
	Stcontroller stcontroller = new Stcontroller();
	Acontroller acontroller = new Acontroller();
	Scanner scanner = new Scanner(System.in);
	
	public void index() {
		while(true) { // 종료조건 X
			System.out.println("------------- 학사관리 ------------");
			System.out.println("1. 로그인 / 2. 아이디찾기 / 3. 비밀번호찾기");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) { login_page(); }
			else if( ch == 2 ) { findId(); }
			else if( ch == 3 ) { findPw(); }
			else if( ch == 4 ) { admin_login(); }
			
		}
	}
	
	// 로그인 화면
	public void login_page() {
		System.out.println("------------- 로그인 ------------");
		System.out.println("아이디 : "); 	String id = scanner.next();
		System.out.println("비밀번호 : "); String pwd = scanner.next();
		
		int result = mcontroller.login(id, pwd);
		System.out.println(result);
		if( (result/100) == 1 ) { printSubject(); }
		else if( (result/100) == 2 )  { professor_main(); }
		
	}
	
	
	// 아이디 찾기
	public void findId() {
		System.out.println("------------- 아이디찾기 ------------");
		System.out.println("이름 : ");		String name = scanner.next();
		System.out.println("전화번호 : ");		String phone = scanner.next();
		
		String result = mcontroller.findId( name , phone );
		if( result == null ) {
			System.out.println("아이디 찾기에 실패하였습니다.");
		} else {
			System.out.println("아이디는 " + result + " 입니다."); 
		}
	}
	
	// 비밀번호 찾기
	public void findPw() {
		System.out.println("------------- 비밀번호찾기 ------------");
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("전화번호 : ");		String phone = scanner.next();
		
		String result = mcontroller.findPw( id , phone );
		if( result == null ) {
			System.out.println("비밀번호 찾기에 실패하였습니다.");
		} else {
			System.out.println("비밀번호는 " + result + " 입니다."); 
		}
	}
	
	
	
	/*과목 리스트 출력*/
	public void printSubject() {
		while(true) {
			System.out.println("--------------------강의 목록-------------------");
			System.out.println("번호\t\t 과목 \t\t\t 교수명");
			
			for(int i = 0; i <pcontroller.subjctDB.size(); i++) {
				System.out.printf("%d\t\t%s\t\t\t%s\n",
						i, 
						pcontroller.subjctDB.get(i).subject,
						mcontroller.findName(pcontroller.subjctDB.get(i).mno));
			}
			
			System.out.println("----------------------------------------------");
			System.out.print("1. 수강 신청 2. 수강 리스트 3. 로그아웃 : ");
			int choice = scanner.nextInt();
			
			if(choice == 1) { //1. 수강 신청
				System.out.println("수강신청 과목 번호 : ");
				int index = scanner.nextInt();
				stcontroller.enrollSubject(Pcontroller.subjctDB.get(index).suno);
			}else if(choice == 2) {//2. 수강 리스트
				printEnrollSubject();
			}else if(choice == 3) {//3. 로그아웃
				return;
			}
		}
	}
	
	/*수강 신청 */
	
	
	/*학생이 수강신청한 목록을 보여주는 메소드*/
	public void printEnrollSubject() {
		System.out.println("--------------수강 신청 목록--------------");
		System.out.println("번호 \t\t 과목명 \t\t 교수명 ");
		for(int i = 0; i < Stcontroller.studentDB.size(); i++) {
			Student student = Stcontroller.studentDB.get(i);
			if(student.mno == Mcontroller.logSession) {
				System.out.printf("%d \t\t %s \t\t\t %s\n",
						i,
						pcontroller.subject(Stcontroller.studentDB.get(i).suno),
						mcontroller.findName(pcontroller.pNo(Stcontroller.studentDB.get(i).suno)));
				}
			}
	
		System.out.println("----------------------------------------");
		System.out.println("나가기 : 3 진행하기 : 0"); int ch = scanner.nextInt();if( ch == 3) {return;}
		System.out.print("점수 확인 할 과목명 : ");
		String checkSN = scanner.next();
		int result = stcontroller.checkScore(checkSN);
		
		if(result == -1) {//점수 찾지 못했을 경우
			System.err.println("[안내] 점수를 찾지 못했습니다.");
		}else {
			System.out.println(checkSN + "의 점수는 " + result + "입니다.");
		}
	}
	
	
	// 교수 메인
		public void professor_main() {
			while( true ) {
				System.out.println("------------- 교수 ------------");
				System.out.println("1. 출석체크 / 2. 점수입력 / 3. 로그아웃");
				int ch = scanner.nextInt();
				if( ch == 1 ) { professor_check(); }
				else if( ch == 2 ) { professor_scoring(); }
				else if ( ch == 3 ) { break; }
			}
		}
		
		// 출석체크 페이지
		public void professor_check() {
			System.out.println("------------- 출석체크 ------------");
			System.out.println("번호\t과목");
			int i = 1;
			for(Professer p : pcontroller.subjctDB) {
				if(mcontroller.logSession==p.mno) {
					System.out.println(i+"\t"+p.subject);
					i++;
				}
			}
			System.out.println("과목선택"); String subject = scanner.next();
			while (true) {
				System.out.println("번호\t학생아이디");
				int j=1;
				for(Student s : Stcontroller.studentDB) {
					if(s.suno==pcontroller.suno(subject)) {
						System.out.println(j+"\t"+mcontroller.findId(s.mno));
					}
				}
				System.out.println("나가기 : 3 진행하기 : 0"); int ch = scanner.nextInt();if( ch == 3) {break;}
				System.out.println("학생선택 : "); String id = scanner.next();
				System.out.println("출결여부 1. 출석 2. 결석"); int attandance = scanner.nextInt();
				boolean result = pcontroller.Attendance(subject,id,attandance);	
				if(result) {
					System.out.println("성공");
				}else {System.out.println("실패");}
			}
		}
		
		
		// 점수입력 페이지
		public void professor_scoring() {
			System.out.println("번호\t과목");
			int i = 1;
			for(Professer p : pcontroller.subjctDB) {
				if(mcontroller.logSession==p.mno) {
					System.out.println(i+"\t"+p.subject);
					i++;
				}
			}
			System.out.println("과목선택"); String subject = scanner.next();
			while (true) {
				System.out.println("번호\t학생아이디");
				int j=1;
				for(Student s : Stcontroller.studentDB) {
					if(s.suno==pcontroller.suno(subject)) {
						System.out.println(j+"\t"+mcontroller.findId(s.mno));
					}
				}
				System.out.println("나가기 : 3 진행하기 : 0"); int ch = scanner.nextInt();if( ch == 3) {break;}
				System.out.println("학생선택 : "); String id = scanner.next();
				System.out.println("점수입력 : "); int score = scanner.nextInt();
				boolean result = pcontroller.scoreinput(subject,id,score);	
				if(result) {
					System.out.println("성공");
				}else {System.out.println("실패");}
			}
		}
		
		
		// 어드민 메인 
		public void admin_login() {
			while( true ) {
				System.out.println("------------- 관리자 ------------");
				System.out.println("1. 학생/교수등록 / 2. 강의등록 / 3. 로그아웃");
				int ch = scanner.nextInt();
				if( ch == 1 ) { add_member(); }
				else if( ch == 2 ) {add_subject_page();}
				else if ( ch == 3 ) { break; } 
			}
		}
		
		// 등록선택 페이지
		public void add_member() {
			System.out.println("------------- 선택하세요 ------------");
			System.out.println("1 . 학생등록 / 2.교수등록");
			int ch = scanner.nextInt();
			if( ch == 1 ) { add_student( ch ) ;}
			else if( ch == 2 ) { add_professer( ch ); }
		}
		
		// 학생등록페이지
		public void add_student( int ch ){
			System.out.println("------------- 학생등록 ------------");
			System.out.println("아이디 : ");		String id = scanner.next();
			System.out.println("비밀번호 : ");		String pw = scanner.next();
			System.out.println("비밀번호 확인 : ");	String comfirmpw = scanner.next();
			System.out.println("전화번호 : ");		String phone = scanner.next();
			System.out.println("이름 : "); 		String name = scanner.next();
			boolean result = acontroller.add_smember(id, comfirmpw, pw, name, phone);
			
			if( result ) { System.out.println("등록에 성공하였습니다.");}
			else { System.err.println("등록에 실패하였습니다."); }
			
		}
		
		// 교수 등록 페이지 
		public void add_professer( int ch ) {
			System.out.println(ch);
			System.out.println("------------- 교수등록 ------------");
			System.out.println("아이디 : ");		String id = scanner.next();
			System.out.println("비밀번호 : ");		String pw = scanner.next();
			System.out.println("비밀번호 확인 : ");	String comfirmpw = scanner.next();
			System.out.println("전화번호 : ");		String phone = scanner.next();
			System.out.println("이름 : "); 		String name = scanner.next();
			boolean result = acontroller.add_pmember(id, comfirmpw, pw, name, phone);
			
			if( result ) { System.out.println("등록에 성공하였습니다.");}
			else { System.err.println("등록에 실패하였습니다."); }
		}
		
		
		// 강의등록 페이지
		public void add_subject_page() {
			System.out.println("------------- 강의등록 ------------");
			System.out.println("강의명 : "); String subject = scanner.next();
			System.out.println("교수아이디 : "); String id = scanner.next();
			
			boolean result = acontroller.subject_reg(subject, id);
			
			if( result ) { System.out.println("등록에 성공하였습니다.");}
			else { System.err.println("등록에 실패하였습니다."); }
		}
		
	
}
