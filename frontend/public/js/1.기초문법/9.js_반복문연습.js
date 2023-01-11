
// 예1) 1부터 10이하까지 1씩 증가 반복 [ 한줄씩 출력 ]
console.log('-------------------예1-------------------')
for( let i=1 ; i<=10 ; i++ ){ // for start
	console.log ( i )	
} // for end 


// 예2) i는 1부터 10이하까지 1씩 증가 반복 [ 한줄에 모두 출력 ]
console.log('-------------------예2-------------------')
let output = ' ' // 문자 변수 처리하기 위해 공백 사용 [ 깡통 ]
for( let i=1 ; i<=10 ; i++ ){ // for start
	output += i+"\t" // vs output = output + i // 누적 기록
} // for end
console.log( output )


// 예3) i는 1부터 10이하까지 1씩 증가 반복 [ HTML 출력 ]
console.log('-------------------예3-------------------')
output = ' '	// 위에서 사용했기 때문에 다시 ' ' 로 변경 [ 깡통 ]
for( let i=1 ; i<=10 ; i++ ){ // for start
	output += i+"\t"
}// for end
document.querySelector('body').innerHTML = output


// 예4) i는 1부터 10이하까지 1씩 증가 반복 [ 누적 합계 ] 
console.log('-------------------예4-------------------')
let sum = 0;	// 숫자변수
for( let i=1 ; i<=10 ; i++ ){ sum += i }
console.log( sum )

// 예5) i는 1부터 100까지의 7배수 [ 누적 합계 ] 
// 1. [ i+=7 ]
console.log('-------------------예5-------------------')
sum = 0; 
for( let i=0 ; i<=100 ; i+=7 ){ 
	console.log( "i = " + i + "\t" + i + "<=100\t" + (i<=100) + "\t" + sum + "+=" + i + "\t i++" ) 
	sum += i
}
console.log ( sum )

// 2. if ( i % 7 == 0 )
sum = 0;
for( let i=7; i<=100 ; i++ ){ 
	if( i % 7 == 0 ) {
		 sum+=i 
	} 
}
console.log( sum )


// 예6) (2단) 구구단	[ 단 : 2(상수) 	곱 : 변수 ]
console.log('-------------------예6-------------------')

output = ''
for( let 곱=1 ; 곱<=9 ; 곱++ ){ // for start
	// 곱은 1부터 9까지 1씩 증가 하면서 반복 처리
	console.log( " 2 * " + 곱 + " = " + ( 2*곱 ) );	// 변수는 문자처리 X
				// '문자' + 변수 + '문자' + (계산식)
	output += " 2 * " + 곱 + " = " + ( 2*곱 )	 + "<br/>"		// 누계
} // for end
document.querySelector('body').innerHTML = output

// 예7) 구구단
console.log('-------------------예7-------------------')

output = ''
// 1. 단 만들기
for( let dan=2 ; dan<10 ; dan++ ){ // for 1 start
	// dan 2부터 10까지 1씩 증가 반복처리
	//2. 곱 만들기
	for( let gop=1 ; gop<10 ; gop++ ){ // for 2 start
		// 곱 1부터 10까지 1씩 증가 반복처리
		console.log( dan + " X " + gop + " = " + (dan*gop) );
		output +=  dan + " X " + gop + " = " + (dan*gop) + "<br/>"
	} // for 2 end
} // for 1 end
// [ 'dan' 1바퀴 돌때 'gop' 9바퀴 ]
document.querySelector('body').innerHTML = output















