package 과제.자율미니프로젝트.model;

public class Score {
	public int sno; //<-식별자
	public int score;

	public int mno;//<-회원
	public int suno;//<-과목
	
	public Score() {
		// TODO Auto-generated constructor stub
	}

	public Score(int sno, int score, int mno, int suno) {
		super();
		this.sno = sno;
		this.score = score;
		this.mno = mno;
		this.suno = suno;
	}

	@Override
	public String toString() {
		return "Score [sno=" + sno + ", score=" + score + ", mno=" + mno + ", suno=" + suno + "]";
	}
	
	
}
