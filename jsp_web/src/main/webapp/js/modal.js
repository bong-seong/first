console.log('modal.js 열림')

// 1. 모달 열기 함수
function openModal(){
	// 1. 모달 배경 구역 css 변경해서 모달 보이기 
	document.querySelector('.modal_wrap').style.display='flex'
}

// 2. 모달 닫기 함수
function closeModal(){
	document.querySelector('.modal_wrap').style.display='none'
}