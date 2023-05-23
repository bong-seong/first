function scoreAdd() {
	console.log("등록하기 버튼 클릭");

	// 1. 
	let sno = document.querySelector('.sno') ;
	if( sno.value == "" ){
		alert("학생번호가 입력되지 않았습니다.")
		sno.focus();
		return false;
	}
	
	let ekor = document.querySelector('.ekor');
	if( ekor.value == "" ){
		alert("국어점수가 입력되지 않았습니다.")
		ekor.focus();
		return false;
	}
	
	let emath = document.querySelector('.emath');
	if( emath.value == "" ){
		alert("수학점수가 입력되지 않았습니다.")
		emath.focus();
		return false;
	}
	 
	let eeng = document.querySelector('.eeng')
	if( eeng.value == "" ){
		alert("영어점수가 입력되지 않았습니다.")
		eeng.focus();
		return false;
	}
	
	let ehist = document.querySelector('.ehist');
	if( ehist.value == "" ){
		alert("역사점수가 입력되지 않았습니다.")
		ehist.focus();
		return false;
	}
	
	// 폼 전송
	document.scoreform.submit();
	alert('회원 등록이 완료 되었습니다.')
	
}	
