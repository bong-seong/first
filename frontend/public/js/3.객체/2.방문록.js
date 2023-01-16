console.log( '1.js 실행' )

// * 배열선언 [ board 객체 여러개를 저장하는 배열 / 함수 밖에 있는 이유 : 누적 저장 ]
let boardArray = [ ]

// 1. 작성 버튼 클릭 시 실행되는 함수
function 작성(){
	console.log( '2.함수실행' )
	
	// 1. 입력받은 데이터 가져오기
	let 작성자 = document.querySelector('.작성자').value
		console.log( '3.작성자 : ' + 작성자 )
	let 내용 = document.querySelector('.내용').value 
		console.log( '3.내용 : ' + 내용 )
	let 비밀번호 = document.querySelector('.비밀번호').value
		
	// 2. 입력받은 2개의 데이터를 하나로 객체화
	let board = { writer : 작성자 , content : 내용 , password: 비밀번호 }
		console.log( board )
		
	// 3. 객체를 배열에 저장 [ 여러개 객체를 저장 ]
	boardArray.push( board )
		console.log( boardArray )
	
	출력() 
		
}


function 삭제(i){
	// 1. [ 비밀번호 검증 ] 비밀번호를 입력받는디.
	let 비밀번호 = prompt('패스워드를 입력하세요')
	
	// 2. 입력받은 비밀번호와 내가 선택한 게시물의 비밀번호가 같으면 삭제
	if ( boardArray[i].password == 비밀번호 ){
		boardArray.splice( i , 1 ) // i 번째 인덱스 [객체] 삭제
		alert('정상처리되었습니다.')
		출력()
	}else{
		alert('삭제실패')
	}
}



function 수정(i){
	// 1. 비밀번호검증
	let 비밀번호 = prompt('패스워드를 입력하세요')
	
	// 2. 입력받은 비밀번호와 선택한 게시물의 비밀번호가 같으면 내용수정
	if ( boardArray[i].password == 비밀번호 ){ // 입력받은 패스워드와 기존 배열 내 객체의 password 속성 값과 같으면
		// 3. 새로운 수정할 내용 입력받아
		let 수정내용 = prompt( '수정 내용을 입력해주세요.' )
		// 4. 선택한 게시물의 속성의 값 수정 
		boardArray[i].content = 수정내용
		alert( '수정 성공' )
		// 5. 화면 새로고침 [ 업데이트 ]
		출력()
	}else{
		alert( '패스워드가 일치하지 않습니다.[ 수정실패 ]' )
	}
}

// boardArray : 배열
// boardArray[i] : 배열 내 i번째 요소 ==> 객체 1개
// boardArray[i].password : 배열 내 i번째 요소인 객체의 password 속성



function 출력(){ // 3. 게시물 출력함수 [1. 작성 성공시 2.삭제 성공시 ]
	// 4. 배열 내 객체 출력
		// 1. 테이블의 제목행 만들기 
	let html = `<tr>
					<th> 번호 </th>
					<th> 내용 </th>
					<th> 작성자 </th>
					<th> 비고 </th>
			   </tr>`
			   
		// 2. 반복복문 이용한 배열 내 모든 요소 행 만들기[누적]
			// 1. 반복 이용해서 배열내 객체 하나씩 호출	: boardArray[i]
			// 2. 객체 내 속성 호출				 	: boardArray[i].속성명
	for( let i=0 ; i<boardArray.length ; i++ ){
		html += `<tr>
					<td> ${i+1} </td>
					<td> ${ boardArray[i].content } </td>
					<td> ${ boardArray[i].writer } </td>
					<td> 
						<button onclick="삭제(${i})" type="button"> 삭제 </button>
						<button onclick="수정(${i})" type="button"> 수정 </button> 
					</td>
			    </tr>`
	}
	
		// 3. 반복문 종료시 누적된 html 해당 table 출력
		document.querySelector('.게시물테이블').innerHTML = html
}
























