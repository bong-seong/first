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
							<a href="#"> ${r.mpoint} point </a>`
				}
			}
			
			document.querySelector('.submenu').innerHTML = html ;
		}
	
	})
}