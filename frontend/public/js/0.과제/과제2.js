/*
주제 : 입력된 값으로 구구단 출력
	* 조건1 : 단[input] 과 곱[input] 입력 받기
	* 조건2 : 확인[button] 클릭 시 결과 실행
	* 조건3 : 테이블에 출력 [ 행 = 단, 열=3 ]
*/

// 테이블의 첫행[제목] html 마크업 대입된 변수
	// let html변수명 = 'HTML마크업작성' 	// ! : 마크업 문자처리
	/*let table_tr = "<tr> <th> 단 </th> <th> 곱 </th> <th> 행 </th> </tr>"; // 테이블의 첫행 [ 제목 ] html 대입
	
	// <table>의 행<tr> 반복문으로 만들기
	for( let gop=1 ; gop<=9 ; gop++ ){ // for start
		// gop 은 1부터 9까지 1씩 중가 반복 처리
		console.log( gop ) // 반복문 확인용
		console.log( " 2 * " + gop + " = " + (2*gop) ) // --> <tr>
		
		// ! : 변수명과 수식은 문자처리 X
		table_tr +=
		"<tr> <th> 2 </th> <th>" + gop + " </th> <th> " + 2*gop + "</th> </tr>";
	} // for end
	
	// 반복문으로 누적된 HTML 변수를 TABLE 에 넣어주기
	document.querySelector('.ggd_table').innerHTML = table_tr*/

function output(){
	let table_tr = "<tr> <th> 단 </th> <th> 곱 </th> <th> 행 </th> </tr>";
	let dan_input = document.querySelector(".dan").value
	let gop_input = document.querySelector(".gop").value
	
	for( let gop=1 ; gop<=gop_input ; gop++ ){
		table_tr +=
		"<tr> <th>" + dan_input + "</th> <th>" + gop + " </th> <th> " + dan_input*gop + "</th> </tr>";
	}
	document.querySelector('.ggd_table').innerHTML = table_tr 
}











