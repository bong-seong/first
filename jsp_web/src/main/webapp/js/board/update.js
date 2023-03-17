console.log( 'update.js 열림');

let bno = document.querySelector('.bno').value;
console.log( "bno : " + bno );


getBoard()
function getBoard(){
	
	$.ajax({
		url : "/jsp_web/board/info",
		method : "get",
		data : { "type" : 2 , "bno" : bno },
		success : ( r ) => {
			console.log("update 통신"); console.log( r );
			
			document.querySelector('.btitle').value = r.btitle;
			document.querySelector('.bcontent').value = r.bcontent;
			
			
			// 1. 기존 select option 가져와서 select
			
			let cnoSelect = document.querySelector('.cno');
				console.log( cnoSelect );
				console.log( cnoSelect.options[0] ); // selet 안에 있는 첫번째 option 
			
			for( let i=0; i<cnoSelect.options.length; i++ ){
				// i는 0부터 옵션태그 개수만큼 반복
				if( cnoSelect.options[i].value == r.cno ){
					// i번째 옵션<option> 태그의 값과 현재 게시물의 카테고리 번호와 일치하면
					cnoSelect.options[i].selected = true ;
				}
			}
			
			// 2. 첨부파일 있을때 / 없을때
			let html = '';
			
			if( r.bfile == null ){ // 없을때 
				html += '첨부파일없음';
			} else { // 있을때
				html += `기존 첨부파일 : <span class="oldbfile"></span>
						<button type="button" onclick="bfiledelete()"> 삭제 </button>`
			}
			
			document.querySelector('.bfilebox').innerHTML = html ;
			
			if( r.bfile != null ){ 
				document.querySelector('.oldbfile').innerHTML = r.bfile;
			}
		}
	})	
}

// 2. 
function bupdate(){
	
	let updateForm = document.querySelectorAll('.updateForm')[0];
	// 1. form 안에 있는 데이터 객체화
	let updateFormData = new FormData( updateForm )
		// 2. form 밖에 있거나 js에 있는 추가 데이터는 formData 추가
		// formdata객체명.set( '변수명' , 데이터 )
	updateFormData.set( 'bno' , bno );
	
	$.ajax({
		url : "/jsp_web/board/info",
		method : "put",
		data : updateFormData,
		contentType : false,
		processData : false,
		success : ( r ) => {
			console.log( r );
			if( r == 'true' ){
				alert('업데이트 성공');
				location.href = "/jsp_web/board/view.jsp?bno="+bno;
			}
		}	 
	})
}



function bfiledelete(){
	
	$.ajax({
		url : "/jsp_web/board/info",
		method : "delete",
		data : { "bno" : bno , "type" : 2 }, // 1: 게시물삭제[ 첨부파일포함 ] // 2: 첨부파일만 삭제
		success : ( r ) => {
			if( r == 'true' ){
				
				alert('첨부파일이 삭제되었습니다.')
				
				// 특정 div 만 reload[랜더링] 방법
					// 주의점!! : location.href+' 띄어쓰기한번.클래스명'
				$(".bfilebox").load( location.href+' .bfilebox');
					// loac() : jquery 제공하는 랜더링 [새로고침] 함수
					
			}else{
				
			}
		}
		
	})
}













