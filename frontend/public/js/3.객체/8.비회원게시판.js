console.log('1. js 열림')

// * 함수 밖에 만드는 이유 : 전역변수 ==> 모든 함수에서 동일한 메모리 사용
let contents = []
onprint()

	// 이벤트함수
		// 1. <button type="button" onclick="onwrite()"> 글 등록 </button>
		// 2. <button type="button" class="onwritebtn"> 글 등록 </button>
			// document.querySelector('.onwritebtn').addEventListener( 'click', (e)=>{ } )

		

// 1. 글 등록 함수 
function onwrite(){ // 1. 글 등록 버튼을 눌렀을때
	
	console.log('2. onwrite 함수 작동 테스트')
	
	// 1. 입력받은 4개 데이터를 하나의 객체 선언 
	let info = { // let 객체명(아무거나) = { 속성명:데이터 ,속성명:데이터 ,속성명:데이터 }
		bwriter:document.querySelector('.bwriter').value,
		bpassword: document.querySelector('.bpassword').value,
		btitle: document.querySelector('.btitle').value,
		bcontent: document.querySelector('.bcontent').value,
		bdate : new Date(), // 현재 날짜/시간 표기
		bview: 0
	}
	console.log( info ) // 객체 정보 출력시 문자열 연결연산자 금지
	
	// 2. 유효성검사 // 객체명.속성명
		// 1. 입력받은 데이터 길이 체크
	if( info.bwriter.length <= 0 || info.bpassword.length <= 0 || 
		info.btitle.length <= 0 || info.bcontent.length <= 0 ){
		alert('빈칸을 작성해 주세요')
		return ; // 함수 종료 ... 해당 함수에서 아래로 진행 불가능
	}
	
	// 3. 배열에 저장 *추후 : 백엔드에게 통신해서 데이터 전달 [ 벡엔드 : java, db ]
	contents.push( info )
	alert( '글 등록 성공' )
	onprint()
	console.log( contents )
	
	// 4. 초기화
	document.querySelector('.bwriter').value = ''
	document.querySelector('.bpassword').value = ''
	document.querySelector('.btitle').value = ''
	document.querySelector('.bcontent').value = ''
	
}

// 2. 
function onprint(){ // 1. js 열렸을때 / 2. 글 등록했을때 / 3. 글 삭제 / 4. 글 수정 ( 렌더링 )
	console.log('onprint 열림')
	// 1. 기본 html 구성
	let html = `<tr>
					<th> 번호 </th> <th> 제목 </th> <th> 작성자 </th> <th> 작성일 </th> <th> 조회수 </th>				
				</tr>`
	// 2. 내용 html 구성
	for( let i=0 ; i<contents.length ; i++ ){
		
		let date = contents[i].bdate.getFullYear() + '-' + 
				   (contents[i].bdate.getMonth()+ 1) + '-' +
				   contents[i].bdate.getDate() + ' ' +
				   contents[i].bdate.getHours() + ':' +
				   contents[i].bdate.getMinutes() + ':' +
				   contents[i].bdate.getSeconds()
		
		html += `<tr onclick="onview( ${i} )">
					<td> ${ i+1 } </td> 
					<td> ${ contents[i].btitle } </td> 
					<td> ${ contents[i].bwriter } </td>
					<td> ${ date } </td>
					<td> ${ contents[i].bview } </td>
				</tr>`
	}
	// 3. 마크업에 html 대입
	document.querySelector('.boardtable').innerHTML = html 
}

// 3. 글 보기 함수 [ 조회수 증가 ]
function onview( i ){ // 1. 글 목록에서 해당 행을 클릭했을때
	contents[i].bview += 1;
	onprint()
	console.log( i )
	let html = `<div> 제목 : ${ contents[i].btitle }</div>
			    <div> 내용 : ${ contents[i].bcontent }</div>
			    <div> 작성자 : ${ contents[i].bwriter } </div>
			    <div> <button type="button" onclick="ondelete( ${i} )"> 삭제 </button> </div>`
			   
	document.querySelector('.viewbox').innerHTML = html 
}


// 4. 글 삭제
function ondelete( i ){
	
	let password = prompt( '비밀번호를 입력하세요')
	
	if ( password == contents[i].bpassword ){
		alert('삭제성공')
		contents.splice( i , 1 )
		document.querySelector('.viewbox').innerHTML = ''
		onprint()
	}else{
		alert('삭제실패')
	}
}















