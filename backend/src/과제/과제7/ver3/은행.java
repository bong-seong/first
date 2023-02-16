package 과제.과제7.ver3;

import java.util.ArrayList;
import java.util.Random;

public class 은행 {

	// 1. 필드
	protected String account;
	protected String name;
	protected String pwd;
	protected int money;

	static ArrayList<은행> bankDB = new ArrayList<>();
	public ArrayList<은행> getBankDB() {
		return bankDB;
	}
	
	protected Random random = new Random();
	
	
	
	
	// 2. 생성자
	public 은행() {}
	public 은행(String account, String name, String pwd, int money) {
		this.account = account;
		this.name = name;
		this.pwd = pwd;
		this.money = money;
	}
	
	
	// 3. 메소드 
	public boolean create_account( String name , String pwd ) {
		String code = "";
		
		int nansoo1 = random.nextInt(99);
		int nansoo2 = random.nextInt(99);
		int nansoo = nansoo1 + nansoo2;
		
		String account = code + Integer.toString(nansoo);
		
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "은행 [account=" + account + ", name=" + name + ", pwd=" + pwd + ", money=" + money + "]";
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
}
