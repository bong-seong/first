/* DB */
/*let contents = [ // 일정 목록
	{ date : '20230101', content : '집에서 쉬기'},
	{ date : '20230103', content : '집에서 게임하기'},
	{ date : '20230101', content : '집에서 넷플릭스보기'}
]*/

let contents = []


/* ------------------ 전역변수 : 모든 함수{ } 공용으로 사용되는 메모리 [변수] --------------- */
// 1. js 열렸을때 현재 연도와 월을 구해서 변수에 저장 
let year = new Date().getFullYear();  // 기본값 : 현재 연도  // 이전/다음 버튼에 따른 변경 
let month = new Date().getMonth()+1 ; // 기본값 : 현재 월    // 이전/다음 버튼에 따른 변경 


// 2. 캘린더 상단에 표시[ 1. js 열렸을때 2. 이전/다음 버튼 클릭할때마다 ]
cal_print()
function cal_print(){
	// 1. 상단에 월/일 표시
	document.querySelector('.top_date').innerHTML = `${year}년 ${month}월`;

	
	
	// 3. html 구성
	let html = `<div class="day weekday sunday"> 일 </div> <div class="day weekday"> 월 </div>
				<div class="day weekday"> 화 </div> <div class="day weekday"> 수 </div>
				<div class="day weekday"> 목 </div> <div class="day weekday"> 금 </div>
				<div class="day weekday"> 토 </div>`
	
	// 2. 현재 설정된 날짜의 마지막 일의 날짜 객체 만들기
	let lastday = new Date( year, month , 0 ).getDate(); //console.log( '현재 캘린더 마지막 일 : ' + lastday )
	
	// * 2. 시작 요일 구하기
	let weekday = new Date( year, month-1, 1 ).getDay(); //console.log( '현재 캘린더 시작일 요일 : ' +  weekday )
						
	// * 2. 시작 요일 전에 공백 만들기
	for( let b=1 ; b<=weekday ; b++ ){
		html += `<div class="day"></div>`
	}
				
	// * 1. 일 만들기 [ 1 ~ 마지막 일[ new Date( year, month , 0 ).getDate ] 까지 ]
	for( let day=1 ; day<=lastday; day++ ){
		
		// 4. 날짜 확인
		let date = date_formet( new Date( year , month-1 , day ) )  
		// console.log( date ) 
		
		html += `<div class="day" onclick="openModal( ${date} )"> 
					${ day } ${ contents_print( date ) } 
				</div>`
	}
	
				
	// 4. html 마크업 출력 
	document.querySelector('.cal_day').innerHTML = html;
} 





// 8. 등록 버튼 눌렀을때 함수
document.querySelector('.modal_write').addEventListener( 'click' , (e)=>{
	// 1. 입력받은 내용과 선택된 날짜 가져와서 객체화
	let content = { 
		date: document.querySelector('.modal_date').innerHTML,
		content: document.querySelector('.modal_input').value,
		bg_color: document.querySelector('.modal_color').value
	}; console.log( content )
	// 2. 유효성검사 생략
	// 3. 배열 저장
	contents.push( content );
	// 4. 화면 업데이트
		// 1. 입력된 데이터 초기화
		document.querySelector('.modal_input').value = ''
		// 2. 모달 닫기
		document.querySelector('.modal_wrap').style.display='none'
		// 3. 캘린더 재출력
		cal_print();
})


// 7. 모달 닫기 함수
document.querySelector('.modal_close').addEventListener('click', (e)=>{
	document.querySelector('.modal_wrap').style.display='none'
})

// 6. 모달 열기 함수
function openModal( date ){
	// 1. 모달 배경 구역 css 변경해서 모달 보이기 
	document.querySelector('.modal_wrap').style.display='flex'
	// 2. 모달에 선택된 날짜 표시하기 
	document.querySelector('.modal_date').innerHTML = date
	// 3. 해당 하는 날짜의 모든 일정 출력
	schedule_print()
	
}

function schedule_print(){
	
	// 모달 열렸을때 현재 등록되어진 일정목록 출력
		// 1. html 구성 
	html = `<tr>
				<th width="5%"> # </th> <th> 일정내용 </th> <th width="20%"> 비고 </th>
			</tr>`
			
	let date = document.querySelector('.modal_date').innerHTML
		// 2. 반복문 활용하여 등록된 일정 체크 후 출력
	let j = 0; // j : 동일한 일정의 일정[객체]들의 개수 
	 contents.forEach( (o , i)=>{ // i : 일정 객체들의 인덱스 순서
		 
		 if( date == o.date ){ // 만약에 모달 클릭시 선택된 날짜와 일정목록에 있는 날짜와 같으면
		 	j++; 
			html += `<tr>
						<td> ${ j } </td> 
						<td> ${ o.content } </td> 
						<td> <button type="button" onclick="onDel(${ i })"> 삭제 </button> </td>
					 </tr>`
		 }
	 })
	 document.querySelector('.table').innerHTML = html
} 


function onDel( i ){
	contents.splice( i , 1 )
	document.querySelector('.modal_wrap').style.display='none'
	cal_print()
}


// 5. 일정 출력 함수
function contents_print( date ){
	// 1. 인수로 전달된 날짜와 동일한 일정 날짜 찾기
		//1. html
		let html = ``
	contents.forEach( (o)=>{ // 일정목록 반복문
		
		if( date == o.date ){ // 만약에 인수로 전달된 날짜와 일정목록에서 동일한 날짜가 존재하면
			html += `<div class="content" style="background-color: ${ o.bg_color }">${ o.content }</div>`
		}
		
	}) // for end 
	return html ;
}



// 3. 이전달 다음달 버튼클릭 이벤트에 따른 연도,월 변경
document.querySelector('.previousbtn').addEventListener( 'click', (e)=>{
	
	month--;	// 1. 월 1차감 했을경우 만약에 0이면 연도 1차감 후 월 12로 설정
	if( month < 1 ){ year--; month = 12 }
	cal_print();
})

document.querySelector('.nextbtn').addEventListener( 'click', (e)=>{
	
	month++; // 1. '월' 1증가 중 만약에 12보다 크면 '연도' 1 증가 '월' 다시 1 설정 
	if( month > 12 ){ year++; month = 1 }
	cal_print()
})  


// 4. 날짜 포맷 함수 [ 인수: 날짜 -----로직[포멧]------> 반환: 변경된 날짜 형식]
function date_formet( date ){
	
	let d_year = date.getFullYear();
		// 만약에 월/요일이 한자리수(<=9)이면 앞에 0 붙이기
	let d_month = (date.getMonth()+1) <= 9 ? '0'+ (date.getMonth()+1) : (date.getMonth()+1) ;
	let d_date =  date.getDate() <=9 ? '0' + date.getDate() : date.getDate()
	return `${d_year}${d_month}${d_date}`
}



/*
	new Date() 날짜/시간 관련된 클래스
	1. let date = new Date() 					: 현재 날짜/시간 객체
	2. let date = new Date( 2023, 01 , 31 ) 	: 사용자정의 날짜/시간 객체
	3. let date = new Date( 연도 , 월 , 0 )		: 연도와 월 날짜에 따른 마지막 일 
  		1. get 함수 제공
  			1. date.getFullYear()	: 연도
  			2. date.getMonth()		: 월 [ 0~11 0:1월 ~ 11:12월 / 그렇기때문에 +1 사용이 통상적 ]
  			3. date.getDate()		: 일
  			4. date.getDay()		: 요일 [ 0 ~ 6 0:일요일 ~ 6: 토요일 ]
 
let date = new Date(); console.log( 'date : ' + date )
let date2 = new Date( 2020, 1, 31 ); console.log( 'date2 : ' + date2 )
console.log ( '연도 : ' + date.getFullYear() )
console.log ( '월 : ' + date.getMonth() )
console.log ( '일 : ' + date.getDate() )
console.log ( '요일 : ' + date.getDay() )


	`백틱 
		${ } 안의 구역은 수식, 함수 등 js 구문 작성 가능함 


*/