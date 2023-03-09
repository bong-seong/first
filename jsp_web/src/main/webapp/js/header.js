console.log('header js 열림');

getLogin();
function getLogin(){
	$.ajax({
		url : "/jsp_web/login",
		method : "get",
		data : "get",
		success : (r)=>{
			console.log( '통신' );
			console.log( r ); // Dto --> r 객체 회원
			
			let html = ''; // 1. html 구성
			
			if ( r == null ){ // 2. 로그인 안했으면
				
				html += `<a href="/jsp_web/member/signup.jsp"> 회원가입 </a>`
				html += `<a href="/jsp_web/member/login.jsp"> 로그인 </a>`
				
			} else{ // 3. 로그인 했으면
				
				if( r == 'admin' ){
					
					html += `<a href="/jsp_web/admin/info.jsp"> 관리자페이지 </a>`
				}
				
				html += `<img src="/jsp_web/member/mimg/${r.mimg == null ? 'default.png' : r.mimg }" class="hpimg" >`
				html += `${r.mid}님 안녕하세요`
				html += `<a href="/jsp_web/member/logout.jsp"> 로그아웃 </a>`
				
			}
			console.log( html )
			document.querySelector('.header').innerHTML = html ;
		}
	
	})
}