console.log( 'view.js 열림' );
console.log( memberInfo );

// * 로그인이 되어있지 않다면 댓글작성 불가능
if( memberInfo.mid == null ){
	document.querySelector('.rcontent').disabled = true;
	document.querySelector('.rcontent').value = "로그인 후 작성 가능합니다."
	document.querySelector('.rwritebtn').disabled = true;
}

// * 현재 보고있는 게시물 번호
let bno = document.querySelector('.bno').value;
	console.log('bno : ' + bno );

// 1. 해당 게시물 호출
function getBoard(){
	
		console.log('getBoard 실행');
		console.log( 'bno : ' + bno );
		
	$.ajax({
		url : "/jsp_web/board/info",
		method : "get",
		data : { "type" : 2 , "bno" : bno },
		success : ( r ) => {
			console.log('getBoard 통신'); console.log( r );
			console.log( r.mimg );
			
			let html = ``
			
			document.querySelector('.mimg').src = `/jsp_web/member/mimg/${r.mimg == null ? 'default.png' : r.mimg}`
			document.querySelector('.mid').innerHTML = r.mid; 
			document.querySelector('.bdate').innerHTML = r.bdate;
			document.querySelector('.bview').innerHTML = r.bview;
			document.querySelector('.bup').innerHTML = r.bup;
			document.querySelector('.bdown').innerHTML = r.bdown;
			
			
			document.querySelector('.btitle').innerHTML = r.btitle;
			document.querySelector('.bcontent').innerHTML = r.bcontent;
			
			if( r.bfile == null ){ // 첨부파일 없을때
				
			}else{ // 첨부파일 있을때
				html = `<button onclick="bdownload( '${r.bfile}' )" type="button" class="downbtn"> 
							<i class="fas fa-download"></i> ${r.bfile} 
						</button>`
				document.querySelector('.bfile').innerHTML = html;
			} 
			
			// ----------------------------------------- //
			// 로그인된 회원과 작성자가 일치하면 수정/삭제 버튼 출력
			if( memberInfo.mid == r.mid ){
				html = `<button onclick="bdelete(${bno} , ${r.cno})" type="button" class="allbtn"> 삭제 </button>
						<button onclick="bupdate(${bno})" type="button" class="allbtn"> 수정 </button>
						`
				document.querySelector('.btnbox').innerHTML = html;
			}
			
			// 댓글 출력
			getReplyList();
			
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
	let bno = document.querySelector('.bno').value;
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

// 4. 삭제
function bdelete( bno , cno ){
	
	$.ajax({
		url : "/jsp_web/board/info",
		method : "delete",
		data : { "bno" : bno , "type" : 1 },
		success : ( r ) => {
			console.log( r );
			if( r == 'true' ){
				alert('삭제성공');
				location.href = "/jsp_web/board/list.jsp?cno="+cno;
			}else{
				alert('삭제실패');
			}
		} 
	})
	
}

// 5. 수정페이지로 이동
function bupdate( bno ){
	location.href="/jsp_web/board/update.jsp?bno=" + bno ;
}


// 6. 댓글 쓰기
function rwrite(){
	
	console.log( 'rwrite() 실행');
	
	$.ajax({
		url : "/jsp_web/board/reply",
		method : "post",
		data : { "type" : 1 , "bno" : bno , "rcontent" : document.querySelector('.rcontent').value },
		success : ( r ) => {
			console.log( r );
			if( r == 'true' ){ 
				alert('댓글작성성공'); 
				document.querySelector('.rcontent').value = "";
				
				// 특정 div만 새로고침[렌더링]
				// $(".replylistbox").load( location.href+' .replylistbox');
				
				// 현재페이지 새로고침[렌더림]
				location.reload();
				 
			} else { alert('댓글작성성공'); }
		}
	})
}

// 7. 댓글 출력
function getReplyList(){
	console.log('getReplyList() 실행' )
	$.ajax({
		url : "/jsp_web/board/reply",
		method : "get",
		data : { "type" : 1 , "bno" : bno },
		success : ( r ) => {
			console.log( r );
			
			let html = '';
			r.forEach( (o,i) => {
				
				html += `
						<div class="replyitem">
							<span class="mimgspan">
								<img src="/jsp_web/member/mimg/${o.mimg == null ? 'default.png' : o.mimg }">
							</span>
							<span class="midspan">${o.mid}</span>
							<span class="rcontentspan">${o.rcontent}</span>
							<span class="rdatespan">${o.rdate}</span>
							<button type="button" onclick="rereplyview(${o.rno})" class="allbtn"> + </button>
						</div>
						<div class="rereplybox${ o.rno }"> </div>`
				
			})
			
			document.querySelector('.replylistbox').innerHTML = html;
		} 
	})
	
}

function rereplyview( rno ){
	console.log( '대댓글 클릭' );
	
	$.ajax({
		url : "/jsp_web/board/reply",
		async : 'false', // 동기식 통신
		method : "get",
		data : { "type" : 2 , "rindex" : rno , "bno" : bno },
		success : ( r ) => {
			console.log( r );
			let html = "";
			r.forEach( ( o ) =>{
				
				html += `
						<div>
							<span>
								<img src="/jsp_web/member/mimg/${o.mimg == null ? 'default.png' : o.mimg }" width="5%;">
							</span>
							<span>${o.mid}</span>
							<span>${o.rdate}</span>
							<span>${o.rcontent}</span>
						</div>`
			})
			
			html += `
				<textarea rows="1" cols="30" class="rrcontent${rno}"> </textarea>
				<button type="button" onclick="rrwrite(${rno})"> 대댓글작성 </button>
				`
			document.querySelector('.rereplybox' + rno ).innerHTML = html;
		}
	})
}

function rrwrite( rno ){
	console.log( 'rrwirte 실행 ');
	// bno , mno , rrcontent , rindex( 상위댓글번호 [ rno ] ) 
	
	$.ajax({
		url : "/jsp_web/board/reply",
		method : "post",
		data : { "type" : 2 , "bno" : bno , "rindex" : rno , "rcontent" : document.querySelector('.rrcontent'+rno).value },
		success : ( r ) => {
			console.log( r );
			if( r == 'true' ){
				alert('대댓글 작성성공');
				location.reload();
				document.querySelector('.rrcontent'+rno).value = '';
			}
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