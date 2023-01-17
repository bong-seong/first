/*

	- 점수관리
		1. 학생 점수 등록 페이지
		
	- 출력 : 1.번호 / 2.이름 / 3.국어 / 4.영어 / 5.수학 / 6.총점 / 7.평균 / 8.순위[총점기준]

*/

// * 학생들의 점수객체를 여러개 저장하는 배열
let studentArray = []

// 1. JS 열렸을때 <button> 객체 가져오기
let addbtn = document.querySelector('.addbtn')
// 2. 해당 버튼에 클릭 이벤트
addbtn.addEventListener( 'click' , () => { 
	
	// 1. 입력받은 데이터 하나씩 가져와서 객체화
		// * input 숫자를 입력해도 value는 무조건 문자열 가져온다. 형변환 필요!!
		// parseInt( 문자열 ) -> 정수
	let info = { 
		name : document.querySelector('.name').value,
		kor : parseInt( document.querySelector('.kor').value ),
		eng : parseInt( document.querySelector('.eng').value ),
		mat : parseInt( document.querySelector('.mat').value )
	}
	
	
	// 2. 유효성검사 [ 데이터 체크 ]
	let check = true; 	// 유효성검사 상태 저장하는 변수 [ 아래 4개중 하나라도 충족하면 저장 실패 ]
		// 1. 중복이름체크
	studentArray.forEach( (obj) => {
		if( obj.name == info.name ){ 
			document.querySelector('.namebox').innerHTML = '이미 등록된 이름입니다.' ; check = false;
		}
		
		
	})
		// 2. 점수 0~100 사이만 입력
	if( (info.kor<=0 || info.kor>=100) || 
		(info.eng<=0 || info.eng>=100) || 
		(info.mat<=0 || info.mat>=100) ){
		alert( '입력할 수 없는 점수범위입니다.' ) ; check = false;
	}
	
		// 3. [유효성검사추가]이름이 3~5 사이만 입력가능
	if( info.name.length < 3 || info.name.length > 5 ){
		alert('3~5글자를 입력하세요.'); check = false;
	} 
	
		// 4. [유효성검사추가] 점수가 숫자가 아닐경우 [ isNaN() : 숫자 체크 => 문자이면 true or 숫자이면 false ]
	if( isNaN(info.kor) || isNaN(info.eng) || isNaN(info.mat) ){
		alert( '숫자형식으로 입력해주세요.'); check = false;
	}
	
	// 3. 저장 [ 위 유효성검사에서 하나라도 걸리지 않았을때 ]
	if( check ){ studentArray.push( info ) }
	
	printTable();
	
})

// - 출력 : 1.번호 / 2.이름 / 3.국어 / 4.영어 / 5.수학 / 6.총점 / 7.평균 / 8.순위[총점기준]
// 2. 배열내 객체 정보를 테이블에 출력하는 함수 [ 1. js 열렸을때 / 2. 등록할때마다 (업데이트용) / 3. 삭제 / 4. 수정 ]
printTable(); // 함수호출
function printTable(){
	
	// 1. html 구성
	let html = `<tr>
						<th> 번호 </th>
						<th> 이름 </th>
						<th> 국어 </th>
						<th> 영어 </th>
						<th> 수학 </th>
						<th> 총점 </th>
						<th> 평균 </th>
						<th> 순위 </th>
						<th> 비고 </th>  
					</tr>`
					
	// 2. 배열내 객체 정보를 html 대입
	studentArray.forEach( (o,i) => {
		
		// 1. 총점
		let totalScore = o.kor + o.eng + o.mat		// 기준
		// 2. 순위구하기	
		let rank = 1;								// 기준
		studentArray.forEach( (o2) => {
			// 1. 비교할 총점
			let total = o2.kor + o2.eng + o2.mat
			// 2. 만약에 총점이 비교할 총점보다 작이면 순위는 하락
			if ( totalScore < total ){ rank++ }
		})
		
		html+= `<tr>
					<td> ${ i+1 } </td>
					<td> ${ o.name } </td>
					<td> ${ o.kor } </td>
					<td> ${ o.eng } </td>
					<td> ${ o.mat }</td>
					<td> ${ totalScore } </td>
					<td> ${ parseInt( totalScore/3 ) } </td>
					<td> ${ rank } </td>
					<td> 
						<button onclick="delbtn( ${i} )"> 삭제 </button> 
						<button onclick="onUpdate( ${i} )"> 수정 </button> 
					</td> 
				</tr>`
	})
	
	//3. 
	document.querySelector('.listtable').innerHTML = html
}


// 3. 배열내 객체 삭제 [ 삭제할 인덱스 ]
function delbtn( i ){
	studentArray.splice( i , 1 ) // 선택한 i번째 객체 삭제
	printTable()
}


// 4. 수정 버튼을 클릭했을때 [ 수정할 인덱스 !!! ]
let upindex = -1; // 수정할 인덱스 => 여럿 { }에서 동일한 변수를 사용하기 위해  // 전역변수
function onUpdate( i ){
	upindex = i // 내가 선택한 i번째 인덱스 
	// 1. 수정페이지 보여주기
	document.querySelector('.updatebox').style.display = 'block'
	// 2. 기존의 데이터를 대입 [ 선택한 i번째의 객체의 name 속성 대입 ]
	document.querySelector('.upname').value = studentArray[i].name
	document.querySelector('.upkor').value = studentArray[i].kor
	document.querySelector('.upeng').value = studentArray[i].eng
	document.querySelector('.upmat').value = studentArray[i].mat 
} 


// 5. 점수수정 버튼을 클릭했을때
let updatebtn = document.querySelector('.updatebtn')
updatebtn.addEventListener('click' , () => {
	
	// 1. 수정된 데이터 가져오기 // 2. 해당 객체의 속성 값 변경
	studentArray[upindex].kor = parseInt( document.querySelector('.upkor').value )
	studentArray[upindex].eng = parseInt( document.querySelector('.upeng').value )
	studentArray[upindex].mat = parseInt( document.querySelector('.upmat').value )
	
	// 2. 수정페이지 숨기기
	document.querySelector('.updatebox').style.display = 'none'
	
	// 3. 테이블 업데이트 ( 새로고침 )
	printTable() 
})






