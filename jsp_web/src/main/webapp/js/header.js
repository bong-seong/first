console.log('header js 열림');

let memberInfo = null;

getLogin();
function getLogin(){
	$.ajax({
		url : "/jsp_web/login",
		async : false, // <----- 동기화 변경
		method : "get",
		data : "get",
		success : (r)=>{
			console.log( r );
			memberInfo = r ; // <---- 응답 결과를 전역변수 옮기기 [ 왜?? 다른 함수에서 쓸려고 ]
			let html = ``; // 1. html 구성
			
			if ( r.mid == null ){ // 2. 로그인 안했으면
				
				html += `<a href="/jsp_web/member/signup.jsp"> 회원가입 </a>`
				html += `<a href="/jsp_web/member/login.jsp"> 로그인 </a>`
				
			} else{ // 3. 로그인 했으면

				if( r.mid == 'admin' ){
					html += `<div class="dropdown">
								<button class="hpimgbtn" type="button" data-bs-toggle="dropdown">
									<img class="hpimg" src="/jsp_web/member/mimg/${r.mimg == null ? 'default.png' : r.mimg }">
								</button>
								<ul class="dropdown-menu"> <!-- 드롭다운시 표기되는 구역 -->
									<li> <a href="/jsp_web/admin/info.jsp" class="dropdown-item"> 관리자페이지 </a> </li>
									<li> <a href="/jsp_web/member/logout.jsp" class="dropdown-item"> 로그아웃 </a> </li>
								</ul>
							</div>
							${r.mid}님`
			
				}else{
					
					html += `<div class="dropdown">
								<button class="hpimgbtn" type="button" data-bs-toggle="dropdown">
									<img class="hpimg" src="/jsp_web/member/mimg/${r.mimg == null ? 'default.png' : r.mimg }">
								</button>
								<ul class="dropdown-menu"> <!-- 드롭다운시 표기되는 구역 -->
									<li> <a href="/jsp_web/member/info.jsp" class="dropdown-item"> 내프로필 </a> </li>
									<li> <a href="#" class="dropdown-item"> 친구목록 </a> </li>
									<li> <a href="/jsp_web/member/logout.jsp" class="dropdown-item"> 로그아웃 </a> </li>
								</ul>
							</div>
							${r.mid}님
							<a href="#"> 쪽지함 </a>
							<a href="/jsp_web/member/point.jsp"> ${r.mpoint} point </a>`
				}
			}
			
			document.querySelector('.submenu').innerHTML = html ;
		}
	
	})
} // end

let alarmSocket = null;

if( memberInfo.mid == null ){
	
}else{
	// JS 실행주체 = 클라이언트 // JAVA = 서버
	// 1. JS : 클라이언트소켓 생성
	alarmSocket = new WebSocket('ws://localhost:8080/jsp_web/alarm/'+memberInfo.mid )
	// 2. 클라이언트 소켓내 이벤트 메소드 대입
	alarmSocket.onopen = ( e ) => { console.log('알림용 서버소켓에 들어옴') }
	alarmSocket.onclose = ( e ) => { console.log('알림용 서버소켓에서 나감') }
	alarmSocket.onerror = ( e ) => { console.log('알림용 서버소켓 오류') }
	alarmSocket.onmessage = ( e ) => { onalarm(e) }
}
//
function onalarm(e){
	
	let msgbox = document.querySelector('.msgbox');
	
	msgbox.style.bottom = "50px";
	
	// * 4초 후에 이벤트 실행
	// n초 후에 이벤트 실행 : setTimeout( ()=>{} , 밀리초 )
	// n초 마다 이벤트 실행 : setInterval( ()=>{} , 밀리초 )
	
	setTimeout( ()=>{ msgbox.style.bottom = "-100px"; } , 4000 )
	
	// 여러명이 채팅 요청하면 Dao 메소드 충돌 발생
		// Dao 메소드에 synchronized
		// 스레드1 해당 메소드를 사용하고 있을때 [ return 전 ] 다른 스레드2 해당 메소드에 대기상태
		// 멀티스레드 : Http
	getcontent();
	
}












