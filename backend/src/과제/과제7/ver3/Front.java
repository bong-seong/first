package 과제.과제7.ver3;

import java.util.Scanner;

public class Front {
	
	
	
	
	private static Front front = new Front();
	private Front() {};
	public static Front getInstance() {
		return front;
	}
	
	
	신한 sh = new 신한();
	국민 kb = new 국민();
	우리 wo = new 우리();
	Scanner scanner = new Scanner(System.in);
	
	// 메인화면
	public void index() {
		while( true ) {
			System.out.println("-------- 계좌 관리 --------");
			System.out.println("은행명\t\t계좌번호\t\t\t예금액");
			for(은행 bank : 은행.bankDB ) {
				if ( bank instanceof 신한 ) {
					 System.out.println("신한\t\t" + bank.account + "\t\t" + bank.money );
				}else if ( bank instanceof 국민) {
					System.out.println("국민\t\t" + bank.account + "\t\t" + bank.money );
				}else if ( bank instanceof 우리 ) {
					System.out.println("우리\t\t" + bank.account + "\t\t" + bank.money );
				}
			}
			System.out.println();
			System.out.println("메뉴 >> 1. 계좌생성 / 2. 예금");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) { select_bank(); }
			else if( ch == 2 ) {}
			
		}
	}
	
	// 은행선택 화면 페이지
	public void select_bank() {
		System.out.println("-------- 계좌 생성 --------");
		System.out.println("메뉴 >> 1. 신한은행 / 2. 국민은행 / 3. 우리은행");
		int ch = scanner.nextInt();
		
		if( ch == 1 ) { account_add( ch ); }
		else if( ch == 2) { account_add( ch ); }
		else if( ch == 3 ) { account_add( ch ); }
		
	}
	
	public void account_add( int ch ) {
		
		if ( ch == 1 ) {
			System.out.println("-------- 신한은행 --------");
			System.out.println("계좌주 : ");		String name = scanner.next();
			System.out.println("비밀번호 : ");		String pwd = scanner.next();
			
			boolean result = sh.create_account(name, pwd);
			
			if( result ) { System.out.println("신한은행을 이용해주셔서 감사합니다.");}
			else { System.out.println("계좌 생성에 실패하였습니다."); }
			
			System.out.println("-------- 계좌정보 --------");
			System.out.println("계좌주 : " + 은행.bankDB.get( 은행.bankDB.size()-1 ).name );
			System.out.println("계좌번호 : " +은행.bankDB.get( 은행.bankDB.size()-1 ).account );
			
			System.out.println("은행 : ");
			
		}else if( ch == 2 ) {
			System.out.println("-------- 국민은행 --------");
			System.out.println("계좌주 : ");		String name = scanner.next();
			System.out.println("비밀번호 : ");		String pwd = scanner.next();
			
			boolean result = kb.create_account(name, pwd);
			
			if( result ) { System.out.println("국민은행을 이용해주셔서 감사합니다.");}
			else { System.out.println("계좌 생성에 실패하였습니다."); }
			
		}else if( ch == 3 ) { 
			System.out.println("-------- 우리은행 --------");
			System.out.println("계좌주 : ");		String name = scanner.next();
			System.out.println("비밀번호 : ");		String pwd = scanner.next();
			
			boolean result = wo.create_account(name, pwd);
			
			if( result ) { System.out.println("우리은행을 이용해주셔서 감사합니다.");}
			else { System.out.println("계좌 생성에 실패하였습니다."); }
		}
		
	}
	

	
}
