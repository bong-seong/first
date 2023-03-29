package controller.admin;

import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.dao.MemberDao;
import model.dto.ClientDto;

@ServerEndpoint("/alarm/{mid}")
public class Alarm {
	
	private static ArrayList<ClientDto> connectList = new ArrayList<>();
	
	@OnOpen // 클라이언트 소켓이 들어왔을때
	public void enterServer( Session session , @PathParam("mid") String mid ) {
		connectList.add( new ClientDto( session, mid ) );
	}
	
	@OnClose // 클라이언트 소켓이 나갔을때
	public void leaveServer( Session session ) {
		for( ClientDto c : connectList ) {
			if( c.getSession() == session ) {
				connectList.remove( c );
			}
		}
	}
	
	@OnError // 클라이언트 소켓에 에러가 발생했을때 !!! 필수로 정의할 인수
	public void errorServer( Session session , Throwable t ) {
		System.out.println( t );
	}
	
	@OnMessage // 클라이언트 소켓이 메시지를 보냈을때 매핑[연결] !!! 필수로 정의할 인수
	public static void sendMessage( Session session , String msg ) throws Exception {
		
		// 메시지를 받는 회원번호 
		int tomno = Integer.parseInt( msg.split(",")[0] );
		
		// 메시지 내용  
		String tomsg = msg.split(",")[1]; 
		
		for( ClientDto c : connectList ) {
			
			int cmno = MemberDao.getInstance().getMember( c.getMid() ).getMno();
			if( cmno == tomno ) { // 받는 회원번호가 명단에 존재하면
				c.getSession().getBasicRemote().sendText( tomsg );
			}
		}
	}
}

/*
	Session session : 요청한 클라이언트 소켓의 변수
	Throwable t : 에러 발생시 에러이유가 저징된 변수
	String msg : 요청받은 메시지 내용

	서버소켓
		1. @ServerEndpoint("서버소켓경로/{매개변수명1}/{매개변수명2}")
		2. @OnOpen		필수 매개변수 : Session session
		3. @OnClose		필수 매개변수 : Session session
		4. @OnError		필수 매개변수 : Session session , Throwable t
		5. @OnMessage	필수 매개변수 : Session session , String msg( payload )
		6. @PathParam("경로상의 {매개변수명}")		: 경로상의 변수 요청 

*/

