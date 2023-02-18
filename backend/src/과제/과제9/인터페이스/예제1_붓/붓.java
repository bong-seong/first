package 과제.과제9.인터페이스.예제1_붓;

public interface 붓 {
	
	String DEFAULT_COLOR = "검정";
	
	public static final String BLUE     = "\u001B[34m" ;
	public static final String GREEN    = "\u001B[32m" ;
	public static final String RED      = "\u001B[31m" ;
	public static final String RESET 	= "\u001B[0m"; 
	void 그리기();
	
	
	default void setDefault() {
		System.out.println("기본 색상으로 변경합니다.");
	}
}
