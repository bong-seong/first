
// 1. keyup 이벤트 : 키보드 키를 눌렀다 때었을때
	// 1. <textarea> 마크업 객체화
const textarea = document.querySelector('textarea')
const h3 = document.querySelector('h3')
	// 2. 해당 마크업의 이벤트 등록 [ 객체명.addEventListener ]
textarea.addEventListener( 'keyup' , ( 이벤트상태 ) => {
	// 3. 해당 마크업 사이에 html 대입 [ 객체명.innerHTML = html 형식의 문자]
	h3.innerHTML = `글자 수 : ${ textarea.value.length }`
	// 4. 키 상태 확인
		console.log( 이벤트상태 )
		console.log( "조합 alt 키 : " + 이벤트상태.altKey )		// 해당 키를 다른 키와 같이 눌러야 확인 가능
		console.log( "조합 ctrl 키 : " + 이벤트상태.ctrlKey )		
		console.log( "조합 shift 키 : " + 이벤트상태.shiftKey )		
		console.log( "code 키 : " + 이벤트상태.code )
		console.log( "name 키 : " + 이벤트상태.key )	
})

	textarea.style.position = 'absolute' // static [작성배치] 기본값 위치불가능
	let x = 0	// x축
	let y = 0 	// y축	// 상위 마크업 시작점 기중
	let block = 50; // 이동단위
	
print(); // 위치 배치 1번 실행
function print(){
	textarea.style.left = `${ x*block }px` // css left = x*이동단위+'px'
	textarea.style.top = `${ y*block }px`  // css top = `${y*이동단위}px`
} 

// 2. keydown 이벤트 : 키보드 키를 입력했을때
document.body.addEventListener( 'keydown' , (e) => {
	if( control ){ // 만약에 control 이 true 경우에만 아래 실행
		console.log(e.keyCode)
		let key = e.keyCode;
		if( key == 37 ){ x--; } 		// left-- 대입 	//왼쪽키
		else if ( key == 38){ y--; } 	// top-- 대입 	// 위쪽키
		else if ( key == 39){ x++; } 	// left++ 대입 	// 오른쪽키
		else if ( key == 40){ y++; } 	// top++ 대입 	// 아래쪽키
		print();
	}
})


let control = true; // * 이벤트 제어 전역 변수 

// 3. 배치 제어하기
document.querySelector('.moving').addEventListener('click', ()=>{
	// 스위치 변경 [ on/off ]
	control = !control
	
})

