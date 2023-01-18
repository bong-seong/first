let 도서목록 = [ '혼자공부하는자바', '이것이자바다', '열혈 C언어' ]
let 대여목록 = [ '혼자공부하는자바' ]



function bookCheck(){
	let adminTable = `<tr>
						<th> 번호 </th>
						<th> 도서명 </th>
						<th> 도서대여 여부 </th>
						<th> 도서 삭제 </th>
					  </tr>`
	for( i=0 ; i<도서목록.length ; i++ ){
			
		if( 도서목록.indexOf( 대여목록[i] ) >= 0 ){
			adminTable +=
			`<tr>
				<td> ${i+1} </td> 
				<td> ${도서목록[i]} </td>
				<td class="on"> 대여중 </td>
				<td> <button onclick="delBook( ${i} )"> 삭제 </button> </td>
			</tr>`
		}else{
			adminTable +=
			`<tr>
				<td> ${i+1} </td> 
				<td> ${도서목록[i]} </td>
				<td class="off"> 대여가능 </td>
				<td> <button onclick="delBook( ${i} )"> 삭제 </button> </td>
			</tr>`
		}
	}
}
document.querySelector('.bookList').innerHTML = bookCheck()
console.log( bookCheck() )


