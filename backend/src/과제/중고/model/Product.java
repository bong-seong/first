package 과제.중고.model;

public class Product {
	
	// 1. 필드
	private int seq;
	private String p_name;
	private String p_content;
	private int m_seq;
	
	// 2. 생성자
	public Product() {}

	public Product(int seq, String p_name, String p_content, int m_seq) {
		this.seq = seq;
		this.p_name = p_name;
		this.p_content = p_content;
		this.m_seq = m_seq;
	}

	
	// 3. 메소드
	@Override
	public String toString() {
		return "Product [seq=" + seq + ", p_name=" + p_name + ", p_content=" + p_content + ", m_seq=" + m_seq + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public int getM_seq() {
		return m_seq;
	}

	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}
	
	
	

}
