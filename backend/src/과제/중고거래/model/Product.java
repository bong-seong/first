package 과제.중고거래.model;

public class Product {
	// 1. 필드
	private String pname;
	private String pcontent;
	private int price;
	private Member member;
	
	// 2. 생성자
	public Product() {}
	public Product(String pname, int price, String pcontent, Member member) {
		this.pname = pname;
		this.price = price;
		this.pcontent = pcontent;
		this.member = member;
	}
	
	// 3. 메소드
	@Override
	public String toString() {
		return "Product [pname=" + pname + ", price=" + price + ", pcontent=" + pcontent + ", member=" + member + "]";
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	

}
