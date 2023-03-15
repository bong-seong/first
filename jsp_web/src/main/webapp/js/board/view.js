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
			
			document.querySelector('.infobox').innerHTML = `${r.bdate} / ${r.bview} / ${r.bup} / ${r.bdown}`;
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