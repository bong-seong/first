package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.Session;

import controller.admin.Chatting;
import model.dao.MemberDao;

public class MessageDto {
	
	// 1. 필드
	private String frommid;		// 메시지 보낸사람
	private String frommimg;	// 메시지 보낸사람의 프로필이미지 
	private String msg;			// 메시지 내용
	private String time;		// 보낸시간
	// private String roompk;
	
	
	// 2. 생성자
	public MessageDto() {
		// TODO Auto-generated constructor stub
	}
	
	// 클라이언트에게 메시지 전송할때 사용하는 생성자
	public MessageDto(Session session, String msg ) {
		
		this.msg = msg;
		
		// 메시지를 보낸 클라이언트 세션을 통해서 회원아이디 얻기
		for( ClientDto dto : Chatting.clientSessions ) {
			if( dto.getSession() == session ) {
				this.frommid = dto.getMid();
				// 보낸사람의 프로필 얻기
				this.frommimg = MemberDao.getInstance().getMember( this.frommid ).getMimg();
				/*
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
				this.time = sdf.format( date );
				*/
				this.time = new SimpleDateFormat("aa HH:mm").format( new Date() );
			}
		}
	}
	
	
	// 3. 필드
	
	public String getFrommid() {
		return frommid;
	}

	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}

	public String getFrommimg() {
		return frommimg;
	}

	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "MessageDto [frommid=" + frommid + ", frommimg=" + frommimg + ", msg=" + msg
				+ ", time=" + time + "]";
	}
}
