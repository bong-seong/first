package model.dto;

/*
create table mpoint (
	mpno int auto_increment primary key,		-- 포인트 내역 식별변호
    mpcomment varchar(1000) not null,			-- 포인트 내역
    mpamount int default 0 ,					-- 포인트 수량
    mdate datetime default now(),				-- 포인트 날짜
    mno int,									-- 포인트 소유 멤버 
    foreign key ( mno ) references member ( mno ) on delete set null -- 탈퇴하면 포인트 null
);
 */

public class MpointDto {

	// 1. 필드
	private int mpno;
	private String mpconmment;
	private int mpamount;
	private String mpdate;
	private int mno;
	
	
	// 2. 생성자
	public MpointDto() {}

	public MpointDto(int mpno, String mpconmment, int mpamount, String mpdate, int mno) {
		this.mpno = mpno;
		this.mpconmment = mpconmment;
		this.mpamount = mpamount;
		this.mpdate = mpdate;
		this.mno = mno;
	}

	
	// 3. 메소드
	public int getMpno() {
		return mpno;
	}

	public void setMpno(int mpno) {
		this.mpno = mpno;
	}

	public String getMpconmment() {
		return mpconmment;
	}

	public void setMpconmment(String mpconmment) {
		this.mpconmment = mpconmment;
	}

	public int getMpamount() {
		return mpamount;
	}

	public void setMpamount(int mpamount) {
		this.mpamount = mpamount;
	}

	public String getMpdate() {
		return mpdate;
	}

	public void setMpdate(String mpdate) {
		this.mpdate = mpdate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "MpointDto [mpno=" + mpno + ", mpconmment=" + mpconmment + ", mpamount=" + mpamount + ", mpdate="
				+ mpdate + ", mno=" + mno + "]";
	}
	
	
}
