infoPrint();
function infoPrint(){
	$.ajax({
		url : "/jsp_web/member",
		method: "get",
		success : ( r ) => {
			
			console.log( 'get 통신' );
			console.log( r );
			
			let html = `<tr>
						<th width="10%"> 번호 </th>
						<th width="10%"> 프로필 </th>
						<th width="10%"> 아이디 </th>
						<th width="10%"> 이메일 </th>
						<th width="10%"> 비고 </th>
					</tr>`
			
			r.forEach( (o,i)=>{
				// 2. 테이블 내용을 추가 구성
					// 만약에 회원 mimg 프로필 이미지가 null 이면 기본 프로필 사용 / 아니면 mimg 사용
				
				html += `<tr>
							<td>${o.mno}</td>
							<td> <img src="/jsp_web/member/mimg/${ o.mimg == null ? "default.png" : o.mimg }" width="100%"></td>
							<td>${o.mid}</td>
							<td>${o.memail}</td>
							<td></td>
						</tr>` 
				
			});	// for end
			
			// 3. 구성된 html 을 table 에 대입 
			document.querySelector('.info_table').innerHTML = html;
			 
		} // success end
	}) // ajax end 
}