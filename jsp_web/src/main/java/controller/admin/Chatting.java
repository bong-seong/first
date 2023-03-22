package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.*;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClientDto;
import model.dto.MemberDto;
import model.dto.MessageDto;

// URL 매개변수받을때 : /경로/{매개변수1}/{매개변수2}			--> @PathParam("경로상의매개변수명") 타입 변수명
				/*
				 	회원아이디 qweqwe 일때 가정
				 	/jsp_web/chatting/qweqwe
				 	/jsp_web/chatting/{ mid }
				 	@PathParam("mid") String 매개변수;
				 	매개변수 = qweqwe
				 */
// URL 매개변수받을때 : /경로?매개변수명 = 데이터&매개변수명2=데이터	--> request.getParameter("매개변수명");

//해당 클래스를 서버소켓[ 종착점 ] 만들기 // URL : /경로/{매개변수1}/{매개변수2}
@ServerEndpoint("/chatting/{mid}")
public class Chatting {

	// 클라이언트 소켓이 접속했을때의 실행되는 메소드 / 함수
	
	// ** 접속한 클라이언트명단 [ 목록 ] ( 클라이언트소켓 여러개 저장 )
	public static ArrayList< ClientDto > clientSessions = new ArrayList<>();
	
	
	@OnOpen		// session[ 접속한 클라이언트소켓 객체 ] // 서버 엔드포인트의 URL 매개변수[ @PathParam ] 가져오기 
	public void OnOpen( Session session , @PathParam("mid") String mid  ) {
		
		// 접속한 클라이언트소켓들을 보관 
		clientSessions.add( new ClientDto( session , mid ) );
		System.out.println( clientSessions );
	}
	
	
	@OnClose	// 클라이언트소켓이 나갔을때 
	public void onClose( Session session ) {
		
		System.out.println("클라이언트 웹소켓이 나갔습니다.");
		// 접속이 끊긴 세션의 dto 찾아서 제외
		for( ClientDto dto : clientSessions ) {
			if( dto.getSession() == session ) {
				clientSessions.remove( dto );
			}
		}
		
	}
	
	
	// 클라이언트 소켓이 메시지를 보냈을때 [ 서버가 메시지 받기 ]
	@OnMessage // [ Session [누가] , String[내용물] ] 
	public void onMessage( Session session , String msg ) throws Exception {
		
		MessageDto messageDto = new MessageDto(session, msg);
			System.out.println( messageDto.toString() );
			
		// 메시지 받는 프로그램 [JS] : JSON 으로 형변환 // Session 객체를 json 형식 변환 불가능
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString( messageDto );
			System.out.println( json.toString() );
		
		// String json2 = new ObjectMapper().writeValueAsString( new MessageDto( session , msg ) );
		
		System.out.println("클라이언트 웹소켓이 메시지를 보냈다. [ 서버가 메시지를 받았다. ]");
		System.out.println( msg );
		// ** 서버가 클라이언트 소켓에게 메시지를 보내기
		// 현재 서버소켓과 연결된 클라이언트소켓 모두에게 서버가 받은 내용물 전달
		for( ClientDto dto : clientSessions ) {
											// json 형식[모양]의 타입은 문자열로 전송됨
												// String a = "10"; 숫자형식[모양]의 타입은 문자열
			dto.getSession().getBasicRemote().sendText( json ); // ---> 클라이언트소켓.onmessage
		}
		
	}
	
}
