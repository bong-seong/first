package model.dto;

import javax.websocket.Session;

public class ClientDto {
	
	// 1. 필드
	private Session session;
	private String mid; 
	
	
	// 2. 생성자
	public ClientDto() {
		// TODO Auto-generated constructor stub
	}

	public ClientDto(Session session, String mid) {
		super();
		this.session = session;
		this.mid = mid;
	}
	
	
	// 3. 메소드
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "ClientDto [session=" + session + ", mid=" + mid + "]";
	}
	
	
}
