console.log( 'write.js 열림');



function bwrite(){
		
	// 1. 폼 가져오기
	let writeForm = document.querySelectorAll('.writeForm')[0];
		console.log( writeForm );
	
	// 2. 폼 객체 ---> new FormData 클래스 [ form 전송객체 ]
	let writeFormData = new FormData( writeForm );
		console.log( writeFormData );
	
	// 3. ajax 통신
	$.ajax({
		url : "/jsp_web/board/info",
		method : "post",
		data : writeFormData,
		contentType : false,
		processData : false,
		success : ( r ) => {
			console.log( 'write ajax 통신'); console.log( r );
			if( r == 'true' ){
				alert('글이 등록되었습니다.')
			}else{
				alert('[ 실패 ] 관리자에게 문의하세요')
			}
		}
	})
}