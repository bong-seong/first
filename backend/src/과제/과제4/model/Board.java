package 과제.과제4.model;

public class Board {
	// 1. 필드
	public String wirter;
	public String title;
	public String content;
	public int count; 
	
	// 2. 생성자
	public Board() { }

	public Board(String wirter, String title,  String content , int count) {
		super();
		this.wirter = wirter;
		this.title = title;
		this.count = count;
	}

	// 3. 메소드
}
