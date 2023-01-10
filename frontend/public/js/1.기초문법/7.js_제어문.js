/*
	삼항연산자 : 조건 ? 참(true) : 거짓(false) 
	제어문
		IF : 만약에 ~~ [ 경우의수 판단 ]
		1. 형태
			1. if( 조건 ) [ture]실행문
			2. if( 조건 ) { [ture]실행문1; 실행문2; 실행문3; }
				* 실행문이 2개 이상일때 { } 이용한 묶음처리 필요
			3. if( 조건 ) { [true]실행문; }
			   else { [false] 실행문; }
			4. if( 조건 ) { [true]실행문; }
			   else if ( 조건2 ) { [true2]실행문; }
			   else if ( 조건3 ) { [true3]실행문; }
			   else if ( 조건4 ) { [true4]실행문; }
			   else { [false]실행문; }
			   
			5. 중첩
				if( 조건1 ) {
						if( 조건2 ) {
							if( 조건3 ) {
								
									   }
								   }
						   }
				
*/

// 1. if 형태1
if( 10 > 3 ) console.log ('[참1] 10이 더 크다');		// 조건이 맞을 경우 옆으로 이동 ( 옆에 것을 실행 ) 
if( 10 > 20 ) console.log ('[참2] 10이 더 크다');		// 조건이 맞지않을 경우 실행되지 않는다.
if( 10 > 20 ); console.log ('[참3] 10이 더 크다');		// 틀린예 [ X ]
/*
	; : 세미콜론 [명령어 단위 마침표]
	실행문
	실행문; 실행문;
	if() [참]실행문;  [O]
	if(); [참]실행문;  [X]
*/

// 2. if 형태2
if( 10 > 3 ) console.log('참1'); console.log('1.10이 더 크다.');   		// [ X ] 
if( 10 > 20 ) console.log('참2'); console.log('2.10이 더 크다.');		// [ X ]
if( 10 > 20 ) { console.log('참3'); console.log('3.10이 더 크다.'); }	// [ O ]

// 3. if 형태3
if( 10 > 3 ){ console.log('[참1] 10이 더 크다.'); }
else{ console.log('[거짓1] 10이 더 작다.'); }
		// vs 삼항연산자 [ 가독성 떨어짐 ]
10 >3 ? console.log('[참2]') : console.log('[거짓2]')

// 4. if 형태4
if( 10 >= 20 ){ console.log( '[참1] 10이 20보다 이상') }			// 만약에 10>=20 이면
else if ( 10 >= 15 ) { console.log ('[참2] 10이 15보다 이상') } 	// 아니면서 만약에 10>=15 이면
else if ( 10 >= 10 ) { console.log ('[참3] 10이 10보다 이상') } 	// 아니면서 만약에 10>=10 이면
else{console.log('[거짓] 10이 10미만이다.') } 						// 그 외
		// vs 삼항연산자
10>=20 ? console.log( '[참1] 10이 20보다 이상') :
10>=15 ? console.log ('[참2] 10이 15보다 이상') :
10>=10 ? console.log ('[참3] 10이 10보다 이상') : console.log('[거짓] 10이 10미만이다.')

/*
	1. prompt 로 정수 1개 입력받아 90 이상이면 '합격' 아니면 '탈락' 출력 console 출력
	2. prompt 로 성별을 입력받아 
		'm' 또는 'M' 또는 '남' 또는 '남자' 일경우 '남자 이군요' 출력
		'w' 또는 'W' 또는 '여' 또는 '여자' 일경우 '남자 이군요' 출력
		그외 '남자 : m, M, 남, 남자 / 여자 : w, W, 여, 여자 로 입력해주세요' 라고 console 출력
	3. prompt 로 점수 1개 입력받아
		90점 이상이면 'A등급'
		80점 이상이면 'B등급'
		70점 이상이면 'C등급'
		그 외 '탈락'
*/

// 1. 
let question1 = Number(prompt('[1] 점수를 입력해주세요'))
if ( question1 >= 90 ) { console.log('합격') }
else { console.log('불합격') }

// 2.
let question2 = prompt('[2] 성별을 입력해주세요')
if ( question2 == 'm' || question2 == 'M' || question2 == '남' || question2 == '남자')
	{ console.log('남자 이군요') }
else if ( question2 == 'w' || question2 == 'W' || question2 == '여' || question2 == '여자')
	{ console.log('여자 이군요') }
else { console.log('남자 : m, M, 남, 남자 / 여자 : w, W, 여, 여자 로 입력해주세요') } 

// 3. 
let question3 = Number(prompt('[3] 점수를 입력해주세요'))
if ( question3 >= 90 ) { console.log('A등급') }
else if ( question3 >= 80 ) {console.log('B등급') }
else if ( question3 >= 70 ) { console.log('C등급') }
else { console.log('탈락') }








