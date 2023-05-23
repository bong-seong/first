package controller;

public class Dto {
	
	private String sno ;
	private String sname;
	private String shphone ;
	private String sgender ;
	private String saddress;
	
	
	private int ekor ;
	private int emath;
	private int eeng;
	private int ehist;
	
	private int sum;
	private double avg;
	private String rank;
	
	// 0. 빈생성자
	public Dto() {}

	// 1. 학생목록 출력시 사용되는 생성자
	public Dto(String sno, String sname, String shphone, String sgender, String saddress) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.shphone = shphone;
		this.sgender = sgender;
		this.saddress = saddress;
	}
	
	// 2. 
	public Dto(String sno, int ekor, int emath, int eeng, int ehist) {
		super();
		this.sno = sno;
		this.ekor = ekor;
		this.emath = emath;
		this.eeng = eeng;
		this.ehist = ehist;
	}
	
	// 3. 성적 출력용 
	public Dto(String sno, String sname, int ekor, int emath, int eeng, int ehist, int sum, double avg , String rank ) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.ekor = ekor;
		this.emath = emath;
		this.eeng = eeng;
		this.ehist = ehist;
		this.sum = sum;
		this.avg = avg;
		this.rank = rank;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getShphone() {
		return shphone;
	}

	public void setShphone(String shphone) {
		this.shphone = shphone;
	}

	public String getSgender() {
		return sgender;
	}

	public void setSgender(String sgender) {
		this.sgender = sgender;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public int getEkor() {
		return ekor;
	}

	public void setEkor(int ekor) {
		this.ekor = ekor;
	}

	public int getEmath() {
		return emath;
	}

	public void setEmath(int emath) {
		this.emath = emath;
	}

	public int getEeng() {
		return eeng;
	}

	public void setEeng(int eeng) {
		this.eeng = eeng;
	}

	public int getEhist() {
		return ehist;
	}

	public void setEhist(int ehist) {
		this.ehist = ehist;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	

}
