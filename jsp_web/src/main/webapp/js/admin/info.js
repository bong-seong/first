

// ajax -> servlet 으로 전달하기 위한 객체 생성
let userList_info = {
	page : 1,		
	key : "",
	keyword : "",
	type : 1, // 1: 전체출력 / 2: 개별출력
	listsize : 3 
}

infoPrint(1);
function infoPrint( page ){
	
	userList_info.page = page ;
	
	$.ajax({
		url : "/jsp_web/member",
		method : "get",
		data : userList_info, // 기존 없었던거 추가
		success : ( r ) => {
			
			console.log( 'get 통신' );
			console.log( r );
			
			let html = `<tr>
							<th width="20%"> 번호 </th>
							<th width="20%"> 프로필 </th>
							<th width="20%"> 아이디 </th>
							<th width="20%"> 이메일 </th>
							<th width="20%"> 비고 </th>
						</tr>`
			
			r.memberList.forEach( (o,i) =>{
				
				html += `<tr>
							<td>${o.mno}</td>
							<td> <img src="/jsp_web/member/mimg/${ o.mimg == null ? "default.png" : o.mimg }"></td>
							<td>${o.mid}</td>
							<td>${o.memail}</td>
							<td></td>
						</tr>`
				
			}) 
			
			// 3. 구성된 html 을 table 에 대입 
			document.querySelector('.info_table').innerHTML = html;
			
			//---------------------------- 페이징 버튼 (추가된거) ------------------------- //
			
			html = ''; // html 초기화
			
			html += `<button type="button" onclick="infoPrint(${1})"> << </button>` // 맨 앞으로 가는 버튼 ( 있어도되고 없어도되고 )
			
			// 이전으로가기 버튼 구성 -> 1 이하로 떨어지면 안되므로 삼항연산자로 제어
			html += page <= 1 ? 
			`<button type="button" onclick="infoPrint(${ page })"> < </button>` :
			`<button type="button" onclick="infoPrint(${ page-1 })"> < </button>`
			
			
			// 실질적인 페이징 버튼 구성
			for( let i=r.startbtn; i<=r.endbtn; i++ ){ // startbtn 부터 endbtn 사이즈 이하까지 반복
				
				html += `<button type="button" onclick="infoPrint(${ i })"> ${ i } </button>`
				 
			}
			
			// 다음으로가기 버튼 구성 -> 총 페이지 수를 넘길 수 없으므로 삼항연산자로 제어 
			html += page >= r.totaluser ? 
			`<button type="button" onclick="infoPrint(${ page })"> > </button>` :
			`<button type="button" onclick="infoPrint(${ page+1 })"> > </button>`
			
			html += `<button type="button" onclick="infoPrint(${ r.totaluser })"> >> </button>`
			
			
			document.querySelector('.info_page_btn').innerHTML = html ;
			document.querySelector('.total_user').innerHTML = `총 멤버 수 : ${r.totalsize}`
			
			select_page( page );
		} // success end
	}) // ajax end 
}


// 리스트 사이즈 ( select 선택에 따른 게시물 출력갯수조절 )
function setListsize(){
	
	let listsize = document.querySelector('.listsize').value; // select value 값 가져오기
	
	// 객체 내 listsize 에 값 대입
	userList_info.listsize = listsize;
	infoPrint(1); // 리스트프린트 랜더링
	
}


// 검색 함수 
function user_search(){

	console.log( 'user_search() 실행' );
	userList_info.key = document.querySelector('.key').value ; // 검색함수 동작시 select 박스의 value 값 가져와 객체에 대입 
	userList_info.keyword = document.querySelector('.keyword').value ; // 함수 동작시 input 에 입력된 값 가져와 객체에 대입 
	infoPrint(1);	// 재호출
}


// 전체보기 버튼 클릭시
function alluser(){
	console.log( 'allboard() 실행' );
	userList_info.key = ''; 		// 검색 없애기 
	userList_info.keyword = ''; 	// 검색없애기
	infoPrint(1);			// 재호출
}


function select_page( page ){
	let selectPage = document.querySelectorAll('.info_page_btn')
	console.log( selectPage[0] );
	console.log( page );
	
	let selectbutton = selectPage[0].querySelectorAll('button');
	
	for( let i=0; i<selectbutton.length; i++ ){
		
		if( page == selectbutton[i].innerHTML ){  
			selectbutton[i].classList.add( 'seletedpage' );
		}else{
			selectbutton[i].classList.remove( 'seletedpage' );
		}
	}
}


/*

			
			
			
			<button type="button"> 2 </button>
			<button type="button"> 3 </button>
			<button type="button"> > </button>
			<button type="button"> >> </button>

*/