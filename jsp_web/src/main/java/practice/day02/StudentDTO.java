package practice.day02;

public class StudentDTO {

	// 1. 필드
	private String name;
	private String phone;
	private double height;
	private int age;
	private String reg_date;
	private String gender;
	private boolean agreed;
	private String area;
	private String about_me;
	

	// 2. 생성자
	public StudentDTO() {}


	public StudentDTO(String name, String phone, double height, int age, String reg_date, String gender, boolean agreed,
			String area, String about_me) {
		this.name = name;
		this.phone = phone;
		this.height = height;
		this.age = age;
		this.reg_date = reg_date;
		this.gender = gender;
		this.agreed = agreed;
		this.area = area;
		this.about_me = about_me;
	}

	// 3. 메소드
	
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


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getReg_date() {
		return reg_date;
	}


	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public boolean isAgreed() {
		return agreed;
	}


	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getAbout_me() {
		return about_me;
	}


	public void setAbout_me(String about_me) {
		this.about_me = about_me;
	}
	
	
	
	
	
}
