package 과제.과제7.ver2.controller;

import java.util.ArrayList;
import java.util.Random;

import 과제.과제7.ver2.model.Bank;
import 과제.과제7.ver2.model.Sh;

public class Controller {

	Random random = new Random(); // 랜덤 객체 생성
	ArrayList<Bank> bankDB = new ArrayList<>();
	
	public ArrayList<Bank> getBankDB(){
		return bankDB;
	}
	
	// 계좌 생성
	public int create_account( int ch , String pwd , String name) {
		
		// 계좌 만들기
		int nansoo1 = random.nextInt(99); // 0~99 까지의 난수 정수
		int nansoo2 = random.nextInt(99);
		
		String account = "-" + nansoo1 + "-" + nansoo2;

		// DB 저장
		if( ch == 1 ) { 
			Sh sh = new Sh(account, pwd, name, 0);
			bankDB.add(sh);
			return -1 ; 
		}
		else if( ch == 2 ) { return -2 ;}
		else if( ch == 3 ) { return -3 ;}
		
		return 0;
	}
	
}
