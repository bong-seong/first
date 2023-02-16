package 과제.자율미니프로젝트.model;


public class Attendance {
	public int ano;//<-식별자
	public boolean attendance;
	public String date;

	public int mno;
	public int suno;
	
	public Attendance() {
		// TODO Auto-generated constructor stub
	}

	public Attendance(int ano, boolean attendance, String date, int mno, int suno) {
		super();
		this.ano = ano;
		this.attendance = attendance;
		this.date = date;
		this.mno = mno;
		this.suno = suno;
	}

	@Override
	public String toString() {
		return "Attendance [ano=" + ano + ", attendance=" + attendance + ", date=" + date + ", mno=" + mno + ", suno="
				+ suno + "]";
	}
	
}
