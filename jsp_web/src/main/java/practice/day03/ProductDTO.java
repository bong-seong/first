package practice.day03;

public class ProductDTO {

	private int seq;
	private String name ;
	private int price;
	private String reg_date;
	
	public ProductDTO() {}

	public ProductDTO(int seq, String name, int price, String reg_date) {
		this.seq = seq;
		this.name = name;
		this.price = price;
		this.reg_date = reg_date;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	

	
}
