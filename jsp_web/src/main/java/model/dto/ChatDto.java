package model.dto;

public class ChatDto {

	// 1. 필드
	private int nno;
	private String ncontent;
	private String ndate;
	private int pno;
	private int from_mno;
	private int to_mno;
	// 추가필드
	private String frommid;		// 보낸 사람의 아이디
	private String frommimg;	// 보낸 사람의 프로필
	
	
	// 2. 생성자
	public ChatDto() {
		// TODO Auto-generated constructor stub
	}

	public ChatDto(int nno, String ncontent, String ndate, int pno, int from_mno, int to_mno) {
		super();
		this.nno = nno;
		this.ncontent = ncontent;
		this.ndate = ndate;
		this.pno = pno;
		this.from_mno = from_mno;
		this.to_mno = to_mno;
	}
	
	// 3. 메소드
	
	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public String getNdate() {
		return ndate;
	}

	public void setNdate(String ndate) {
		this.ndate = ndate;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getFrom_mno() {
		return from_mno;
	}

	public void setFrom_mno(int from_mno) {
		this.from_mno = from_mno;
	}

	public int getTo_mno() {
		return to_mno;
	}

	public void setTo_mno(int to_mno) {
		this.to_mno = to_mno;
	}
	
	public String getFrommid() {
		return frommid;
	}

	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}

	public String getFrommimg() {
		return frommimg;
	}

	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}

	@Override
	public String toString() {
		return "ChatDto [nno=" + nno + ", ncontent=" + ncontent + ", ndate=" + ndate + ", pno=" + pno + ", from_mno="
				+ from_mno + ", to_mno=" + to_mno + "]";
	}
	
	
}
