console.log('js 열림');


// 1. 로그인
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
			else{ 
				document.querySelector('.idcheckconfirm').innerHTML = "회원정보가 다릅니다." 
			} 
		}
	})
}

// 2. 아이디 찾기
function findid(){
	// 1. 입력받은 이메일 가져오기
	let memail = document.querySelector('.memail').value;
	// 2. ajax로 servlet 에게 보내서 결과 받기
	$.ajax({
		url : "/jsp_web/find",
		method : "get",
		// "type" : 1 아이디찾기 // "type" : 2 비밀번호찾기
		data : { "type" : 1 , "memail" : memail },
		success : ( r ) => {
			console.log("아이디찾기 통신"); console.log( r );
			if( r == 'false' ){
				document.querySelector('.idcheckconfirm').innerHTML = "일치하는 회원정보가 없습니다." 
			}else{
				document.querySelector('.idcheckconfirm').innerHTML = "회원 ID : " + r
			}
			
		}
	})
}


// 3. 비밀번호 찾기
function findpwd(){
	
	console.log('패스워드찾기 열림');
	
	let info = {
		type : "2",
		mid : document.querySelector('.mid').value,
		memail : document.querySelector('.memail').value
	}
	
	console.log( info );
	
	$.ajax({
		url : "/jsp_web/find",
		method : "get",
		// "type" : 1 아이디찾기 // "type" : 2 비밀번호찾기
		data : info,
		success : ( r ) => {
			console.log("비밀번호찾기 통신"); console.log( r );
			if( r == 'false' ){
				document.querySelector('.idcheckconfirm').innerHTML = "일치하는 회원정보가 없습니다."
			}else{
				document.querySelector('.idcheckconfirm').innerHTML = "등록된 이메일주소로 임시비밀번호를 전송하였습니다."
			}
		} // success end 
	}) // ajax enx
} // end 
	










