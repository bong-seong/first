package 과제.중고.model;

public class Member {

	// 1. 필드
	private int seq;
	private String id;
	private String pw;
	private String name;
	private String phone;
	
	// 2. 생성자
	public Member() {}

	public Member(int seq, String id, String pw, String name, String phone) {
		this.seq = seq;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
	}


	// 3. 메소드
	@Override
	public String toString() {
		return "Member [seq=" + seq + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + "]" ;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


}
