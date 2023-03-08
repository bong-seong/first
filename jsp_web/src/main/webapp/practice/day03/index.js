// 1. 

function doPOST(){
	alert('Http POST 메소드 실행합니다.')
	
	$.ajax({
		url : "/jsp_web/Ex3",
		method : "post",
		success : ( result ) => { }
	});
}


// 2.

function doGET(){
	alert('Http GET 메소드 실행합니다.')
	
	$.ajax({
		url : "/jsp_web/Ex3",
		method : "get",
		success : ( result ) => { }
	});
}


// 3.

function doPUT(){
	alert('Http PUT 메소드 실행합니다.')
	
	$.ajax({
		url : "/jsp_web/Ex3",
		method : "put",
		success : ( result ) => { }
	});
} 


// 4.

function doDELETE(){
	alert('Http DELETE 메소드 실행합니다.')
	
	$.ajax({
		url : "/jsp_web/Ex3",
		method : "delete",
		success : ( result ) => { }
	});
}

// ---------------------------------------------------------------
// 1. 등록
function onwrite(){
	
	console.log('함수실행');
	let info = {
		content : document.querySelector('.content').value,
		writer : document.querySelector('.writer').value
	}
	console.log( info );
	
	$.ajax({
		url : "/jsp_web/Ex3/Board",
		method : "post",
		data : info,
		success : ( r ) => {
			console.log('응답성공');
			if( r == 'true'){
				alert('등록성공');
				onprint();
				document.querySelector('.content').value = '';
				document.querySelector('.writer').value = '';
			}else{
				alert('등록실패');
			}
		}
	});
}



// 2. 모든 게시물 출력 [ 1. js 열릴때 / 2. 글작성할때마다 ]
onprint();
function onprint(){
	
	$.ajax({
		url : "/jsp_web/Ex3/Board",
		method : "get",
		success : ( r ) => {
			
			console.log('GET 응답 성공');
			console.log( r );
			
			let html = `<table border="1" style="margin-top: 30px;">
						<tr>
							<th>글번호</th><th>내용</th><th>작성자</th><th>작성일</th><th>비고</th>
						</tr>
						`
			r.forEach((o,i)=>{
				
				html += `<tr>
							<td>${o.bno}</td><td>${o.bcontent}</td>
							<td>${o.bwriter}</td><td>${o.bdate}</td>
							<td> 
								<button type="button" onclick="ondelete(${o.bno})"> 삭제 </button>
								<button type="button" onclick="onupdate(${o.bno})"> 수정 </button>  
							</td>
						</tr>`
				
			})
			
			html += `</table>`
			document.querySelector(".content_box").innerHTML = html ;
			
		} 
	});
	
}

function ondelete( bno ){
	
	console.log( bno );
	
	$.ajax({
		url : "/jsp_web/Ex3/Board",
		method : "delete",
		data : {"bno" : bno }, 
		success : ( r ) => {
			console.log("delete 응답 성공")
			if( r == "true" ){
				onprint();
				alert('삭제성공')	
			}else{
				alert('삭제실패')
			}
			
		}
	})
} // ondelete end


// 4. 특정 게시물 수정
function onupdate( bno ){
	
	console.log( "onupdate() 열림" + bno );
	
	let newContent = prompt('수정할 내용');
	console.log( newContent );
	
	$.ajax({
		url : "/jsp_web/Ex3/Board",
		method : "put",
		data : { "bno" : bno , "newContent" : newContent },
		success : ( r ) => {
			console.log('put 응답 성공');
			console.log( r );
			if( r == 'true'){
				onprint();
				alert('수정성공')
			}else{
				alert('수정실패')
			}
			
		}
	})
	
	
}

// --------------------------------------------------------------


// 1. 제품등록
function onadd(){
	
	let info = {
		name : document.querySelector('.product').value,
		price : document.querySelector('.price').value
	}
	
	$.ajax({
		url : "/jsp_web/Ex3/Product",
		method : "post",
		data : info,
		success : ( r ) => {
			console.log('응답성공');
			if( r == 'true'){
				alert('등록성공');
				getProduct();
				document.querySelector('.product').value = '';
				document.querySelector('.price').value = '';
			}else{
				alert('등록실패');
			}
		}
	});
	
}

getProduct();
function getProduct(){
	
	$.ajax({
		url : "/jsp_web/Ex3/Product",
		method : "get",
		success : ( r ) => {
			
			console.log( r );
			
			html = `<tr>
						<th>제품번호</th><th>제품명</th><th>제품가격</th><th>제품등록일</th><th>비고</th>
					</tr>`
					
			r.forEach((o,i)=>{
				
				html += `<tr>
							<td>${o.seq}</td>
							<td>${o.name}</td>
							<td>${o.price}</td>
							<td>${o.reg_date}</td>
							<td>
								<button type="button" onclick="prod_delete(${o.seq})"> 삭제 </button>
								<button type="button" onclick="prod_update(${o.seq})"> 수정 </button> 
							</td>
						</tr>`
				
			})
			document.querySelector('.prod_table').innerHTML = html 
		}
	});
	
}

function prod_update( seq ){
	
	let newname = prompt('제품명 수정');
	let newprice = prompt('제품가격 수정');
	
	$.ajax({
		url : "/jsp_web/Ex3/Product",
		method : "put",
		data : { "seq" : seq , "newname" : newname , "newprice" : newprice },
		success : ( r ) => {
			if( r = 'true'){
				getProduct();
				alert('수정성공');
			}else{
				alert('수정실패');
			}
		}
	})
	
}


function prod_delete( seq ){
	
	$.ajax({
		url : "/jsp_web/Ex3/Product",
		method : "delete",
		data : { "seq" : seq },
		success : ( r ) => {
			if( r = 'true' ){
				getProduct();
				alert('삭제성공');
			}else{
				alert('삭제실패');
			}
		}
	})
	
}















