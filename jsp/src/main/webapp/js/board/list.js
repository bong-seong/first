
// 1. DB -> JAVA -> JS 통신


boardPrint( null, null ); // 1. js 시작될때 함수실행
// 1. 게시물 출력 함수 
	// 인수 :  	1. 페이지가 처음 js 열렸을때[조건x : keyword=null , key=null ]   
	//		 	2. 검색되었을때[조건o : keyword=입력받은값 , key=입력받은값 ]
	//			3. 페이지전환되었을때
function boardPrint( keyword , key ){
	// 1. JAVA[백엔드]로 부터 데이터 요청  // ~ 추후
		
	if( keyword == null && key == null){ // 1. 검색이 없는 경우
		// alert('검색이 없는 게시물 출력')
		// JAVA에게 검색[조건]이 없는 게시물들을 요청 
	}else{ // 2. 검색이 있는 경우
		// alert('검색이 있는 게시물 출력')
		// JAVA에게 keyword , key 보내서 검색[조건]이 있는 게시물들을 요청 
	}
	console.log( keyword ); console.log( key );
		
		 
	// [ 백엔드로부터 요청된 결과 ] 2. DB -> JAVA 으로 전달된 게시물 리스트 데이터
	let boardlist = [
	   { no : 5 , title : '안녕하세요A' , writer : '유재석' , date : '2023-01-30' , view:325 , up : 9 , down : 1  } , 
	   { no : 4 , title : '안녕하세요B 안녕하세요B안녕하세요B안녕하세요B안녕하세요B안녕하세요B안녕하세요B안녕하세요B안녕하세요B안녕하세요B안녕하세요B' , writer : '강호동', date : '2023-01-27' , view:123 , up : 2 , down : 0  } , 
	   { no : 3 , title : '안녕하세요C' , writer : '신동엽' , date : '2023-01-25' , view:753 , up : 3 , down : 0  } , 
	   { no : 2 , title : '안녕하세요D' , writer : '서장훈' , date : '2023-01-24' , view:521 , up : 10 , down : 3  } , 
	   { no : 1 , title : '안녕하세요E' , writer : '김희철' , date : '2023-01-23' , view:951 , up : 21 , down : 4 } 
	]
		
	// 2. 출력
	let html = ''
	
	for( let i=0 ; i<boardlist.length ; i++ ){
		
		html += `<tr>
					<td> ${ boardlist[i].no } </td> 
					<td> <a href="view.html"> ${ boardlist[i].title } </a> </td> 
					<td> ${ boardlist[i].writer } </td> 
					<td> ${ boardlist[i].date } </td>
					<td> ${ boardlist[i].view } </td> 
					<td> ${ boardlist[i].up } </td> 
					<td> ${ boardlist[i].down } </td>
				</tr>`
	}
	
	document.querySelector('.tbody').innerHTML = html
}
// 2. 검색 버튼을 클릭했을때 키워드와 검색어 가져오기
document.querySelector('.searbtn').addEventListener( 'click' , (e)=>{
	console.log('검색 클릭')
	// 1. 키워드
	let keyword = document.querySelector('.keyword').value 
	
	// 2. 검색어
	let key = document.querySelector('.key').value
	console.log('keyword : ' + keyword ); console.log('key : ' + key )
	
	// 3. 유효성 검사 생략
	// 4. 게이물출력 함수에게 키워드,검색어 전달 [ JAVA (백엔드) ]
	boardPrint( keyword , key )
})


/* 
	배열 반복문
	for( let i=0 ; i<배열명.length ; i++ ){}
	배열명.forEach( () => {} )
*/














