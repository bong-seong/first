
// 1. 인수X 반환X 함수
function 함수1(){ // function START
	// function : 함수 선언시 사용되는 키워드
		// 함수1	: 함수이름[식별자] 동일한 파일 내에서는 중복이름 불가능
			// ( ) : 인수를 정의하는 곳
				// { } : 함수가 호출되면 실행 되는 구역
	alert('함수1 실행 됨')
} // function END

// 1. 함수 호출
함수1()


// 2. 인수O 반환O 함수
function 함수2( x, y ){ // function START
	// ( x, y ) : 해당 함수를 호출시 인수[x, y : 이름 아무거나 ] 2개를 받는 함수
    alert('함수2 실행 됨')
    return x+y ;
} // function END
let result = 함수2( 3, 5 ) // 반환[return] 값을 변수에 저장
alert( '함수2 실행 후 보내준 값: ' + result )


// 3. 인수O 반환X 함수
function 함수3( x, y, z ){
	let result= x + y + z
	alert( '함수3 실행 됨 : ' + result)
}
함수3( 3, 5, 7 )


// 4. 인수X 반환O 함수
function 함수4(){
	let result = 3 + 5 + 8
	return result ;
}
let result2 = 함수4()
alert( '함수4 실행 후 보내준 값 : ' + result2 )










