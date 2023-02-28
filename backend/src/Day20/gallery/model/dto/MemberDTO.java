package Day20.gallery.model.dto;

public class MemberDTO {

	// 1. 필드
	private int mno;
	private String mid;
	private String mpw;
	private String mname;
	private String mphone;
	
	// 2. 생성자
	public MemberDTO() {}

	public MemberDTO(int mno, String mid, String mpw, String mname, String mphone) {
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mphone = mphone;
	}

	
	// 3. 메소드
	
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
}	
