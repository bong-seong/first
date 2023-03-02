alert('js파일 열림');

// JS 함수
// function 함수명( 매개변수 ){ 실행코드 }

function 예제1(){

	let data = document.querySelector('.inputdata').value;
	console.log( data );
	
	$.ajax({
		url : "jspweb/Indextest", 		// 통신할 서블릿 주소
		method : "get", 	// HTTP 메소드
		data : { "data" : data },		// 데이터 보내기 
		success : function( result ){
			console.log( result );
		} // 데이터 받기 
	});
	
	// JS --> 서블릿 이동
	// 0. $ : jquery 표현식 [ jquery 라이브러리 필요 ]
	// 1. ajax 메소드 사용 : $.ajax();
	// 2. ajax 매개변수 [ 속성 : 객체형대 ] : { } --> $.ajax({ })
	// 3. 속성
		// 1. url : 통신할 경로[ 서블릿(클래스) 주소 : /프로젝트명/(패키지)클레스명 ]
			/*
				url : "http://localhost:8080/jspweb/Indextest"
				url : "http://192.168.17.???:8080/jspweb/Indextest"
				url : "/jspweb/Indextest"
			*/
		
		// 2. method : http 메소드방식
			/*
				get
				post
			*/
		// 3. data : 통신할때 데이터 보내기
			/*
				js객체 형태 : { 매개변수명1 : 데이터 , 매개변수명2 : 데이터 }
			*/
		// 4. success : 통신후 응답 데이터 받기
			/*
				1. success : 함수명( 매개변수 ){ }
				2. success : ( 매개변수 ) => { }
			*/
	/*
		$.ajax({ 
			url : "" , 
			method : "" , 
			data : { 매개변수명 : 데이터 } , 
			success : function( result ){
				
			} 
		});
	*/
}



	// document : 미리 만들어진 DOM 객체
		// 1. querySelector( 식별자 ) : -> 변수/객체에 저장 
			// 1. document.querySelector('.class') 
			// 2. document.querySelector('#id')
			// 3. document.querySelector('tag[name="name"]')
		// 2. querySelectorAll( 식별자 ) : tag 여러개 -> 배열/리스트에 저장
		
		// 1. querySelector.속성명
			// 1. querySelector().value : input , select , textarea [ div X , table X ]
			// 2. querySelector().innerHTML : div , span , td 등등  

















