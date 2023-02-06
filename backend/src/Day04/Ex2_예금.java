package Day04;

import java.util.Scanner;

public class Ex2_예금 { // class start
	
	public static void main(String[] args) { // m s
		
		// * 
		Scanner scanner = new Scanner(System.in);
		// * 예금액 [ 누적 ] , 계좌번호 , 패스워드 
		int balance = 0; String account = "123-1234"; short pwd = 1234;  
		
		while( true ) { // 무한루프 [ 종료조건 : 4 입력시 ]
			System.out.println("--------------------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료 : ");
			System.out.println("--------------------------");
			System.out.print(" >> 선택 : ");
			int ch = scanner.nextInt();
			// --------------------------- 1. 예금 ------------------------// 
			if( ch == 1 ) {
				System.out.print(" >>> 예금할 계좌번호 : ");
				String inaccount = scanner.next();
				// ------------------ 1-1. 입력받은 계좌번호 체크 ---------------------//
				if( account.equals( inaccount ) ) { // 만약에 계좌번호와 입력받은 계좌번호가 같으면
					System.out.print(" >>> 예금할 금액 : ");
					balance += scanner.nextInt();
					System.out.println(" >>> 예금 후 금액 : " + balance );
				}else {
					System.out.println(" >>> 존재하지 않는 계좌번호 입니다.");
				}
				
			}
			// --------------------------- 2. 출금 ------------------------//
			else if( ch == 2 ) {
				System.out.print(" >>> 출금할 계좌번호 : ");
				String inaccount = scanner.next();
				// ------------------ 2-1. 계좌번호 체크 --------------------- //
				if( account.equals(inaccount)) {
					System.out.print(" >>> 계좌 비밀번호 : ");
					short inpwd = scanner.nextShort();
					// ------------------ 2-2. 패스워드 체크 ------------------- // 
					if( pwd == inpwd ) { // 만약에 비밀번호와 입력받은 비밀번호가 같으면
						System.out.print(" >>> 출금할 금액 : ");
						// 만약에 입력받은 출금액이 잔액보다 작았을 경우에만 출금 가능
						int pay = scanner.nextInt();
						// ---------------- 2-3. 입력받은 금액 유효성 체크 ---------------//
						if( balance > pay ) { // 만약에 입력받은 출금액이 잔액보다 작으면 출금진행
							balance -= pay;
							System.out.print(" >>> 출금할 금액 : " + balance );
						}else {
							System.out.println(" >>> 잔액이 부족합니다 : " + balance );
						}
						 
					}else {
						System.out.println(" >>> 패스워드 불일치");
					}
				}else {
					System.out.println(" >>> 없는 계좌번호입니다.");
				}
				
			}
			// --------------------------- 3. 잔액확인 ------------------------//
			else if( ch == 3 ) {
				System.out.println(" >>> 예금 잔액 : " + balance );
			}
			// --------------------------- 4. 종료 ------------------------//
			else if( ch == 4 ) { System.out.println(" >>> 종료"); break; }
			else { System.out.println(" >>> 알수없는 번호입니다. [ 다시입력 ] "); }
			
			
		
				
			
		} // 무한루프 종료
		
		
	} // m e
} // class end


/*
 	
 	1. if 중첩
 	2.
 		자료형[char] == '안' == '안' 
 		클래스[String] : 객체A.equals(객채B)
 						"안녕" == "안녕"		[ X ]
 						"안녕".equals("안녕") 	[ O ]
 */						





