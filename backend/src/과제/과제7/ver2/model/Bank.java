package 과제.과제7.ver2.model;

public class Bank {
	
	// 1. 필드
	String account;
	String pwd;
	String name;
	int money;
	
	
	// 2. 생성자
	public Bank() {}
	public Bank(String account, String pwd, String name, int money) {
		this.account = account;
		this.pwd = pwd;
		this.name = name;
		this.money = money;
	}
	
	
	// 3. 메소드
	public void add_account_noti() {
		System.out.println("계좌 만들어주셔서 감사합니다.");
	}
	
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
	
	
}
