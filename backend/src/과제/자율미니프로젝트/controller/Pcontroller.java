package 과제.자율미니프로젝트.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import 과제.자율미니프로젝트.model.Professer;
import 과제.자율미니프로젝트.model.Score;
import 과제.자율미니프로젝트.model.Student;
import 과제.자율미니프로젝트.model.Attendance;

public class Pcontroller extends Mcontroller{
	public static ArrayList<Professer> subjctDB = new ArrayList<>();
	
	//suno뽑기
	public int suno(String subject) {
		int suno = -1;
		for(Professer p : subjctDB) {
			if(p.subject.equals(subject)) {
				suno = p.suno;
			}
		}
		return suno;
	}
	
	//과목뽑기
	public String subject(int suno) {
		String subject = "";
		for(Professer p : subjctDB) {
			if(suno==p.suno) {
				subject = p.subject;
			}
		}
		return subject;
	}
	
	//교수mno
	public int pNo(int suno) {
		int mno = -1;
		for(Professer p : subjctDB) {
			if(suno==p.suno) {
				mno = p.mno;
			}
		}
		return mno;
	}
	
	// 1. 출석체크 
	public boolean Attendance(String subject, String id, int attandance) {
	
		int suno =suno(subject);
		int mno = mno(id);
		
		boolean attand = false; 
		if (attandance==1)attand=true;
		else attand = false;
		
		LocalDate now = LocalDate.now();
		String date = now.getYear()+"-"+now.getMonthValue()+"-"+now.getDayOfMonth();
		
		int ano = 0;
		if(Atcontroller.attendanceList.size()==0) {
			ano=0;
		}else {
			ano = Atcontroller.attendanceList.get(Atcontroller.attendanceList.size()-1).ano+1;
		}
		
		for(Student s: Stcontroller.studentDB) {
			if(s.mno==mno && s.suno==suno) {
				Attendance attendance = new Attendance(ano, attand, date, mno, suno);
				Atcontroller.attendanceList.add(attendance);
			}
		}
		return true;
	}
	
	
	//2. 점수입력
	public boolean scoreinput(String subject, String id, int score) {
		int suno =suno(subject);
		int mno = mno(id);
		
		int sno = 0;
		if(Scontroller.scoreList.size()==0) {
			sno=0;
		}else {
			sno = Scontroller.scoreList.get(Scontroller.scoreList.size()-1).sno+1;
		}
		
		for(Student s: Stcontroller.studentDB) {
			if(s.mno==mno && s.suno==suno) {
				Score scores = new Score(sno, score, mno, suno);
				Scontroller.scoreList.add(scores);
			}
		}
		return true;
	}
	
	
}
