console.log('update.js 열림');

if( memberInfo.mid == null ){
	alert('로그인 후 이용가능한 서비스입니다.')
	location.href="/jsp_web/member.login.jsp"
}

document.querySelector('.mid').value = memberInfo.mid;
document.querySelector('.memail').value = memberInfo.memail;
document.querySelector('.mimg').src = `/jsp_web/member/mimg/${ memberInfo.mimg == null ? 'default.png' : memberInfo.mimg }`


// 1. 
function setUpdate(){
	
	// 2. 첨부파일 있을때
	let updateForm = document.querySelectorAll('.updateForm')[0];
	let updateFormData = new FormData( updateForm );
	// 3. 폼에 데이터 추가
		// 1. 체크박스 체크여부 확인
	let defaultimg = document.querySelector('.defaultimg').checked
	updateFormData.set( "defaultimg" , defaultimg )
	
		
	
	$.ajax({
		url : "/jsp_web/member",
		method : "put",
		data : updateFormData,
		contentType : false,
		processData : false,
		success : ( r ) => {
			console.log('통신'); console.log( r );
			if( r == 'true'){
				openModal();	
			}else{
				alert('회원정보 수정 실패')
			}
			
		}
	})
	
}


/*
	// 1. 첨부파일 없을때
	let info = {
		mpwd : document.querySelector('.mpwd').value,
		newmpwd : document.querySelector('.newmpwd').value,
		newmpwdconfirm : document.querySelector('.newmpwdconfirm').value,
		memail : document.querySelector('.memail').value
	}
	console.log( info );
	
	
	$.ajax({
		url : "/jsp_web/member",
		method : "put",
		data : info,
		success : ( r ) => {
			console.log('통신'); console.log( r );
		}
	})
	
*/


function closeModalPlus(){
	closeModal();
	location.href='/jsp_web/member/logout.jsp';
}