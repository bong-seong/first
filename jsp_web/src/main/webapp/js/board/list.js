console.log( 'list.js 실행');

getBoardList();
function getBoardList(){
	console.log( 'getBoardList() 실행' );
	
	$.ajax({
		url : "/jsp_web/board/info",
		method : "get",
		data : { "type" : 1 }, // 1: 전체출력 , 2: 개별출력
		success : ( r ) => {
			console.log( 'getBoardList 통신' ); console.log( r );
			
			let html = `<tr>
							<th width="5%">번호</th>
							<th width="45%">제목</th>
							<th width="9%">작성자</th>
							<th width="20%%">작성일</th>
							<th width="7%">조회수</th>
							<th width="7%">좋아요</th>
							<th width="7%">싫어요</th>
						</tr>`
			
			r.forEach( (o,i) => {
				
				html += `<tr>
							<td> ${ o.bno }</td>
							<td> 
								<a href="/jsp_web/board/view.jsp?bno=${o.bno}">${ o.btitle }</a>
							</td>
							<td> ${ o.mid }</td>
							<td> ${ o.bdate }</td>
							<td> ${ o.bview }</td>
							<td> ${ o.bup }</td>
							<td> ${ o.bdown }</td>
						</tr>`
				
			}) // forEach end
			
			document.querySelector('.boardTable').innerHTML = html ;
			 
		} // success end 
		
	}) // ajax end 
	
} // function end 

/*
	- 클릭한 pk[식별자] 이용하는 경우의 수
		1. HTTP get 메소드 방식의 a태그 이용한 pk 이동
		<a href="/jsp_web/board/view.jsp">
		---> 추가 a태그에 변수 넘기기
		<a href="/jsp_web/board/view.jsp?변수명=데이터">
		<a href="/jsp_web/board/view.jsp?변수명=데이터&변수명=데이터">
		<a href="/jsp_web/board/view.jsp?bno=${o.bno}">
		
*/





