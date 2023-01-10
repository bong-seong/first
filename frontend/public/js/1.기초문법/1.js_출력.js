/*
	크롬 [브라우저] 개발자도구 F12
		console
			입/출력 가능한 구역
*/

//
//
//	Js : 
//		1. 주석	  	[ 범위 + Ctrl + Shift + / ]
//			//    	: 한줄주석
//			/*	*/	: 여러줄 주석

/*
		2. 출력
			1. console.log()	: 콘솔에 출력하는 함수 [ 테스트용도 ]
				- js코드 ----> 브라우저의 개발자도구 console 출력
			2. alert()			: 알림 메시지를 출력
			3. document.write() : html에 출력
			
		3. 제어문자 [ 이스케이프 문자 ]
			 - 백슬래시 ( 엔터 위에 원화기호 ) : \
			 1. \n : 줄바꿈 
			 2. \t : 들여쓰기
		     3. \\ : \					 
			 4. \' : '
			 5. \" : "
				
			
				키워드 : 미리 만들어진 단어들 [ 명령어 ] 
				데이터 : 
					1. 문자 : '200' / "200"
					2. 숫자 : 200
					3. 논리 : ture, false
			
*/

// 1. 출력 [ console.log( 출력할 데이터/값 ) ]
console.log('Hello World!') 	// ' ' 안에 있는 데이터는 문자처리
//console.log(Hellow World)   	// 문자처리 생략시 오류 발생
console.log("Hello World!")		// " " 안에 있는 데이터는 문자처리
console.log ( 100 ) 			// 숫자는 문자처리 안함
console.log ( "100" ) 			// 숫자에 문자처리 하면 문자로 출력
console.log( true )				// 논리는 문자처리 안함
		
		
// 2. 출력 [ alert( 출력할 데이터/값 ) ]
alert('Hello World!')
alert('Hello World!2')
alert( 200+200 )
alert( true )


// 3. 제어문자
console.log('안녕하세요\nJs 처음입니다.')		// 줄 바꿈
console.log('안녕하세요\tJs 처음입니다.')		// 들여쓰기 ( tab )
console.log('안녕하세요\\Js 처음입니다.')
console.log('안녕하세요\'Js 처음입니다.\'')
console.log('안녕하세요\"Js 처음입니다.\"')
























