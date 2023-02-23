package 과제.과제11;

public class ProductDTO {

	// 1. 필드
	private int seq;
	private String name;
	private int price;
	private int inven;
	private int count;
	
	// 2. 생성자
	public ProductDTO() {}
	
	public ProductDTO( int seq, String name , int price ) {
		this.seq = seq;
		this.name = name;
		this.price = price;
	}
	
	public ProductDTO(int seq, String name, int price, int inven) {
		this.seq = seq;
		this.name = name;
		this.price = price;
		this.inven = inven;
	}
	
	public ProductDTO(int seq, String name, int price, int inven , int count) {
		this.seq = seq;
		this.name = name;
		this.price = price;
		this.inven = inven;
		this.count = count;
	}

	
	// 3. 메소드
	@Override
	public String toString() {
		return "ProductDTO [seq=" + seq + ", name=" + name + ", price=" + price + ", inven=" + inven + "]";
	}

	
	
	// Getter Setters
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

	public int getInven() {
		return inven;
	}

	public void setInven(int inven) {
		this.inven = inven;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
}
