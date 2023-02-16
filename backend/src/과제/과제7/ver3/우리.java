package 과제.과제7.ver3;

public class 우리 extends 은행 {
	
	// 1. 필드
	final String code = "05";

	
	// 2. 생성자
	public 우리() {}
	public 우리( String account , String name , String pwd , int money ) {
		super(account, name, pwd ,money);
	}
	
	// 3. 메소드
	@Override
	public boolean create_account ( String name , String pwd ) {
		
		int nansoo1 = random.nextInt(99);
		int nansoo2 = random.nextInt(99);
		String nansoo = nansoo1 + "-" + nansoo2;
		
		String account = this.code + "-" + nansoo;
		
		우리 woori = new 우리(account, name, pwd , money );
		bankDB.add(woori);

		System.out.println( bankDB );
		return true;
	}

}
