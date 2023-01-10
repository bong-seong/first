/*

	JS 연산자
		1. 산술연산자 : 더하기(+), 빼기(-), 곱하기(*), 나누기(/), 나머지(%)
		
		2. 연결연산자 : +
			숫자+숫자 : 산술연산자 / 문자+숫자 : 연결연산자 / 문자+문자 : 연결연산자
			
		3. 비교연산자 :  > (초과)[크다],  		< (미만)[작다],  			>= (이상)[크거나 같다],  		<=(이하)[작거나 같다]
				     == (같다)[데이터만비교], 	=== (같다)[데이터/자료형 비교]
				     != (같지않다)[아니다/제외] 	!== (같지않다)[데이터/자료형 비교]
				     
		4. 관계연산자 : 비교연선자가 2개 이상일때
						&& : and 이면서 면서 이고 모두 그리고	[ 비교연산자 결과가 모두 참이면 참 ]
							10<a<20 [ x ] ==> a>10 && a<20 [ o ]
						|| : or 이거나 거나 또는 하나라도		[ 비교연산자 결과가 하나라도 참이면 참]
						!  : 부정 반대						[ 비교연산자 결과가 참이면 거짓 ]
						
		5. 대입연산자 : 
				   = 대입 [오른쪽에서 왼쪽으로 대입]
				   += 더한 후에 대입 [ 오른쪽 데이터를 왼쪽에 더한 후 대입]
				   		변수명 = 변수명 + 3		vs		 변수명 += 3
				   		-= *= /= %= 
				   		
		6. 증감연산자 : 
					변수++ 	[ 후위 1증가 ]			변수--	[ 후위 1감소 ] 
					++변수	[ 선위 1증가 ]			--변수	[ 선위 1감소 ]
		
		7. 삼항연산자 : 만약에 조건이 참이면 참 반환 / 거짓이면 거짓 반환
				   1. 조건 ? 참 : 거짓
				   	ex) 나이 >= 19 ? '성인' : '청소년'
				   2. 중첩
				   	조건1 ? 참1 : 
				   			조건2 ? 참2 : 
				   					조건3 ? 참3 : 거짓
				   	ex) 나이 <= 19 ? '청소년' :
				   					나이 <= 40 ? '청년 : 
				   								나이 <= 60 ? '중년' : '노년' 
*/

// 1. 산술연산자
console.log( 3+3 )					// 숫자 + 숫자 : 산술연산자 ==> 6
console.log( '더하기 : ' + 3+3 )     	// 문자 + 숫자 : 연결연산자 ==> 33
console.log( '더하기 : ' + (3+3) ) 	// 문자 + (숫자+숫자) : 괄호를 활용해 숫자+숫자 우선처리 ==> 6
console.log( '빼기 : ' + (3-2) )		
console.log( '곱하기 : ' + (3*2) ) 	
console.log( '나누기 : ' + (10/2) ) 	
console.log( '나머지 : ' + (10%3) )  // 몫 제외한 나머지 !!

// 2. 비교연산자
console.log( '초과: ' + (10>3) ) 
console.log( '미만: ' + (10<3) )
console.log( '이상: ' + (10>=3) )
console.log( '이하: ' + (10<=3) )
console.log( '같다: ' + (10==3) )
console.log( '같지않다: ' + (10!=3) )

//3. 관계연산자
console.log( '&& : ' + (10>3 && 10>5) )		// T and T -> T   /   T and F -> F
console.log( '|| : ' + (10>3 || 3>5) )		// T or F -> T
console.log( '! : ' + !(10>3) ) 			// T -> F         /   F -> T



/*
	문제1
	1. 국어, 영어, 수학 점수를 입력받아 변수에 저장
	2. 총점 출력, 평균 출력
			
*/

/*let kor = Number(prompt( '국어점수를 입력하세요' ))
// 'kor' 라는 이름으로 변수 선언하고 prompt 입력받은 문자 데이터를 저장 
// 기본값으로 문자열로 입력받기떄문에 Number() 사용해 입력받는 데이터를 숫자로 변환한다
let eng = Number(prompt( '영어점수를 입력하세요' ))
let mat = Number(prompt( '수학점수를 입력하세요' ))

let tot = kor+eng+mat
let avr = (kor+eng+mat)/3

console.log( '총점 : ' + (kor+eng+mat) )
console.log( '총점 : ' + tot )
console.log( '평균 : ' + (kor+eng+mat)/3 )
console.log( '평균 : ' + avr ) */



/*
	문제2 : prompt 함수 로 반지름을 입력받아서 원 넓이 출력 [ 반지름*반지름*3.14 ]
	문제3 : prompt 함수 로 두 실수를 입력받아서 앞 실수의 값이 뒤 실수의 값의 몇% 인지 출력
		- 54.5 		84.3  	결과 : 64%
	문제4 : prompt 함수 로 정수를 입력받아 홀수[ture] / 짝수[false] 여부 출력
	문제5 : prompt 함수 로 정수를 입력받아 7배수이면 ture / 아니면 false 출력
	문제6 : prompt 함수 로 십만원 단위의 금액을 입력받아 지폐 개수 세기
		356789		결과 : 십만원 3장 / 만원 5장 / 천원 6장
	문제7 : prompt 함수 로 아이디와 비밀번호를 입력받아 아이디가 admin 이고 비밀번호가 1234 이면 
		   로그인 성공 출력 아니면 로그인 실패 출력
	문제8 : primpt 함수 로 정수를 입력받아 홀수 이면서 7배수이면 ture 아니면 false
*/

// 문제2 : prompt 함수 로 반지름을 입력받아서 원 넓이 출력 [ 반지름*반지름*3.14 ]
/*let value1 = Number(prompt( '반지름을 입력하세요'))
let result_circle = ( value1*value1*3.14 )
console.log('원 넓이 : ' + result_circle )*/

// 문제3 : prompt 함수 로 두 실수를 입력받아서 앞 실수의 값이 뒤 실수의 값의 몇% 인지 출력
/*let value2 = Number(prompt('첫번째 값을 입력하세요'))
let value3 = Number(prompt('두번째 값을 입력하세요'))
let result_per = ( value2/value3*100 )
console.log( value2 + '는 ' + value3 + '의 ' + result_per + '% 입니다.')*/

// 문제4 : prompt 함수 로 정수를 입력받아 홀수[ture] / 짝수[false] 여부 출력
/*let holjjack = Number( prompt('값을 입력하세요') )
let hol_result = holjjack%2 == 1
console.log('홀수(true), 짝수(false) 결과 : ' + hol_result)*/
				// 홀수찾기 : 수%2 == 1 나머지가 1이면 홀수 0이면 짝수
				// 짝수찾기 : 수%2 == 0 나머지가 0이면 짝수 1이면 홀수

// 문제5 : prompt 함수 로 정수를 입력받아 7배수이면 ture / 아니면 false 출력
/*let seven = Number( prompt('값을 입력하세요') )
let seven_result = seven%7 == 0
console.log('7의 배수인가요? ' + seven_result)*/
				// 배수찾기 : 수%값 == 0 나머지가 0이면 수는 해당 값의 배수

// 문제6 : prompt 함수 로 십만원 단위의 금액을 입력받아 지폐 개수 세기 [ 몫 : parseInt(3.14) -> 3 ]
/*
let price = Number( prompt('금액을 입력하세요') )

console.log('입력받은 금액 : ' + price )
console.log('십만원권 : ' + parseInt(price/100000) +'장')
// ! : 금액에서 십만원 제외
price = price - parseInt( price/100000 ) * 100000
	// 356789 - 300000 -> 56789
		/* 연산순서
			1. ( price/100000 )				3.56789
			2. parseInt( price/100000 ) 	3
			3. * 100000						300000
			4. price - 300000				56789
			5. price = 56789				새로운 값 변경
		
console.log('만원권 : ' + parseInt(price/10000) + '장')
price = price - parseInt( price/10000 ) * 10000
		 연산순서
			1. ( price/10000 )				5.6789
			2. parseInt( price/10000 )  	5
			3. * 10000						50000
			4. price - 50000				6789
			5. price = 6789					새로운 값 변경
		
console.log('천원권 : ' + parseInt(price/1000) + '장')	*/


// 문제7 : prompt 함수 로 아이디와 비밀번호를 입력받아 아이디가 admin 이고 비밀번호가 1234 이면 로그인 성공 출력 아니면 로그인 실패 출력
/*let user_id = prompt('아이디를 입력하세요') 
let user_pwd = prompt('패스워드를 입력하세요') 
let login_result = ( user_id == 'admin' && user_pwd == '1234' )

console.log( '로그인상태 : ' + login_result )*/


// 문제8 : prompt 함수 로 정수를 입력받아 홀수 이면서 7배수이면 ture 아니면 false
/*let value7 = Number(prompt('값을 입력하세요'))
let result7 = value7%2 == 1 && value7%7 == 0
console.log('홀수이면서 7배수인가? ' + result7 )*/


// 4. 대입연산자
let data1 = 10		// 1. = 대입 [ 선언과 동시에 대입 = 초기화 ]

data1 += 2			// vs data1 = data1 + 2
					// 1. 10+2 --> 12
					// 2. data1 = 12
console.log( '+= 대입 후 : ' + data1 )		// 10+2 --> 12

data1 -= 5
console.log( '-= 대입 후 : ' + data1 )		// 12-5 --> 7
data1 *= 2
console.log( '*= 대입 후 : ' + data1 )		// 7*2 --> 14
data1 /= 3
console.log( '/= 대입 후 : ' + data1 )		// 14/3 --> 4.6~~~
data1 %= 3
console.log( '%= 대입 후 : ' + data1 ) 		//  4.6~%3 --> 1.6~~~


let html = '<h3> JS 작성된 코드 </h3>'			// html 마크업 저장할 변수 선언
document.write( html )
html += '<div> 안녕하세요 </div>'				// 변수에 마크업 추가
document.write( html );						// 해당 변수를 html 출력


// 5. 증감연산자 [ data++ , data+=1 , data = data+1 ]
let data2 = 10;
console.log( '변수 값 : ' + data2 )			// 10
console.log( '변수++ : ' + (data2++))			// 10 : 출력 후 증가
console.log( '변수 값 : ' + data2 )			// 확인 : 11
console.log( '++변수 : ' + (++data2))			// 12 : 출력 전 증가

console.log( '변수-- : ' + (data2--))			// 12 : 출력 후 감소
console.log( '변수 값 : ' + data2 )			// 확인 : 11
console.log( '--변수 : ' + (--data2))			// 10 : 출력 전 감소

// 6. 삼항연산자 [ 조건 ? 참 : 거짓 ]
let age = 30 ;
let age_range = age<=19 ? '청소년' : '성인'		// 30 <= 19 false  --> 조건이 false 이므로 '성인' 대입
console.log( '30의 나이대 : ' + age_range )

let sum = 78 ;
let grade = sum>=90 ? 'A Class' : 			// 점수가 90점 이상이면 A class
			sum>=80 ? 'B class' : 			// 점수가 80점 이상이면 B class
			sum>=70 ? 'C class' : 'Fail' 	// 점수가 70점 이상이면 C class : 아니면 'Fail'
console.log( '78점의 등급 : ' + grade )



/*
	문제9 : 정수를 입력받아서 '홀수'인지 '짝수'인지 출력
	문제10 : 정수 2개를 입력받아 더 큰 수를 출력
	문제11 : 정수 3개를 입력받아 가장 큰 수를 출력
	문제12 : 정수 3개를 입력받아 오름차순으로 출력
*/

// 문제9 : 정수를 입력받아서 '홀수'인지 '짝수'인지 출력
/*let hj = Number( prompt('값을 입력하세요') )
let hj_result = hj%2 == 1 ? '홀수' : '짝수'
console.log( '홀수/짝수 여부 : ' + hj_result )*/


// 문제10 : 정수 2개를 입력받아 더 큰 수를 출력
/*let num1 = Number( prompt('첫번째 값을 입력하세요') )
let num2 = Number( prompt('두번째 값을 입력하세요') )
let num_result = num1 > num2 ? num1 :
				 num2 > num1 ? num2 : '같다'
console.log( num1 + '과 ' + num2 + ' 두개의 수 중 더 큰 수는 ' + num_result + '입니다.' )*/

// 문제11 : 정수 3개를 입력받아 가장 큰 수를 출력
/*let num3 = Number( prompt('첫번째 값을 입력하세요') )
let num4 = Number( prompt('두번째 값을 입력하세요') )
let num5 = Number( prompt('세번째 값을 입력하세요') )
let max = num3	// 가장 큰수 변수에 첫번쨰 값 대입
max = max < num4 ? num4 : max // 만약에 max 보다 더 크면 max 에 대입 / max : 가장 큰 수를 저장하는 변수
max = max < num5 ? num5 : max 
console.log(num3 + ", " + num4 + ", " + num5 + ' 세개의 수 중 더 큰 수는 ' + max + '입니다.' )*/

// 문제12 : 정수 3개를 입력받아 오름차순으로 출력
let n1 = Number( prompt('첫번째 값을 입력하세요') )
let n2 = Number( prompt('두번째 값을 입력하세요') )
let n3 = Number( prompt('세번째 값을 입력하세요') )

let top1 = n1
let middle1 = n2
let bottom1 = n3

top1 = n1 < n2 && n3 < n2 ? n2 :
       n1 < n3 && n2 < n3 ? n3 : top1

middle1 = n1 < n2 && n1 > n3 ?  n1 :
          n1 > n2 && n1 < n3 ?  n1 :
          n3 < n2 && n3 > n1 ?  n3 :
          n3 > n2 && n3 < n1 ?  n3 : middle1

bottom1 = n1 < n3 && n1 < n2 ? n1 :
          n2 < n3 && n2 < n1 ? n2 : bottom1
         

console.log( n1 + ", " + n2 + ", " + n3 + " 입력한 세 수의 오름차순 정렬은" + top1 + ", " + middle1 + ", " + bottom1 )




 



























