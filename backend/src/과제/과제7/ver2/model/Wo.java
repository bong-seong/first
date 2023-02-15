package 과제.과제7.ver2.model;

public class Wo extends Bank {
	
	// 1. 필드
	final String code = "05";
	
	// 2. 생성자
	public Wo(String account, String pwd, String name, int money ) {

	}
	
	@Override
	public void add_account_noti() {
		System.out.println("우리은행 계좌 만들어주셔서 감사합니다.");
	}
}
