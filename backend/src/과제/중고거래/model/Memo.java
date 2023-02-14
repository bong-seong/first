package 과제.중고거래.model;

public class Memo {
	
	// 1. 필드
	private String mcontent;
	private Member sendm;
	private Member recvm;

	
	// 2. 생성자
	public Memo() {}
	public Memo(String mcontent, Member sendm, Member recvm) {
		this.mcontent = mcontent;
		this.sendm = sendm;
		this.recvm = recvm;
	}
	
	// 3. 메소드
	@Override
	public String toString() {
		return "Memo [mcontent=" + mcontent + ", sendm=" + sendm + ", recvm=" + recvm + "]";
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	public Member getSendm() {
		return sendm;
	}
	public void setSendm(Member sendm) {
		this.sendm = sendm;
	}
	public Member getRecvm() {
		return recvm;
	}
	public void setRecvm(Member recvm) {
		this.recvm = recvm;
	}
	
	
	
	
}
