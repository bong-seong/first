package 과제.과제7.ver3;

public class 신한 extends 은행 {

	
	// 1. 필드
	final String code = "03";

	
	// 2. 생성자
	public 신한() {}
	public 신한( String code , String account , String name , String pwd , int money ) {
		super(account, name, pwd ,money);
	}
	
	// 3. 메소드
	@Override
	public boolean create_account ( String name , String pwd ) {
		
		int nansoo1 = random.nextInt(99);
		int nansoo2 = random.nextInt(99);
		String nansoo = nansoo1 + "-" + nansoo2;
		
		String account = this.code + "-" + nansoo;
		
		신한 shinhan = new 신한( this.code , account, name, pwd , money );
		bankDB.add(shinhan);

		System.out.println( bankDB.toString() );
		return true;
	}
	
	@Override
	public String toString() {
		return "신한 [code=" + code + "]";
	}
	
	
	
	
}
