package 과제.중고거래.model;

import java.util.ArrayList;

public class Member {

	// 1. 필드
	private String id;
	private String pw;
	private String name;
	private String phone;
	private ArrayList<Product> product ;
	private ArrayList<Memo> sendmemo;
	private ArrayList<Memo> recvmemo;
	
	
	// 2. 선택자
	public Member() {}
	public Member(String id, String pw, String name, String phone, ArrayList<Product> product, ArrayList<Memo> sendmemo,
			ArrayList<Memo> recvmemo) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.product = product;
		this.sendmemo = sendmemo;
		this.recvmemo = recvmemo;
	}
	
	// 3. 메소드
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", product=" + product
				+ ", sendmemo=" + sendmemo + ", recvmemo=" + recvmemo + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ArrayList<Product> getProduct() {
		return product;
	}
	public void setProduct(ArrayList<Product> product) {
		this.product = product;
	}
	public ArrayList<Memo> getSendmemo() {
		return sendmemo;
	}
	public void setSendmemo(ArrayList<Memo> sendmemo) {
		this.sendmemo = sendmemo;
	}
	public ArrayList<Memo> getRecvmemo() {
		return recvmemo;
	}
	public void setRecvmemo(ArrayList<Memo> recvmemo) {
		this.recvmemo = recvmemo;
	}

}
