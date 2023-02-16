package 과제.자율미니프로젝트.model;

public class Professer {
	public int suno;
	public String subject; 
	public int mno;
	
	public Professer() {
		// TODO Auto-generated constructor stub
	}

	public Professer(int suno, String subject) {
		super();
		this.suno = suno;
		this.subject = subject;
	}

	public Professer(int suno, String subject, int mno) {
		super();
		this.suno = suno;
		this.subject = subject;
		this.mno = mno;
	}
	
}
