
// alert( 'JS 실행합니다.' )		// 1번 실행 

// * 함수 밖에 만든 이유 : 함수가 실행될때마다 선언하면 기존데이터가 초기화되기때문에 배열이 성립 X
let 학생리스트 = [] 		// 배열선언, 초기 요소 없다 [] (깡통)

// 1. 추가 버튼을 눌렀을때 이벤트  

function onAdd(){ // 함수 시작
	// 1. function : 함수 정의 키워드
	// 2. onAdd : 함수명[ 아무거나 ]
	// 3. ( )	: 인수 [ 함수 실행시 함수안으로 전달받은 데이터 ]
	// 4. { }	: 함수가 실행 되는 구역
	// alert( "클릭했습니다." )	
	
	// 2. 입력받은 input value[ 값 ] 을 가져오기 
	let sname = document.querySelector ('.sname')
		//sname 변수에 input 마크업 저장
		// * HTML 마크업을 변수화 하기 = DOM
			// let HTML변수명 = document.querySelector ('.sname')  HTML 에서 class 가져오기
			// let HTML변수명 = document.querySelector ('#sname')  HTML 에서 id 가져오기
	// 값 가져오기 (확인용) 
	// alert( sname.value )
		// 마크업의 속성
			// HTML변수명.value : 해당 마크업의
	// 3. 마크업에서 값 가져와서 배열에 담기 [ 학생리스트에 <input class="sname"> 마크업의 value 값 저장 ]
	학생리스트.push( sname.value )
	// 출력 테스트
	// console.log( 학생리스트 )
	// 4. 마크업에 출력
		// 1. slist 변수에 <ul> 마크업 저장
	let slist = document.querySelector('#slist')
	
	slist.innerHTML = '<li>' + 학생리스트 + '</li>'
	
} // 함수 끝


// * 클릭시 배열내 요소를 삭제하는 리스트 
function onDelete(){
	// 1. 입력받은 데이터를 가져온다. [ <input class="sname"> 에 입력된 데이터 가져오기[DOM 객체] ]
	let sname = document.querySelector('.sname')
	// 2. <input> 입력된 value[값] 가져오기
	let dname = sname.value
	// 3. 배열내 값으로 요소 인덱스 찾기
	let dindex = 학생리스트.indexOf( dname ); 	// 입력받은 이름의 인덱스 찾기
	// 4. 배열내 해당 인덱스의 요소 제거
	학생리스트.splice( dindex , 1 );
	
	// [출력부]
	// 1. <ul> 가져와서 변수에 저장 [ DOM 객체 ]
	let slist = document.querySelector('#slist')
	// 2. <ul> innerHTML 이용한 <ul> { 여기에 데이터 넣기 } </ul>
	slist.innerHTML = '<li>' + 학생리스트 + '</li>'
}












