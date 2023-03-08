package model.dto;

/*
 create table member (
	mno int auto_increment primary key,
    mid varchar(30) not null unique,		-- 회원 아이디 [ 공백불가 , 중복불가 ] 
    mpwd varchar(20) not null,				-- 회원 비밀번호 [ 공백불가 ] 
    mimg longtext,							-- 웹서버에 저장된 사진 경로
    memail varchar(100) not null unique		-- 회원 이메일 [ 공백불가 , 중복불가 ]
);
 */

public class MemberDto {
	
	// 1. 필드
	private int mno;
	private String mid;
	private String mpwd;
	private String mimg;
	private String memail;
	
	
	// 2. 생성자
	public MemberDto() {}

	public MemberDto(int mno, String mid, String mpwd, String mimg, String memail) {
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.mimg = mimg;
		this.memail = memail;
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

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", mimg=" + mimg + ", memail=" + memail
				+ "]";
	}
	
	
	
	
}
