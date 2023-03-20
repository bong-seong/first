package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReplyDto {
	
	// 1. 필드
	private int rno;
	private String rcontent;
	private String rdate;
	private int rindex;
	private int mno;
	private int bno;
	// 추가
	private String mid;
	private String mimg;
	
	// 2. 생성자
	public ReplyDto() { }

	public ReplyDto(int rno, String rcontent, String rdate, int rindex, int mno, int bno, String mid, String mimg) {
		super();
		this.rno = rno;
		this.rcontent = rcontent;
		
		// 오늘 날짜와 작성일이 동일하면 시간표기 / 아니면 날짜표기 
			// 1. 오늘잘짜 [ Data클래스 : java.util ]
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = sdf.format(date);
		
			// 2. 만약에 오늘날짜와 작성일과 동일하면 [ split 문자열 자르기 ]
					// "yyyy-MM-dd hh:mm:ss".split(" ") --> 날짜와 시간 분해
					// now.split(" ")[0] : 날짜		now.split(" ")[1] : 시간
		if( now.split(" ")[0].equals( rdate.split(" ")[0]) ) {
			this.rdate = rdate.split(" ")[1]; // 오늘과 같으면 시간
		}else {
			this.rdate = rdate.split(" ")[0]; // 오늘과 다르면 날짜
		}
		
		this.rindex = rindex;
		this.mno = mno;
		this.bno = bno;
		this.mid = mid;
		this.mimg = mimg;
	}

	// 등록용 생성자
	public ReplyDto(String rcontent, int mno, int bno) {
		super();
		this.rcontent = rcontent;
		this.mno = mno;
		this.bno = bno;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getRindex() {
		return rindex;
	}

	public void setRindex(int rindex) {
		this.rindex = rindex;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	@Override
	public String toString() {
		return "ReplyDto [rno=" + rno + ", rcontent=" + rcontent + ", rdate=" + rdate + ", rindex=" + rindex + ", mno="
				+ mno + ", bno=" + bno + ", mid=" + mid + ", mimg=" + mimg + "]";
	}

}
