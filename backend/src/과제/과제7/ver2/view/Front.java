package 과제.과제7.ver2.view;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제7.ver2.controller.Controller;
import 과제.과제7.ver2.model.Bank;


public class Front {

	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() { return front; }
	
	
	Scanner scanner = new Scanner(System.in); // 입력객체 선언
	Controller ctr = new Controller();
	Bank bank = new Bank();
	
	// 메인페이지
	public void index() {
		
		while( true ) { // 종료조건 X
			System.out.println("---------- 계좌 관리 ------------");
			System.out.println("은행명\t\t계좌번호\t\t예금액");
			System.out.println();
			System.out.print("메뉴 > 1. 계좌생성 / 2. 예금");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) { bank_select_page(); }
			else if( ch == 2 ) {}
		}
	}
	
	// 은행 선택 페이지 
	public void bank_select_page() {
		System.out.println("---------- 계좌 생성 ------------");
		System.out.print("1. 신한은행 / 2. 국민은행 / 3. 우리은행 : ");
		int ch = scanner.nextInt();
		
		if( ch == 1 ) { create_account_page( ch ); }
		else if( ch == 2 ) {}
		else if( ch == 3 ) {}
	}
	
	// 계좌 생성페이지
	public void create_account_page( int ch ) {
		System.out.println("---------- 계좌 정보 입력 ------------");
		System.out.println("계좌주 : "); String name = scanner.next();
		System.out.println("비밀번호(4자리) : "); String pwd = scanner.next();
		
		int result = ctr.create_account( ch , name , pwd );
		if( result == -1 ) { bank.add_account_noti(); }
		else if( result == -2 ) {}
		else if( result == -3 ) {}
		
		view_account_page( ch );
	}
	
	public void view_account_page( int ch ) {
		Bank info = ctr.getBankDB().get(ch);
		System.out.println( info.getName() );
		System.out.println("---------- 계좌 생성완료 ------------");
		System.out.println("계좌주 : ");
		System.out.println("계좌번호 : ");
		System.out.println("은행명 : ");
	}
	
	
}
