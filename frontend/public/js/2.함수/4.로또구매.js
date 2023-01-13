console.log( '스크립트 실행 확인' )

// 1. 숫자 버튼을 출력하는 함수
function btnPrint(){ // function START
	
	console.log( '2. 함수작동' )
	
	let btnList = '' ; // for 밖에 만든 이유 : 45개의 버튼을 저장하려고
	
	// for
	for( let i=1 ; i<=45 ; i++ ){ // for START
	// i 는 1부터 45보다 작거나 같을때까지 1씩 반복증가
		console.log( '3. : ' + i )
		
		// 1. 문자열 처리
		// "<button onclick=btnClick(" + i + ")>" + i = "</button>"
		
		// 2. 백틱(`) 이용한 문자열 처리
			// 1. 전체를 백틱으로 감싼다.
			// 2. 변수/수식 는 ${변수/수식} 감싼다
		btnList +=
		`<button onclick=btnClick(${i})> ${i} </button>`
		
		// 만약에 5배수이면 btnList 에 '<br>/' 을 추가한다. 
		if( i%5 == 0 ){ btnList += '<br/>' }
		
	} // for END
	
	console.log( '4. : ' + btnList )
	
	document.querySelector('.btnBox').innerHTML = btnList
	
	// 취소 버튼 보이게 활성화
	document.querySelector('.delBtn').style.display = 'inline'
	
	
}// function END


// 2. 로또 구매 취소 
function btnPrintDel(){
	// 해당 <div> 에 '' 공백으로 변경하기
	document.querySelector('.btnBox').innerHTML = ''
	
	// 취소버튼을 눌렀을때 해당 버튼 비활성화 
	document.querySelector('.delBtn').style.display = 'none'
	
	// 배열내 모든 요소 제거 [ 0번 인덱스부터 모두 삭제 ]
	selectNum.splice(0);
	
	추첨버튼출력() // 배열을 출력하는 함수를 호출하여 비워진 배열을 HTML 에 보여줌
	
}

// 1. 선택한 숫자를 6개 저장하는 배열
let selectNum = []


// 3. 버튼 클릭 함수
function btnClick( x ){
	console.log( x + " 번호를 클릭 했습니다.")
	
	// 유효성 검사
		// 1. 중복검사 / 취소	[배열명.indexOf(찾을데이터) : 찾은데이터의 인덱스번호 반환, 없으면 -1 ]
	if( selectNum.indexOf(x) >=0 ){ // if START
		alert('이미 선택한 번호 입니다.')
		// [ 배열명.splice(인덱스번호 , 개수 ) : 해당 인덱스부터 개수만큼 삭제 ]
		selectNum.splice(selectNum.indexOf(x), 1)
		추첨버튼출력() // 함수호출
		return; // 반환값은 없지만 함수를 끝낼 수 있다. [ 더 이상 아래로 코드가 실행되지 않는다. ]
	} // if END
	
		// 2. 6개까지만 저장
	if( selectNum.length == 6 ){
		alert("이미 모두[6개]를 선택했습니다.")
		return;
	}
	// 위 두가지 유효성 검사를 충족하지 않았을 때 저장 [ 중복도 아니며, 6개가 저장되지 않았을 경우 ]
	selectNum.push( x )
	추첨버튼출력() // 함수호출
}

// 4. 선택번호목록 출력 및 추첨버튼 활성화 [ 1. 중복숫자 클릭시 취소할때 / 2. 6개의 번호 선택시 버튼 출력 / 3. 취소버튼클릭시 없어진 배열을 출력할 때 ]
function 추첨버튼출력(){
	// 추첨버튼 활성화/비활성화
	if( selectNum.length == 6 ){
		document.querySelector('.추첨버튼').style.display = 'inline'	
	}
	else{ document.querySelector('.추첨버튼').style.display = 'none' }
	
	document.querySelector('.selectNumList').innerHTML = selectNum
} 


// 2. 추첨번호목록 배열 선언
let 추첨번호목록 = []

// 5. 추첨하기 버튼을 클릭했을때 함수
function 구매추첨(){ // function START
	
	// 1. 컴퓨터가 난수 발생 [ 1~45 사이의 수 6개 ]
	for( let i=1 ; i<=6 ; i++ ){ // for START
		// 1. 난수 만들기
		let 실수난수 = Math.random()*45+1	 // 1 ~ 45 사이의 실수 난수 생성
		// 2. 실수 ==> 정수 변환
		let 정수난수 = parseInt( 실수난수 )
			
			if( 추첨번호목록.length == 6 ){
				추첨번호목록.splice(0);
			}
			
			// * 중복검사
			if( 추첨번호목록.indexOf( 정수난수 ) >= 0 ){ // 이미 존재한 난수이면
				i--; // i는 6회 반복하는데 난수저장 실패시 1회 차감 
			}else{ // 배열내 존재하지 않는 난수이면
				// 3. 정수난수를 배열에 저장
				추첨번호목록.push( 정수난수 )				
			}
			
			
			
		// 1~3 : 추첨번호목록.push( parseInt( Math.random()*45+1 ) )
		} // for END
		
		document.querySelector('.추첨번호상자').innerHTML = 추첨번호목록
		// 추첨 결과 출력 [ 맞은개수와 등수[6개-1등 / 5개-2등 / 4개-3등 / 그외 꽝 ] 출력 ]
				
		let 맞은개수 = 0;
		for( i=0 ; i<=추첨번호목록.length ; i++ ){ // i는 0부터 추첨번호목록 배열의 길이까지 }
			
			for( j=0; j<=selectNum.length ; j++ ){
			
				console.log( 추첨번호목록[i] + " : " + selectNum[j] )
				
				if( 추첨번호목록[i] == selectNum[j] ){ 맞은개수++ }
			}
		}
		
		// 2.
		맞은개수 = 0;
		for( let i=0 ; i<추첨번호목록.length ; i ++ ){
				
			if ( selectNum.indexOf( 추첨번호목록[i] ) >= 0 ){ 맞은개수++ }
			
		}
		
		
		맞은개수 = 0;
		// 3. for( 반복변수 of 배열 ) : 배열내 요소 하나씩 마지막 요소까지 반복변수에 대입
		for( let value of 추첨번호목록 ){
			console.log( value )
			if( selectNum.includes( value ) == true ){ 맞은개수++ } 
		}
		
		
		alert( 맞은개수 + "개 맞았습니다.")
		
		// 배열명.indexOf(찾을데이터) : 찾을데이터의 인덱스 반환 / 없으면 -1
		// 배열명.includes(찾을데이터) : 찾을데이터의 존재 여부 true / 없으면 false
		
		
		
	
} // function END


/*
 
 	난수만들기
 		1. Math 클래스 [ 미리 만들어둔 설계도 ]
 			1. random() 함수 [ Math 클래스가 제공하는 미리 만들어둔 함수 ]
 			예시)
 				Math.random() 		: 0 ~ 1 사이의 실수 난수 발생
 				Math.random()+1 	: 1 ~ 2 사이의 실수 난수 발생
 				Math.random()*45 	: 0 ~ 45 사이의 실수 난수 발생
 				Math.random()*45+1 	: 1 ~ 46 사이의 실수 난수 발생
 			2. floor() : 소수점 버림 함수
 				Math.floor( 3.14 ) 	: 3
 		
 		2. parseInt() : 정수 변환 함수
 				parseInt( 3.14 )	: 3 
 	
 	두 배열 비교
 		1. 
 			배열1 : 3 7 2 5
 			배열2 : 1 5 3 4
 			
 */













