package 과제.중고.model;

public class Memo {
		
	// 1. 필드
	private int seq;
	private String content;
	private int m_seq;
	private int p_seq;
	
	// 2. 생성자
	public Memo() {}

	public Memo(int seq, String content, int m_seq, int p_seq) {
		this.seq = seq;
		this.content = content;
		this.m_seq = m_seq;
		this.p_seq = p_seq;
	}


	// 3. 메소드
	@Override
	public String toString() {
		return "Memo [seq=" + seq + ", content=" + content + ", m_seq=" + m_seq + ", p_seq=" + p_seq + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getM_seq() {
		return m_seq;
	}

	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}

	public int getP_seq() {
		return p_seq;
	}

	public void setP_seq(int p_seq) {
		this.p_seq = p_seq;
	}
	
	
}
