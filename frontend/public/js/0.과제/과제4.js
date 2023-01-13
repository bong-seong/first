let 도서목록 = [ '혼자공부하는자바', '이것이자바다', '열혈 C언어' ]
let 대여목록 = [ '혼자공부하는자바' ]


// 김성봉
function addBook(){
	
	let newBook = document.querySelector('.bookName').value
	
	if( newBook.length < 5 ){
		alert('5 ~ 10 글자 사이의 도서명을 입력하세요.')
		return;
	}
	else if( newBook.length > 10 ){ 
		alert('5 ~ 10 글자 사이의 도서명을 입력하세요.')
		return;
	}
	
	if( 도서목록.indexOf(newBook) == -1 ){
		도서목록.push ( newBook )
	}else{
		alert('중복된 도서명입니다.')
		return;
	}
	console.log( 도서목록 )
	console.log( 대여목록 )
	bookListPrint()
	customerList()
}


// 김성봉
function delBook(i){
	for( value of 도서목록 ){
		if( 대여목록.includes( 도서목록[i] ) == true ){
			alert( '대여중인 도서는 삭제가 불가능힙니다.')
			return; 
		}
	}
	
	도서목록.splice( i, 1 )
	
	bookListPrint()
	customerList()
}



// 김성봉
function bookListPrint(){
	
	let adminTable = `<tr>
						<th> 번호 </th>
						<th> 도서명 </th>
						<th> 도서대여 여부 </th>
						<th> 도서 삭제 </th>
					  </tr>`

	for( i=0 ; i<도서목록.length ; i++ ){
			
			if( 대여목록.includes( 도서목록[i] ) == true ){
				adminTable +=
				`<tr>
					<td> ${i+1} </td> 
					<td> ${도서목록[i]} </td>
					<td class="on"> 대여중 </td>
					<td> <button onclick="delBook( ${i} )"> 삭제 </button> </td>
				 </tr>`
			}else{
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

bookListPrint()

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



