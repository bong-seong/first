console.log('js 열림');

function login() {

	console.log('login() 열림');
	
	// 1. 입력받은 값
	let mid = document.querySelector('.mid').value;
	let mpwd = document.querySelector('.mpwd').value;
	
	// 2. 
	$.ajax({
		url : "/jsp_web/login",
		method : "post",
		data : {"mid" : mid , "mpwd" : mpwd },
		success : (r)=>{
			console.log( '통신' );
			console.log( r );
			if( r == 'true' ){ location.href="/jsp_web/index.jsp"; }
			else{ alert('회원정보가 불일치 합니다.') } 
		}
	})
}