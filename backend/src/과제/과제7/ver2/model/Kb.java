package 과제.과제7.ver2.model;

public class Kb extends Bank {
	final String code = "04";
	
	
	public Kb(String account, String pwd, String name, int money ) {

	}
	
	@Override
	public void add_account_noti() {
		System.out.println("국민은행 계좌 만들어주셔서 감사합니다.");
	}
}
