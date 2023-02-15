package 과제.과제7.ver2.model;



public class Sh extends Bank {
	
	// 1. 필드
	public final String code = "03";
	
	// 2. 생성자
	
	public Sh( String account, String pwd, String name, int money ) {

	}

	@Override
	public void add_account_noti() {
		System.out.println("신한은행 계좌 만들어주셔서 감사합니다.");
	}
	
}
