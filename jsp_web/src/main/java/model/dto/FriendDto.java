package model.dto;

/*
create table friend (
	fno int auto_increment primary key,
    ffrom int,		-- 친구 신청 받은 회원
    fto int, 		-- 친구 신청한 회원
    foreign key ( ffrom ) references member ( mno ) on delete set null ,
    foreign key ( fto ) references member ( mno ) on delete set null		-- 친구가 탈퇴하면 null
);
 */

public class FriendDto {
	
	// 1. 필드
	private int fno;
	private int ffrom;
	private int fto;
	
	
	// 2. 생성자
	public FriendDto() {}

	public FriendDto(int fno, int ffrom, int fto) {
		super();
		this.fno = fno;
		this.ffrom = ffrom;
		this.fto = fto;
	}
	
	
	// 3. 메소드
	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getFfrom() {
		return ffrom;
	}

	public void setFfrom(int ffrom) {
		this.ffrom = ffrom;
	}

	public int getFto() {
		return fto;
	}

	public void setFto(int fto) {
		this.fto = fto;
	}

	@Override
	public String toString() {
		return "FriendDto [fno=" + fno + ", ffrom=" + ffrom + ", fto=" + fto + "]";
	}
	
	
}
