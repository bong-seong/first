
let qboardSave = []

function qboard_write(){
	
	let qboard = {
		title: document.querySelector('.qtitle').value,
		content: document.querySelector('.qcontent').value,
		writer: document.querySelector('.qwriter').value,
		password: document.querySelector('.qpassword').value
	}
	
	qboardSave.push( qboard )
	
	let result = true;
	if( result ){ alert('작성완료'); location.href = 'list.html' }
	else{ alert('작성실패') }
	
}