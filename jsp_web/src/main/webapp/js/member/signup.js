// * 첨부파일 이미지 미리보기 [ 업로드와 상관 없음 ]
	// 사용자[클라이언트JS]에 운영체제[폴더경로] 접근 불가
function premimg(e){
	
	// 1. JS 파일클래스 선언
	let file = new FileReader(); // 파일 읽기 클래스
	// 2. 해당 첨부된 파일 읽어오기 ( file.readAsDataURL(첨부파일) ) 
	file.readAsDataURL( e.files[0] ) // 해당 파일 읽어오기 / files[0] : 첨부파일 1개
	// 3. 읽어온 파일 꺼내기 바이트
	file.onload = ( e )=>{
		
		// 4. 이미지 태그에 대입
		document.querySelector('.premimg').src = e.target.result;
	}
	
}

// * idcheckconfirm  span 모두 가져오기 --> 여러개의 span이 배열/리스트 객체에 대입
let idcheckconfirm = document.querySelectorAll('.idcheckconfirm');


// 2. 아이디 유효성검사 [ 1. 문자체크 / 2. 중복검사 ]
function idcheck(){ // onkeyup : 키를 눌렀다 떼었을때 
	
	// 1. 입력할대마다 입력값 가져오기
	let mid = document.querySelector('.mid').value;
	
	// 2. 정규표현식 [ 영문(소문자)+숫자 길이 : 5~30 글자 ]
	let midj = /^[a-z0-9]{5,30}$/
	// 3. 정규표현식 
	
	if( midj.test( mid ) ){ // 정규표현식 패턴이 true 이면
		
		// 아이디 중복검사 [ js - > 서블릿 -> dao 에게 해당 아이디가 있는지 검색 ]
		$.ajax({
			url : "/jsp_web/mconfirm",
			method : "get",
			data : { "mid" : mid },			// 입력받은 아이디 보내기
			success : ( r ) => {
				if( r == 'true'){
					idcheckconfirm[0].innerHTML = '사용중인 아이디입니다.';
				} else {
					idcheckconfirm[0].innerHTML = 'O';
				}
			} // success end 
		}) // ajax end 
		
	} else { // 정규표현식 패턴이 false 이면
		idcheckconfirm[0].innerHTML = '영문(소문자) + 숫자 조합 5~30 글자 사이로 입력해주세요'
	}
}



// 3. 비밀번호 유효성 검사
function pwdcheck() {

	// 1. 입력받은 값 가져오기
	let mpwd = document.querySelector('.mpwd').value;
		
	// 2. 정규표현식 : 영대소문자 + 숫자 조합 5~20 글자
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
	
	// 3. 제어
	if( mpwdj.test( mpwd ) ){
		idcheckconfirm[1].innerHTML = 'O'; pwdconfirmcheck();
	}else{
		idcheckconfirm[1].innerHTML = '영대소문자+숫자 조합 5~20 글자'
	}
}


// 4. 비밀번호 확인 유효성 검사
function pwdconfirmcheck() {
	let mpwd = document.querySelector('.mpwd').value;
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value;
	// 2. 정규표현식 : 영대소문자 + 숫자 조합 5~20 글자
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
	//
	if( mpwdj.test( mpwdconfirm ) ){
		if( mpwd != mpwdconfirm ){ // 두 비밀번호간의 동일성 체크 [ 두 비밀번호가 서로 다르면 ]
			idcheckconfirm[1].innerHTML = "두 비밀번호가 일치하지 않습니다.";
		}else{ // 같으면
			idcheckconfirm[1].innerHTML = "O";
		}
	}else{
		idcheckconfirm[1].innerHTML = '영대소문자+숫자 조합 5~20 글자'
	}
}


// 5. 이메일 유효성 검사
function emailcheck() {	
	
	let memail = document.querySelector('.memail').value;
	
	let memailj = /^[a-zA-z0-9_-]+@[a-zA-z0-9-]+\.[a-zA-Z0-9-]+$/
				  
	if( memailj.test( memail ) ){
		idcheckconfirm[2].innerHTML = "O";
	}else{
		idcheckconfirm[2].innerHTML = "이메일 형식으로 입력 ( @ ) 포함";
	}
		
}	
		// 아이디 구역
		// [a-zA-Z0-9] 		: 영문 + 숫자
		// [a-zA-z0-9_-] 	: 영문 + 숫자 + _ + -  ksbthyls
		// +@				: 아이디와 도메인 사이의 @	@
		// 도메인 구역
		// [a-zA-Z0-9-]		: 영문 + 숫자 + -		naver
		// +\.				: 도메인 중간에 . 		.
		// [a-zA-Z0-9-]		: 영문 + 숫자 + -		com
		// + 				: .					.co.kr

// 1. 회원가입
function signup(){
	// * 유효성검사에 대한 체크
	let count = 0;
	for( let i=0; i<idcheckconfirm.length; i++ ){
		if( idcheckconfirm[i].innerHTML == 'O' ){
			count++;
		}
	}
	if( count != 3 ){ alert('정상적으로 입력되지 않은 데이터가 있습니다.'); return; }
	
	
	console.log( 'signup 함수 열림');
	// 1. [ 첨부파일 있을때 ] html file input 직접적으로 조작 불가능
		// 1. form 객체 가져오기
	let signupForm = document.querySelectorAll('.signupForm')[0]; // 첫번째 form 가져오기
		// 2. form 안에 있는 data 객체 호출 [ js api 클래스 = FormData ]
	let signupFormData = new FormData( signupForm );
	
	// 2. [ 첨부파일 있을때 ] ajax 통신을 이용해 서블릿에게 데이터 보내고 응답 받기
	$.ajax({
		url : "/jsp_web/member",
		method : "post",			// 첨부파일 무조건 post
		data : signupFormData,		// FormData 객체 전송
		// 첨부파일 있을때 추가되는 속성
		contentType : false,		
		processData : false,	
		success : (r)=>{
			console.log("가입 응답 : " +  r );
			if( r == 'true' ){
				alert('회원가입성공');
				location.href="/jsp_web/index.jsp";
			}else{
				alert('회원가입실패')
			}
		} // success end
	}) // ajax end 
	console.log( 'signup 함수 끝');
}

// true : 매개변수 형식의 문자열타입 [ 기본값 ]
// form-urlencoded 형식으로 전송 [ 첨부파일 못보냄 ]
// false : 해제
// multipart/form 형식으로 전송

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
			+ : 앞에 있는 패턴 1개 이상 반복
			? : 앞에 있는 패턴 0개 혹은 1개 이상 반복
			* : 앞에 있는 패턴 0개 반복
			
			자바 " --> \"
			\ : 이스케이프 문자
			
			----
			[a-zA-Z] : 영문 입력
			[a-zA-Z0-9] : 영문 + 숫자 입력
			[a-zA-Z0-9가-힣] : 영문 + 숫자 + 숫자 입력
			----
			1개 이상 문자가 포함되어야 하는 경우
				(?=.*[ 패턴문자 ]) : 해당 패턴문자가 한개 이상 입력
			(?=.*[a-z]) : 소문자 한개 이상 입력
			(?=.*[A-Z]) : 대문자 한개 이상 입력
			(?=.*[!@#$%^&*]) : 해당 하는 특수문자 한개 이상 입력
			----
			/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
			
			1. (?=.*[A-Za-z])				: 영대소문자 한개 이상 입력
			2. (?=.*\d) vs (?=.*[0-9])		: 숫자 한개 이상 입력
			3. [A-Za-z\d] vs [A-Za-z0-9] 	: 영문 + 숫자
			--> 영문1개 + 숫자1개 필수를 갖는 5~20 글자 사이 
			
		-- 패턴 검사 함수
			정규표현식.test( 데이터 ) : 패턴이 적합하면 true / 아니면 false
			ex)
			/^[a-z]$/.test( qwe ) --> true
			/^[a-z]$/.test( QWE ) --> false
			
			/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{5,20}$/
			--> 영대문자1개 + 영소문자1개 + 숫자1개 + 특정특수문자 1개 필수로 갖는 5~20 글자 사이
*/


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