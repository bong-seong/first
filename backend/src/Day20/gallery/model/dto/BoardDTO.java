package Day20.gallery.model.dto;

import java.util.Date;

public class BoardDTO {
	
	// 1. 필드
	private int bno;
	private String btitle; 
	private String bcontent;
	private String bdate;
	private int bview;
	private String mid;
	private String cname;
	
	
	// 2. 생성자
	public BoardDTO() {}

	public BoardDTO(int bno, String btitle, String bcontent, String bdate, int bview, String mid, String cname) {
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bview = bview;
		this.mid = mid;
		this.cname = cname;
	}
	
	
	// 3. 메소드
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	
	
	
}
