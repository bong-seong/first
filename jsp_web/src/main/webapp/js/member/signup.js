console.log('signup.js 열림')


// 2. 아이디 유효성검사 [ 1. 문자체크 / 2. 중복검사 ]
function idcheck(){ // onkeyup : 키를 눌렀다 떼었을때 
	console.log( '입력중' );
	// 1. 입력할대마다 입력값 가져오기
	let mid = document.querySelector('.mid').value;
	console.log( mid );	
	// 2. 정규표현식 [ 영문(소문자)+숫자 길이 : 5~30 글자 ]
	let midj = /^[a-z0-9]{5,30}$/
	// 3. 정규표현식 
	console.log( midj.test( mid ) );
	if( midj.test( mid ) ){ // 정규표현식 패턴이 true 이면
		
		// 아이디 중복검사 [ js - > 서블릿 -> dao 에게 해당 아이디가 있는지 검색 ]
		$.ajax({
			url : "/jsp_web/mconfirm",
			method : "get",
			data : { "mid" : mid },			// 입력받은 아이디 보내기
			success : ( r ) => {
				console.log( 'ajax 통신' );
				console.log( r );	// 응결과 [ 있으면 true / 없으면 false ]
				if( r == 'true'){
					document.querySelector('.idcheckconfirm').innerHTML = '사용중인 아이디입니다.';
				} else {
					document.querySelector('.idcheckconfirm').innerHTML = '사용가능한 아이디';
				}
			} // success end 
		}) // ajax end 
		
	} else { // 정규표현식 패턴이 false 이면
		document.querySelector('.idcheckconfirm').innerHTML = '영문(소문자) + 숫자 조합 5~30 글자 사이로 입력해주세요'
	}
}

/*
	JS 정규표현식 : 문자 특정 규칙 , 패턴 , 집합 표현할때 사용되는 언어
		-- 문법
			/^ 		: 정규표현식 시작
			$/ 		: 정규표현식 끝
			[a-z]	: 소문자 a-z 패턴
			[A-Z]	: 대문자 A-Z 패턴
			[0-9]	: 숫자 0~9 패턴
			[가-힣]	: 한글 패턴
			{ 최소길이 , 최대길이 } : 문자열 길이 패턴
			----
			[a-zA-Z] : 영문 입력
			[a-zA-Z0-9] : 영문 + 숫자 입력
			[a-zA-Z0-9가-힣] : 영문 + 숫자 + 숫자 입력
			
		-- 패턴 검사 함수
			정규표현식.test( 데이터 ) : 패턴이 적합하면 true / 아니면 false
			ex)
			/^[a-z]$/.test( qwe ) --> true
			/^[a-z]$/.test( QWE ) --> false
*/


// 1. 회원가입
function signup(){
	
	console.log( 'signup 함수 열림' ); 

	// 1. [ 첨부파일 있을때 ] html file input 직접적으로 조작 불가능
		// 1. form 객체 가져오기
	let signupForm = document.querySelectorAll('.signupForm')[0]; // 첫번째 form 가져오기
		// 2. form 안에 있는 data 객체 호출 [ js api 클래스 = FormData ]
	let signupFormData = new FormData( signupForm );
		console.log( signupFormData );
		
	// 2. [ 첨부파일 있을때 ] ajax 통신을 이용해 서블릿에게 데이터 보내고 응답 받기
	$.ajax({
		url : "/jsp_web/member",
		method : "post",			// 첨부파일 무조건 post
		data : signupFormData,		// FormData 객체 전송
		// 첨부파일 있을때 추가되는 속성
		contentType : false,		// true : 매개변수 형식의 문자열타입 [ 기본값 ]
										// form-urlencoded 형식으로 전송 [ 첨부파일 못보냄 ]
									// false : 해제
										// multipart/form 형식으로 전송
		processData : false,		// 
		succecss : ( r ) => {
			console.log( 'ajax 통신' );
			console.log( r );
			
			if( r == 'true'){
				alert('회원가입성공');
				location.href="/jsp_web/index.jsp"
			}else{
				alert('회원가입실패')
			}
		} // success end
	}) // ajax end 
}

/* 
	// 1. [ 첨부파일 없을때 ] 입력받은 값 모두 가져와서 객체화
	let info = {
		mid : document.querySelector('.mid').value,
		mpwd : document.querySelector('.mpwd').value,
		mpwdconfirm : document.querySelector('.mpwdconfirm').value,
		memail : document.querySelector('.memail').value,
		mimg : document.querySelector('.mimg').value,
	};console.log( info );
	
	$.ajax({
		url : "/jsp_web/member",	// 서블릿 클래스의 @WebServlet("/member")
		method: "post",				// 메소드 선택
		data: info,
		success : ( r ) => {
			console.log('ajax 응답');
			console.log ( r );
			if( r == 'true'){
				alert('회원가입성공');
				location.href="/jsp_web/index.jsp"
			}else{
				alert('회원가입실패')
			}
		}
	});
*/