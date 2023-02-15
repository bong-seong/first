package 과제.과제7;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bank {
	
	// 1. 필드
	String account;
	String pw;
	String name;
	String bankname;
	int money;
	
	Scanner scanner = new Scanner(System.in);
	ArrayList<Bank> bankDB = new ArrayList<>();
	
	// 2. 생성자 
	public Bank() {}
	
	public Bank(String account, String pw, String name, int money) {
		this.account = account;
		this.pw = pw;
		this.name = name;
		this.money = money;
	}


	
	
	public void add_account() {
		
		System.out.println("--------- 계좌생성 ---------");
		System.out.println("1. 신한은행 / 2. 국민은행 / 3. 우리은행 : ");
		int ch = scanner.nextInt();
		
		if( ch == 1 ) { infomation( ch ); }
		else if( ch == 2 ) { infomation( ch ); }
		else if( ch == 3 ) { infomation( ch ); }
		
	}
	
	public void infomation( int ch ) {
		System.out.println("--------- 계좌 정보 입력 ---------");
		System.out.println("계좌주 : "); 
		String name = scanner.next();
		
		System.out.println("계좌비밀번호 : ");
		String pw = scanner.next();
		
		String account = bank_check( ch );
		
		
		Bank bank = new Bank( account, pw , name, money ) ;
		bankDB.add(bank);
		
		add_complet( account , ch );			
	}
	
	public void add_complet( String account , int ch) {
		
		String bank_name = "";
		if( account.substring(0, 2).equals("03") ) {
			bank_name = "신한";
		}else if (account.substring(0, 2).equals("04")) {
			bank_name = "국민";
		}else if (account.substring(0, 2).equals("05")) {
			bank_name = "우리";
		}
		
		bankDB.get(ch).bankname = bank_name;
		
		for( int i=0; i<bankDB.size(); i++ ) {
			if( bankDB.get(i).account.equals(account) ) {
				System.out.println("--------- 계좌 생성 완료 ---------");
				System.out.println("계좌주 : " + bankDB.get(i).name );
				System.out.println("계좌번호 : " + bankDB.get(i).account );
				System.out.println("은행 : " + bankname );
				if( bankname.equals("신한") ) {
					System.out.println("신한은행 계좌 만들어주셔서 감사합니다."); 
				}else if( bankname.equals("국민") ){
					System.out.println("국민은행 계좌 만들어주셔서 감사합니다.");
				}else if ( bankname.equals("우리") ) {
					System.out.println("우리은행 계좌 만들어주셔서 감사합니다.");
				}
			}
		}
		
	}
	
	public String bank_check( int ch ) {
		Random random = new Random();
		int nansoo1 = random.nextInt(99);
		int nansoo2 = random.nextInt(99);
	
		if( ch == 1 ) { return "03-"+nansoo1+ "-" +nansoo2; }
		else if ( ch == 2 ){ return "04-"+nansoo1+ "-" +nansoo2; }
		else if( ch == 3 ) { return "05-"+nansoo1+ "-" +nansoo2; }
		
		return null;
	}
	
	
}
