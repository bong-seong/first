let 도서목록 = [ '혼자공부하는자바', '이것이자바다', '열혈 C언어' ]
let 대여목록 = [ '혼자공부하는자바' ]


// 김성봉 - 관리자 페이지 도서목록 html 에 출력하는 함수
function bookListPrint(){
	
	// 테이블 데이터를 중첩 / 출력 하기 위한 함수 선언 ( 초기 테이블의 header 값 )
	let adminTable = `<tr>							
						<th> 번호 </th>
						<th> 도서명 </th>
						<th> 도서대여 여부 </th>
						<th> 도서 삭제 </th>
					  </tr>`

	for( i=0 ; i<도서목록.length ; i++ ){ // for 반복문을 사용하여 adminTable 에 데이터 중첩 
			
			// if 제어문을 통한 대여여부 판단, 도서목록 배열 활용
			// 대여목록.includes( 도서목록[i] ) ? '대여중' : '대여가능'
			if( 대여목록.includes( 도서목록[i] ) == true ){ // 대여목록을 도서목록[i] 만큼 includes 하여 ture 중복일경우 
				adminTable +=						   // 아래의 값을 중첩
				`<tr>
					<td> ${i+1} </td> 
					<td> ${도서목록[i]} </td>
					<td class="on"> 대여중 </td>
					<td> <button onclick="delBook( ${i} )"> 삭제 </button> </td>
				 </tr>` // !!**** 대여목록.includes( 도서목록[i] ) ? '대여중' : '대여가능' 삼항연산자를 활용하면 코드가 짧아짐 ****!!
			}else{									   // false 중복이 아닌경우 아래의 값을 중첩
				adminTable +=
				`<tr>
					<td> ${i+1} </td> 
					<td> ${도서목록[i]} </td>
					<td class="off"> 대여가능 </td>
					<td> <button onclick="delBook( ${i} )"> 삭제 </button> </td>
				 </tr>`
			}
		
		
		document.querySelector('.bookList').innerHTML = adminTable ;
		document.querySelector('.bookName').value = ''
	}	
}



// 김성봉 - 도서명 작성 후 입력 버튼을 눌렀을때 실행 함수
function addBook(){ 
	
	let newBook = document.querySelector('.bookName').value
	// 변수 선언 및 쿼리셀렉터로 class="bookName" (input 입력내용) 가져와 값을 저장
	
	// 유효성 체크 [1] - 5~10 글자 사이의 입력값만 가능 그외 리턴
	if( newBook.length < 5 ){ 					// value 값을 받은 newBook 변수 길이 체크하여 5글자 미만일 경우 
		alert('5 ~ 10 글자 사이의 도서명을 입력하세요.') //아래의 alert 실행 
		return;									// 이후 return 하여 아래의 구문이 실행되지 못하게함
	}
	else if( newBook.length > 10 ){ 			// value 값을 받은 newBook 변수 길이 체크하여 10글자 이상일 경우
		alert('5 ~ 10 글자 사이의 도서명을 입력하세요.') // alert 실행
		return; 								// 이후 return 하여 아래의 구문이 실행되지 못하게함
	}
	
	// 유효성 체크 [2] - 도서 중복 등록 불가능
	if( 도서목록.indexOf(newBook) == -1 ){ // 도서목록 배열에 indexOf 를 사용해 newBook 을 값으로 받음 
		도서목록.push ( newBook )			// 도서목록에 입력한 newBook 과 일치하는것이 있을 경우 0~ 이후 숫자를 반환
	}else{								// 동일 도서가 없을 경우 -1 반환 따라서, -1 일경우 도서목록 배열에 push
		alert('중복된 도서명입니다.')		    // else 에는 alert 출력 후 return
		return;
	}
	
	bookListPrint()						// 도서목록 배열이 갱신 된 후 다시 도서현황을 보여주기 위함 ( 관리자측 )
	customerList()						// 도서목록 배열이 갱신 된 후 다시 도서현황을 보여주기 위함 ( 이용자측 )
}




// 김성봉 - 등록된 도서를 삭제하는 함수 [ 버튼 ]
function delBook(i){
	
	// 유효성 검사 ( 삭제하려는 도서가 대여중인지 확인 )
	for( value of 도서목록 ){ // 도서목록의 배열길이만큼 반복 
		if( 대여목록.includes( 도서목록[i] ) == true ){
			alert( '대여중인 도서는 삭제가 불가능힙니다.')
			return; 
		}
	}
	
	도서목록.splice( i, 1 )
	
	bookListPrint()						// 도서목록 배열이 갱신 된 후 다시 도서현황을 보여주기 위함 ( 관리자측 )
	customerList()						// 도서목록 배열이 갱신 된 후 다시 도서현황을 보여주기 위함 ( 이용자측 )
}


bookListPrint()							// 상시로 도서목록을 보여주기 위한 함수 호출


// ########################################################################################## //


function bookRental(i){
	for( value of 도서목록 ){
		if ( 대여목록.includes( 도서목록[i] ) == true ){
			alert('대여중인 도서입니다.')
			return;
		}
	}
	대여목록.push( 도서목록[i] )
	bookListPrint()
	customerList()
	
}



function bookReturn(i){
	for( value of 도서목록 ){
		if ( 대여목록.includes( 도서목록[i] ) == false ){
			alert('대여하지 않은 도서입니다.')
			return;
		}
	}
	
	대여목록.splice( 대여목록.indexOf(도서목록[i]) , 1 )
	bookListPrint()
	customerList()
}



function customerList(){
	
	let cusTable = `<tr>
						<th> 번호 </th>
						<th> 도서명 </th>
						<th> 도서대여 여부 </th>
						<th> 비고 </th>
					  </tr>`

	for( i=0 ; i<도서목록.length ; i++ ){
			
			if( 대여목록.includes( 도서목록[i] ) == true ){
				cusTable +=
				`<tr>
					<td> ${i+1} </td> 
					<td> ${도서목록[i]} </td>
					<td class="on"> 대여중 </td>
					<td> <button onclick="bookRental(${i})"> 대여 </button> / <button onclick="bookReturn(${i})"> 반납 </button> </td>
				 </tr>`
			}else{
				cusTable +=
				`<tr>
					<td> ${i+1} </td> 
					<td> ${도서목록[i]} </td>
					<td class="off"> 대여가능 </td>
					<td> <button onclick="bookRental(${i})"> 대여 </button> / <button onclick="bookReturn(${i})"> 반납 </button> </td>
				 </tr>`
		}
		
		document.querySelector('.cusList').innerHTML = cusTable ;
	}	
}


customerList()



