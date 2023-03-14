console.log('print js 열림')

let type = 0;
let info = '';
let search = '';

print( 0 );
// 출력 함수
function print( type ){
	console.log('print 함수 열림')
	
	if( type == 3 ){
		search = document.querySelector('.search').value
		console.log( search );
	}
	
	$.ajax({
		url : "/jsp_web/print",
		method : "get",
		data : { 'type' : type , "search" : search },
		success : (r)=>{
			console.log('print 함수 연결 성공')
			console.log(r)
			info = r;
			let html = `<tr>
							<th width="5%"> 번호 </th>
							<th width="5%"> 사진 </th>
							<th width="5%"> 이름 </th>
							<th width="5%"> 직급 </th>
							<th width="10%"> 고용형태 </th>
							<th width="15%"> 입사일 </th>
							<th width="15%"> 퇴사일 </th>
							<th width="10%"> 퇴사사유 </th>
							<th width="10%"> 부서 </th>
							<th width="20%"> 비고 </th>
						</tr>`
			r.forEach( (o,i)=>{
				html +=	`<tr>
							<th width="10%"> ${o.no} </th>
							<th width="10%">
								<img src="/jsp_web/practice/과제1/img/${o.img == null ? 'default.png' : o.img }"> 
							</th>
							<th> ${o.name } </th>
							<th> ${o.jobgrade } </th>
							<th> ${o.type} </th>
							<th> ${o.indate} </th>
							<th> ${o.outdate == null ?  '-' : o.outdate } </th>
							<th> ${o.outreason == null ?  '-' : o.outreason} </th>
							<th> ${o.part} </th>
							<th> 
								<button onclick="onclickLeave(${o.no})" type="button">퇴사</button> 
								<button onclick="onclickUpdate(${o.no})" type="button">수정</button> 
								<button onclick="onclickDelete(${o.no})" type="button">삭제</button> 
							</th>
						</tr>`
			} ) // for e
			document.querySelector('.printTable').innerHTML = html;
		}
	}) // ajax e
} // print e



// 삭제버튼 눌렸을때 함수
function onclickDelete(no){
	document.querySelector('.modal_wrap').style.display = "flex";
	document.querySelector('.modal_title').innerHTML = "삭제";
	
	let html = `
		정말 삭제하시려면 삭제할 사원번호를 입력해주세요</br>
		<input type="text" class="deleteNo">
	`;
	let htmlbtn = 
		`
			<button onclick="onDelete(${no})" type="button">삭제</button> 
			<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button> 
		`;
	
	document.querySelector('.modal_content').innerHTML = html;
	document.querySelector('.modal_btns').innerHTML = htmlbtn;
}



// 수정버튼 눌렸을때 함수
function onclickUpdate(no){
	document.querySelector('.modal_wrap').style.display = "flex";
	document.querySelector('.modal_title').innerHTML = "수정";
	
	let html = `
		<form class="updateForm">
			<table class="updateTable" border="1">
				<tr>
					<th width="10%"> 번호 </th>
					<th width="10%"> 사진 </th>
					<th width="10%"> 이름 </th>
					<th width="10%"> 고용형태 </th>
					<th width="10%"> 입사일 </th>
					<th width="10%"> 퇴사일 </th>
					<th width="10%"> 퇴사사유 </th>
					<th width="10%"> 부서 </th>
				</tr>
				<tr>
					<th width="10%"> <div class="no"></div> </th>
					<th width="10%"> <img alt="" src=""> <input type="file" name="newimg" class="img"> </th>
					<th width="10%"> <input type="text" id="name" name="name"> </th>
					<th width="10%"> 
						<select class="type" name="type">
							<option class="firstoption">고용형태</option>
							<option>일용직</option>
							<option>정규직</option>
							<option>임원</option>
						</select> 
					</th>
					<th width="10%"> <div class="indate"></div> </th>
					<th width="10%"> <div class="outdate"></div> </th>
					<th width="10%"> <div class="outreason"></th>
					<th width="10%">
						<select name="part" id="part">`
						
						$.ajax({
							url : "/jsp_web/regist",
							method : "get", 
							async : false,
							success : ( r ) => {
								console.log('part_select_print ajax'); console.log( r );
								r.forEach( (o,i) =>{
									html +=  `<option value="${o.partname}"> ${ o.partname } </option>`
											
								}) // forEach end
								
								html+= `</select> 
									</th>
								</tr>
							</table>
						</form>`
							} // success end 
						})	// ajax end

	
	$.ajax({
		url : "/jsp_web/print",
		method : "get",
		data : { type : type },
		success : (r)=>{
			console.log('수정 함수 연결 성공')
			console.log(r)
			r.forEach( (o)=>{
				if(o.no==no){
					console.log(o)
					document.querySelector('.no').innerHTML = `${o.no}`;
					document.querySelector('.firstoption').innerHTML = `${o.type}`;
					document.querySelector('#name').value = `${o.name}`;
					document.querySelector('.indate').innerHTML = `${o.indate}`;
					document.querySelector('.outdate').innerHTML = `${o.outdate == null ? '-' : o.outdate}`;
					document.querySelector('.outreason').innerHTML = `${o.outreason == null ? '-' : o.outreason }`;
					document.querySelector('#part').value = `${o.part}`;
				}
			})
		}
	}) // ajax e
	let htmlbtn = 
		`
			<button onclick="onUpdate(${no})" type="button">수정</button> 
			<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button> 
		`;
	document.querySelector('.modal_content').innerHTML = html;
	document.querySelector('.modal_btns').innerHTML = htmlbtn;
}

// 모달 닫기 함수
function closeModal(){
	document.querySelector('.modal_wrap').style.display = "none";
}
// 삭제함수
function onDelete(no){
	let inputno = document.querySelector('.deleteNo').value;
	if(inputno==no){
		$.ajax({
			url : "/jsp_web/print",
			method : "delete",
			data : {"no" : no},
			success : (r)=>{
				console.log('onDelete 연동성공')
				console.log(r)
				alert('삭제되었습니다.')
				closeModal();
				print( 0 );
			}
			
		}) //ajax e
	} // if e
	else{alert('일치하지 않습니다.')}
} // onDelete e

// 수정함수
function onUpdate(no){
	console.log('onUpdate 함수 s')
	let updateForm = document.querySelectorAll('.updateForm')[0];
	console.log(updateForm)
	let updateFormData = new FormData( updateForm );
	updateFormData.set( "no" , no );
	console.log(updateFormData)
	$.ajax({
			url : "/jsp_web/print",
			method : "put",
			data : updateFormData,
			contentType : false ,			
			processData : false ,
			success : (r)=>{
				console.log( 'update ajax 응답');
				console.log( r );
				if(r=='true'){
					alert('수정완료 되었습니다.')
					closeModal();
					print( 0 );
				}else{alert('수정 실패')}
			}
		}) //ajax e
}

function onclickLeave(no){
	document.querySelector('.modal_wrap').style.display = "flex";
	document.querySelector('.modal_title').innerHTML = "퇴사";
	
	let html = `
		퇴사 사유를 입력해주세요</br>
		<input type="text" class="leaveReason">
	`;
	let htmlbtn = 
		`
			<button onclick="onLeave(${no})" type="button">퇴사처리</button> 
			<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button> 
		`;
	
	document.querySelector('.modal_content').innerHTML = html;
	document.querySelector('.modal_btns').innerHTML = htmlbtn;
	
	
}


function onLeave(no){
	let leavereason = document.querySelector('.leaveReason').value
	$.ajax({
			url : "/jsp_web/print",
			method : "post",
			data : {"no" : no , "outreason" : leavereason},
			success : (r)=>{
				console.log('onLeave 연동성공')
				console.log(r)
				if(r=='true'){
					alert('퇴사처리 되었습니다.')
					closeModal();
					print(0);
				}else{alert('퇴사처리 실패')}
			}
		}) //ajax e
	
}



