console.log( 'list.js 실행');


// * pageObject : 현재 페이지 , 검색 , 타입 보관된 객체
let pageObject = {
	page : 1,
	key : "",
	keyword : "",
	type : 1, // 1: 전체출력 / 2: 개별출력
	cno : document.querySelector('.cno').value, // 카테고리 번호
	listsize : 3
}

// -- 카테고리 제목 넣어주기
let cnameHTML = '';
if( pageObject.cno == 1 ){ cnameHTML = '공지사항'; }
if( pageObject.cno == 2 ){ cnameHTML = '커뮤니티'; }
if( pageObject.cno == 3 ){ cnameHTML = 'QnA'; }
if( pageObject.cno == 4 ){ cnameHTML = '노하우'; }

document.querySelector('.cname').innerHTML = cnameHTML;


// 1. 게시물 호출
getBoardList(1);
function getBoardList( page ){
	console.log( 'getBoardList() 실행' );
	
	// 해당 함수로부터 페이징 번호 받기 = page
	console.log( '해당 페이지 : ' + page );
	
	pageObject.page = page; // 인수로 받은 현재페이지를 객체에 대입
	console.log( pageObject );
	
	$.ajax({
		url : "/jsp_web/board/info",
		method : "get",
		data : pageObject, // 1: 전체출력 , 2: 개별출력 / page : 표시할 페이지 번호
		success : ( r ) => {
			console.log( 'getBoardList 통신' ); console.log( r );
			
			
			// ------------------------- 테이블 출력 -------------------------- //
			let html = `<tr>
							<th width="5%">번호</th>
							<th width="45%">제목</th>
							<th width="9%">작성자</th>
							<th width="20%%">작성일</th>
							<th width="7%">조회수</th>
							<th width="7%">좋아요</th>
							<th width="7%">싫어요</th>
						</tr>`
			
			r.boardList.forEach( (o,i) => {
				
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
			// --------------------------페이징 버튼 출력 -------------------------- //
			
			
			html = ''; // 기존에 들어있던 내용 제거
			html += `<button type="button" onclick="getBoardList(${ 1 })"> << </button>`
			// 이전 [ 만약에 이전페이지가 1혹은 1 이하 이면 이전페이지 없음 ]
			html += page <= 1 ? 
					`<button type="button" onclick="getBoardList(${ page })"> < </button>`
					: `<button type="button" onclick="getBoardList(${ page-1 })"> < </button>` 
					
			// 페이징 번호 버튼 들
			for ( let i=r.startbtn; i<=r.endbtn; i++ ){ // 시작버튼번호부터 마지막버튼번호까지 버튼 생성
				
				html += `<button type="button" onclick="getBoardList(${ i })"> ${ i } </button>`
			}
			
			// 다음 [ 만약에 현재 페이지가 총 페이지수 이상이면 다음페이지 없음 ]
			html += page >= r.totalpage ?
					`<button type="button" onclick="getBoardList(${ page })"> > </button>`
					: `<button type="button" onclick="getBoardList(${ page+1 })"> > </button>`
			
			html += `<button type="button" onclick="getBoardList(${ r.totalpage })"> >> </button>`
			
			document.querySelector('.pagebox').innerHTML = html; 
			// --------------------------------- 게시물수 출력 --------------------------//
			document.querySelector('.searchcount').innerHTML = `게시물 수 : ${ r.totalsize }`
			 
		} // success end 
		
	}) // ajax end 
	
} // function end 


// 2. 검색
function getsearch() {
	
	console.log( 'onsearch() 실행' );
	
	// * 입력받은 데이터를 전역객체 내 필드에 대입
	pageObject.key = document.querySelector('.key').value
	pageObject.keyword = document.querySelector('.keyword').value
	// * 게시물리스트 호출
	getBoardList(1);
	
}

// 3. 전체보기
function allboard(){
	console.log( 'allboard() 실행' );
	pageObject.key = ''; 		// 검색 없애기 
	pageObject.keyword = ''; 	// 검색없애기
	getBoardList(1);			// 재호출
}

// 4. 
function setListsize(){
	console.log( 'setListsize() 실행');
	let listsize = document.querySelector('.listsize').value;
	console.log ( listsize );
	pageObject.listsize = listsize;
	getBoardList(1);
}



/*
	- 클릭한 pk[식별자] 이용하는 경우의 수
		1. HTTP get 메소드 방식의 a태그 이용한 pk 이동
		<a href="/jsp_web/board/view.jsp">
		---> 추가 a태그에 변수 넘기기
		<a href="/jsp_web/board/view.jsp?변수명=데이터">
		<a href="/jsp_web/board/view.jsp?변수명=데이터&변수명=데이터">
		<a href="/jsp_web/board/view.jsp?bno=${o.bno}">
		
*/





