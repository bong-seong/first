package 과제.과제9.인터페이스.예제1_붓;

public interface 붓 {
	
	String DEFAULT_COLOR = "검정";
	
	void 그리기();
	
	
	default void setDefault() {
		System.out.println("기본 색상으로 변경합니다.");
		System.out.println( "현재 컬러" + DEFAULT_COLOR );
	}
}
