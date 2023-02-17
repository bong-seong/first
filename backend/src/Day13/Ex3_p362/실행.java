package Day13.Ex3_p362;

public class 실행 {
	
	public static void main(String[] args) {
		
		RemoteControl rc = new SmartTV();
		
		rc.turnOn();
		rc.turnOff();
		
		Searchable temp = (Searchable)rc;
		Searchable sc = new SmartTV();
		
		sc.search( "www.naver.com" );
		temp.search("www.naver.com");
		
	
		
	}

}
