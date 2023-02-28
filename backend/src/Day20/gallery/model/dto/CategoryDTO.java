package Day20.gallery.model.dto;

public class CategoryDTO {
	
	// 1. 필드
	private int cno;
	private String cname;
	

	// 2. 생성자
	public CategoryDTO() {}

	public CategoryDTO(int cno, String cname) {
		this.cno = cno;
		this.cname = cname;
	}

	
	// 3. 메소드
	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	
	
}
