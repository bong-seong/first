package controller;

public class Dto {

	private String v_jumin;
	private String v_name;
	private String v_time;
	private String v_area;
	private String v_confirm;
	private String m_no ;
	private String m_name ;
	private String p_code;
	private String p_school;
	private String m_jumin ;
	private String m_city ;
	private String p_name;
	private String p_indate;
	private String p_reader ;
	private String p_tel1 ;
	private String p_tel2 ;
	private String p_tel3 ;
	
	private String v_confirm_count;
	
	public Dto() {}

	public Dto(String m_no, String m_name, String p_name , String p_school, String m_jumin, String m_city,  String p_tel1,
			String p_tel2, String p_tel3) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.p_name = p_name;
		this.p_school = p_school;
		this.m_jumin = m_jumin;
		this.m_city = m_city;
		this.p_tel1 = p_tel1;
		this.p_tel2 = p_tel2;
		this.p_tel3 = p_tel3;
	}
	

	public Dto(String v_jumin, String v_name, String v_time, String v_area, String v_confirm, String m_no) {
		super();
		this.v_jumin = v_jumin;
		this.v_name = v_name;
		this.v_time = v_time;
		this.v_area = v_area;
		this.v_confirm = v_confirm;
		this.m_no = m_no;
	}
	
	public Dto(String v_jumin, String v_name, String m_no , String v_time,  String v_confirm ) {
		super();
		this.v_jumin = v_jumin;
		this.v_name = v_name;
		this.m_no = m_no;
		this.v_time = v_time;
		this.v_confirm = v_confirm;		
	}
	

	public Dto(String m_no, String m_name , String v_confirm_count ) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.v_confirm_count = v_confirm_count;
	}

	public String getV_jumin() {
		return v_jumin;
	}

	public void setV_jumin(String v_jumin) {
		this.v_jumin = v_jumin;
	}

	public String getV_name() {
		return v_name;
	}

	public void setV_name(String v_name) {
		this.v_name = v_name;
	}

	public String getV_time() {
		return v_time;
	}

	public void setV_time(String v_time) {
		this.v_time = v_time;
	}

	public String getV_area() {
		return v_area;
	}

	public void setV_area(String v_area) {
		this.v_area = v_area;
	}

	public String getV_confirm() {
		return v_confirm;
	}

	public void setV_confirm(String v_confirm) {
		this.v_confirm = v_confirm;
	}

	public String getM_no() {
		return m_no;
	}

	public void setM_no(String m_no) {
		this.m_no = m_no;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_school() {
		return p_school;
	}

	public void setP_school(String p_school) {
		this.p_school = p_school;
	}

	public String getM_jumin() {
		return m_jumin;
	}

	public void setM_jumin(String m_jumin) {
		this.m_jumin = m_jumin;
	}

	public String getM_city() {
		return m_city;
	}

	public void setM_city(String m_city) {
		this.m_city = m_city;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_indate() {
		return p_indate;
	}

	public void setP_indate(String p_indate) {
		this.p_indate = p_indate;
	}

	public String getP_reader() {
		return p_reader;
	}

	public void setP_reader(String p_reader) {
		this.p_reader = p_reader;
	}

	public String getP_tel1() {
		return p_tel1;
	}

	public void setP_tel1(String p_tel1) {
		this.p_tel1 = p_tel1;
	}

	public String getP_tel2() {
		return p_tel2;
	}

	public void setP_tel2(String p_tel2) {
		this.p_tel2 = p_tel2;
	}

	public String getP_tel3() {
		return p_tel3;
	}

	public void setP_tel3(String p_tel3) {
		this.p_tel3 = p_tel3;
	}

	public String getV_confirm_count() {
		return v_confirm_count;
	}

	public void setV_confirm_count(String v_confirm_count) {
		this.v_confirm_count = v_confirm_count;
	}
	
	
	
	
}
