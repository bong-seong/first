console.log('info.js 열림');

// * 회원정보.js : 만약에 로그인이 안되어 있으면 불가능 [ 제어 ]
if( memberInfo.mid == null ){
	alert('로그인이 필요한 서비스입니다.');
	location.href="/jsp_web/member/login.jsp";
}

// 1. header.js 에서 ajax 동기식으로 회원정보 가져온 상태 [ memberInfo ]
document.querySelector('.mid').innerHTML = memberInfo.mid;
document.querySelector('.memail').innerHTML = memberInfo.memail;
document.querySelector('.mimg').src = `/jsp_web/member/mimg/${memberInfo.mimg == null ? 'default.png' : memberInfo.mimg }`
document.querySelector('.mpoint').innerHTML = memberInfo.mpoint;

// 2. 회원탈퇴
// function delete(){} // [ js에서 이미 사용증인 키워드 ]
function setDelete(){
	console.log( 'setDelete() 실행' );
	
	$.ajax({
		url : "/jsp_web/member",
		method : "delete",
		data : { "mpwd" : document.querySelector('.mpwd').value }, 
		success : (r)=>{
			console.log('delete 통신'); console.log(r);
			if( r == 'true' ){
				alert('회원탈퇴가 완료되었습니다.');
				location.href="/jsp_web/member/logout.jsp"; // 로그아웃 처리	
			}else{
				alert('회원탈퇴실패[ 패스워드 불일치 ]');
			}
		}
	})
}
