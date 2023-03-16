console.log( 'view.js 열림' );

getBoard();
function getBoard(){
	
		console.log('getBoard 실행');

	let bno = document.querySelector('.bno').innerHTML;
		console.log( 'bno : ' + bno );
		
	$.ajax({
		url : "/jsp_web/board/info",
		method : "get",
		data : { "type" : 2 , "bno" : bno },
		success : ( r ) => {
			console.log('getBoard 통신'); console.log( r );
			
			let html = `${r.bdate} / 
						${r.bview} / 
						<button onclick="bIncrease(2)" type="button"> ${r.bup} </button> / 
						<button onclick="bIncrease(3)" type="button"> ${r.bdown} </button>
						`
			
			document.querySelector('.infobox').innerHTML = html;
			document.querySelector('.pimgbox').innerHTML = `<img width="5%" src="/jsp_web/member/mimg/${r.mimg == null ? 'default.png' : r.mimg }"> ${r.mid}`;
			document.querySelector('.btitle').innerHTML = r.btitle;
			document.querySelector('.bcontent').innerHTML = r.bcontent;
			
			if( r.bfile == null ){ // 첨부파일 없을때
				document.querySelector('.bfile').innerHTML = '첨부파일없음';	
			}else{ // 첨부파일 있을때
				html = `${r.bfile} <button onclick="bdownload( '${r.bfile}' )" type="button"> 다운로드 </button>`
				document.querySelector('.bfile').innerHTML = html;
			} 
			
			
		} // success end
	}) // ajax end 
} // func end

// 2. 다운로드 [ 다운로드할 파일명 인수로 받기 ]
function bdownload( bfile ){
	console.log( 'bdownload 실행 '  + bfile );
	
	/*
	$.ajax({
		url : "/jsp_web/filedownload",
		method : "get",
		data : { "bfile" : bfile },
		success : ( r ) => {
			console.log('bdownload 통신'); console.log( r );
			
		}
		
	}) // ajax end 
	*/
	location.href="/jsp_web/filedownload?bfile="+bfile;
	
	
} // func end 


// 3. 조회수[1] , 좋아요수[2] , 싫어요수[3]
bIncrease( 1 ) ; // 현재 jsp/js 가 열리는 순간 [ 조회수 증가 ]
function bIncrease( type ){
	
	// 1. 현재 게시물의 번호 [ 증가할 대상 ]
	let bno = document.querySelector('.bno').innerHTML;
	console.log( "bno : " + bno );
	// 2. 
	$.ajax({
		url : "/jsp_web/board/view",
		method : "get",
		data : { "type" : type , "bno" : bno },
		success : ( r ) => {
			console.log( 'bIncrease 통신'); console.log( r );
			// 새로고침
			getBoard();
		}
		
	})
} 


/*
	1. onclick = 스크립트 작성가능
		1. bdownload( 짱구4.jpg ) : 문자처리가 되지않음 ==> .이 접근연산자로 인식되어 오류발생
		2. bdownload( '짱구4.jpg' ) : 문자처리함 ==> .은 접근연산자가 아닌 문자로인식하여 파일확장자구분용도로 사용됨
		
	<button onclick="bdownload( ${r.bfile} )" type="button"> 다운로드 </button>
		<button onclick="bdownload( 짱구4.jpg )" type="button"> 다운로드 </button>
		
		
	<button onclick="bdownload( '${r.bfile}' )" type="button"> 다운로드 </button>
		<button onclick="bdownload( '짱구4.jpg' )" type="button"> 다운로드 </button>
	
	2. 
		전송 방법
			HTML 	: 	1.<form>		2. <a href="">
			JS 		:	1. location.href=""
			JQUERY 	: 	1. $.ajax({ })
			servlet : 	
					1. response.getWriter.print();
					2. response.sendRedirect('경로');
	
*/