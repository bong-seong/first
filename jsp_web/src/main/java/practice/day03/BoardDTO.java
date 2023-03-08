package practice.day03;

public class BoardDTO {

	// 1. 필드
	private int bno;
	private String bcontent;
	private String bwriter;
	private String bdate;
	
	
	// 2. 생성자
	public BoardDTO() {}

	public BoardDTO(int bno, String bcontent, String bwriter, String bdate) {
		this.bno = bno;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.bdate = bdate;
	}
	
	
	// 3. 메소드
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", bcontent=" + bcontent + ", bwriter=" + bwriter + ", bdate=" + bdate + "]";
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	
	
	
}
