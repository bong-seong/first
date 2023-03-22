console.log( 'chatting.js 실행' );

/*

	소켓 : 두 프로그램간의 양방향 통신 종착점 [ 도착지 ]
	서버소켓 : [JAVA] 서버가 가지고 있는 소켓
	클라이언트소켓 : [JS] 클라이언트가 가지고 있는 소켓 [ 각 클라이언트 마다 ]
	
	
	카카오톡유저									카카오톡 본사 / 서버실
	클라이언트									서버
	new WebSocket(서버소켓URL)					@ServerEndpoint("/서버소켓URL")
		1. 클라이언트소켓.onopen() 	<---연결--->	@OnOpen
		2. 클라이언트소켓.send()	  	---보내기--->	@OnMessage
		3. 클라이언트소켓.onmessage	<---보내기---	세션명.getBasicRemote().sendText()
		4. 						<--연결끊기--> @OnClose
	
	JS WebSocket	HTTP 
		1. JS 에서 제공하는 클래스 new WebSocket
		2. 소켓 객체 만들기
			let clientsoket = new WebSocket('ws://serversocket URL');
		3. 소켓이 서버소켓과 연동
			1. WebSocket 생성자에서 해당 서버소켓의 경로 확인 통신
	JAVA serverSocket
		1. 임의의 클래스 생성
		2. 서버소켓 만들기
			클래스 위에 @ServerEndpoint("ws://ip:포트번호/프로젝트명/서버소켓경로URL")
			- @ServerEndpoint 	: 서버 소켓의 URL 만들기
			- @WebServlet		: HTTP 의 URL 만들기
		3. 클라이언트소켓이 서버소켓[엔드포인트] 으로 접속했을때
			@OnOpen : 클라이언트소켓이 접속했을때 매핑[연결] 
*/

let contentbox = document.querySelector('.contentbox')
let clientsocket = null


if( memberInfo.mid == null ){ // memberInfo : 헤더js 존재하는 객체
		alert('로그인 후 이용 가능한 서비스입니다.'); location.href='/jsp_web/member/login.jsp'
}else{
	// 1. 클라이언트소켓 생성과 서버소켓 연결[open]
	clientsocket = new WebSocket('ws://localhost:8080/jsp_web/chatting/'+memberInfo.mid );
	// clientsocket = new WebSocket('ws://localhost:8080/jsp_web/chatting/아이디/채팅방pk' );
	console.log( clientsocket );
	clientsocket.onopen = function( e ){ onopen(e) ;}	// 클라이언트소켓 객체에 정의한 함수 대입
	clientsocket.onmessage = function( e ){ clientRecv(e) ;}
	clientsocket.onclose = function( e ){ clientClose( e ); }
}


// 2. 클라이언트소켓이 접속했을때 이벤트/함수 정의
function onopen( e ){ 
	contentbox.innerHTML += `
							<div class="alarm">
								<span> 채팅방 입장하셨습니다. </span>
							</div>` 
} 	// 접속했을때 하고싶은 함수 정의


// 3. 클라이언트소켓이 서버에게 메시지를 보내기 [ @OnMessage ]
function clientSend(){
	
	let msgbox = document.querySelector('.msgbox').value;
	// ** 메시지 전송하기
	clientsocket.send( msgbox ); // ---> @OnMessage
	
	// 전송 성공시 채팅 입력창 초기화
	document.querySelector('.msgbox').value = '';
}

// 4. 서버로부터 메시지가 왔을때 메시지 받기
function clientRecv( e ){ // <------ e <------ getBasicRemote().sendText(msg)
	console.log( e );
	console.log( e.data ); // e.data : 문자열타입 vs JSON.parse( e.data ) : 객체 타입
	console.log( JSON.parse(e.data) ); // 문자열 json -> 객체json 형변환
	
	let data = JSON.parse( e.data ); // 전달받은 메시지 dto
	
	// 보낸사람과 현재 유저가 일치하면 [ 내가 보낸 메시지 ]
	if( data.frommid == memberInfo.mid ){
		contentbox.innerHTML += `<div class="sendcontent">
									<div class="date"> ${ data.time } </div>
									<div class="content"> ${data.msg } </div>
								</div>`;
	}else{ // 내가 받은 메시지
		contentbox.innerHTML += `<div class="recvcontent">
									<div> <img src="/jsp_web/member/mimg/${ data.frommimg == null ? 'default.png' : data.frommimg }" class="hpimg"></div>
									<div class="rcontent">
										<div class="name"> ${ data.frommid } </div>
										<div class="contentdate">
											<div class="content"> ${data.msg } </div>
											<div class="date"> ${ data.time } </div>
										</div>
									</div>
								</div>`;
	}
	// ---------------------------- 스트롤 최하단으로 내리기 ----------------------------- //
		
	contentbox.scrollTop = contentbox.scrollHeight
	
}


// 5. 서버와 연결이 끊겼을때 [ 클라이언트소켓 객체가 초기화될때 -> F5 , 페이지 전환할때 등등 ]
function clientClose( e ){
	console.log('연결해제');
}


/*
	클라이언트소켓 필드								서버소켓
		onopen 		=
		onclose		=
		
		// 통신 결과
		클라이언트소켓.onclose = function(e){ console.log('연결해제') }
			vs
		클라이언트소켓.onclose = (e) => { console.log('연결해제') }
			vs
		function 함수명( e ){ console.log('연결해제') }
		클라이언트소켓.onclose = (e)=>{ 함수명(e) }
	
	AJAX 필드({
		// 통신 결과
		success : function(r){ }
		success : (r)=>{ }
	})
*/


// 6. 엔터키를 눌렀을때
function enterkey(){
	// 만약에 입력한 키코드가 13[엔터]이면 메시지 전송
	console.log( window.event.keyCode );
	if( window.event.keyCode == 13 ){
		clientSend();
	}
}


/*
let keyCode = null;
let textarea = document.querySelector('.msgbox');

 textarea.addEventListener("keyup", function (event) {
  if (event.keyCode === 13) {
    event.preventDefault();
    document.querySelector('.sendbtn').click();
  }
});
*/







