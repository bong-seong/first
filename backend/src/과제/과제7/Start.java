package 과제.과제7;

import java.util.Scanner;

public class Start {
	public static void main(String[] args) {
		
	
		Scanner scanner = new Scanner(System.in);
		Bank bank = new Bank();
		
		
		while( true ) {
			System.out.println("--------- 계좌관리 ---------");
			System.out.println("은행명\t\t계좌번호\t\t예금액");
			
			for( int i=0; i<bank.bankDB.size(); i++ ) {
				System.out.println(bank.bankDB.get(i).bankname + "\t\t" + bank.bankDB.get(i).account + "\t\t" + bank.bankDB.get(i).money );
			}
			
			System.out.println();
			System.out.println("메뉴 >> 1.계좌생성 / 2.예금");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) { bank.add_account(); }
			else if( ch == 2 ) {}
			
		} // while e
		
	
		
		
		
		
	} // main e
} // class e
