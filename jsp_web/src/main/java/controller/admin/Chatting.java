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
	public void OnOpen( Session session , @PathParam("mid") String mid  ) throws Exception {
		
		// 접속한 클라이언트소켓들을 보관 
		clientSessions.add( new ClientDto( session , mid ) );
		System.out.println( clientSessions );
		
		// 연결된 클라이언트 소켓을 모든 접속자 명단에게 알리기
		onMessage(session, "enter");
	
	}
	
	
	@OnClose	// 클라이언트소켓이 나갔을때 
	public void onClose( Session session ) throws Exception {
		
		System.out.println("클라이언트 웹소켓이 나갔습니다.");
		// 접속이 끊긴 세션의 dto 찾아서 제외
		for( ClientDto dto : clientSessions ) {
			if( dto.getSession() == session ) {
				clientSessions.remove( dto );
				
				// 연결이 끊긴 클라이언트 소켓의 모든 접속명단에게 알림메시지 보내기
				// 1. 문자열 타입의 JSON 형식 직접 작성하기 [ vs ObjectMapper ]
					// { "필드명" : "데이터" , "필드명" : "데이터" }
					// { \"필드명\" : \"데이터\" , \"필드명\" : \"데이터\" }
				String msg = " {\"type\":\"alram\",\"msgbox\":\""+ dto.getMid()+"님이 채팅방에서 나갔습니다.\"} ";
				onMessage(session, msg);
				// 연결이 끊긴 클라이언트 소켓의 모든 접속명단 목록 알림 메시지 보내기
				onMessage(session, "enter");
				break;
			}
		}
	}
	
	
	// 클라이언트 소켓이 메시지를 보냈을때 [ 서버가 메시지 받기 ]
	@OnMessage // [ Session [누가] , String[내용물] ] 
	public void onMessage( Session session , String msg ) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		
		// 2. 접속명단 알림
		if( msg.equals("enter") ) {
			// 회원명단[ 이미지, 아이디 ] 포함된 회원리스트 생성
			ArrayList< MessageDto > list = new ArrayList<>();
			for( ClientDto dto : clientSessions ) {
				list.add( new MessageDto( dto.getSession() , null ) ); // 현재 접속된 회원정보 객체 생성
			}
			json = mapper.writeValueAsString( list ); // 접속자 명단 객체 여러개 
			
		}else { // 1. 메시지
			
			MessageDto messageDto = new MessageDto(session, msg);
			json = mapper.writeValueAsString( messageDto ); // 메시지 보낸 정보 객체1개
			
		}
		
		// ** 서버가 클라이언트 소켓에게 메시지를 보내기
		// 현재 서버소켓과 연결된 클라이언트소켓 모두에게 서버가 받은 내용물 전달
		for( ClientDto dto : clientSessions ) {
											// json 형식[모양]의 타입은 문자열로 전송됨
											// String a = "10"; 숫자형식[모양]의 타입은 문자열
			dto.getSession().getBasicRemote().sendText( json ); // ---> 클라이언트소켓.onmessage
		}
	}
}
