package 과제.자율미니프로젝트.controller;

import java.util.ArrayList;

import 과제.자율미니프로젝트.model.Member;
import 과제.자율미니프로젝트.model.Student;

public class Stcontroller extends Member{
	Pcontroller pcontroller = new Pcontroller();
	public static ArrayList<Student> studentDB = new ArrayList<>();
	
	public void enrollSubject(int suno) {
		int mno = Mcontroller.logSession;
		
		Student student = new Student(mno, suno);
		studentDB.add(student);
	}
	
	
	/*점수 확인*/
	public int checkScore(String checkSN) {
		int suno = pcontroller.suno(checkSN);
		int mno = Mcontroller.logSession;
		
		for(int i = 0; i < studentDB.size(); i++) {
			if(studentDB.get(i).mno == mno) {
					if(studentDB.get(i).suno == suno) {
						return returnScore(mno,suno);
					}
			}
		}
		return -1; //찾지 못했을 경우
	}
	
	/*점수 반환 메소드*/
	public int returnScore(int mno, int suno) {
		for(int i =0; i < Scontroller.scoreList.size(); i++) {
			if(Scontroller.scoreList.get(i).mno == mno && Scontroller.scoreList.get(i).suno == suno) {
				return Scontroller.scoreList.get(i).score;
			}
		}
		return -1; //점수를 찾지 못했을 경우
	}
}
