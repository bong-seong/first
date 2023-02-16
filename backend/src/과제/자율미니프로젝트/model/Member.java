package 과제.자율미니프로젝트.model;

public class Member {
	//1.필드
	public int mno;
	public String id;
	public String pw;
	public String name;
	public String phone;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int mno, String id, String pw, String name, String phone) {
		super();
		this.mno = mno;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member [mno=" + mno + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
