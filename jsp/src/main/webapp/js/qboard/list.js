console.log('test')


qboardPrint()
function qboardPrint(){
	
	let qboardlist = [
		{ no: 5, title: '문의드립니다.', writer:'민경훈', date: '2023-01-30', view: 1, state: false, complet: '2023-01-31'},
		{ no: 4, title: '구매 문의드립니다.', writer:'김희철', date: '2023-01-25', view: 3, state: false, complet: '2023-01-26'},
		{ no: 3, title: '환불 문의드립니다.', writer:'김영철', date: '2023-01-23', view: 45632, state: false, complet: '2023-01-24'},
		{ no: 2, title: '부가티 시론 입고날 언제인가요', writer:'서장훈', date: '2023-01-20', view: 2632, state: true, complet: '2023-01-21'},
		{ no: 1, title: '티코 사고싶습니다.', writer:'강호동', date: '2023-01-19', view: 2, state: true, complet: '2023-01-20'}
	]
	
	let html = ''
	
	qboardlist.forEach( (obj) =>{
		
		html += `<tr>
					<td>${ obj.no }</td>
					<td> <a href="view.html" > ${ obj.title } </a></td>
					<td> ${ obj.writer }  </td>
					<td> ${ obj.date } </td>
					<td> ${ obj.view } </td>
					<td> ${ obj.state ? "완료" : "접수" } </td>
					<td> ${ obj.state ? obj.complet : ''  } </td>
				</tr>`
	})
	
	document.querySelector('.tbody').innerHTML = html
}
