package controller;

public class scoreDto {
	
	private String sno;
	private int ekor ;
	private int emath;
	private int eeng;
	private int ehist;
	
	public scoreDto() {
		// TODO Auto-generated constructor stub
	}

	public scoreDto(String sno, int ekor, int emath, int eeng, int ehist) {
		super();
		this.sno = sno;
		this.ekor = ekor;
		this.emath = emath;
		this.eeng = eeng;
		this.ehist = ehist;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
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
	
	
}
