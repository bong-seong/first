/*
	- 출력
	출력 : console.log( )
	알람메시지출력 ㅣ: alert( )
	HTML 출력 : 
		1. document.write( )
		2. document.querySelector( ).innerHTML
		
	- 입력
		1. 알림메시지입력 : prompt( )
		2. html입력 : document.querySelector( ).value
	         	      
*/

let output = '' // 출력변수
// 1. 입력받은 수 만큼 * 출력

/*let s1 = Number( prompt( '예시1 별 개수' ) )
for( let i=1 ; i<=s1 ; i++ ){ // for start
	// i는 1부터 입력받은 수까지 1씩 증가
	output += '*' // = 대입[기존데이터 없어짐] vs += 누적대입[기존데이터에 추가]
} // for end
console.log( output )
*/

/*
output = '' // 앞전에서 사용한 output 변수를 다시 '' [공백] 으로 변경
// 2. 입력받은 수 만큼 * 출력 [ 3줄(3배수)마다 줄바꿈 ]

let s2 = Number( prompt( "예시2 별 개수" ) )
for (let i=1 ; i<=s2 ; i++ ){ // for start
	// 1. 별출력
	output += '*'
	// 2. 줄바꿈출력
	if( i % 3 == 0 ){ output += "\n" }
} // for end
console.log( output )
*/

/*
output = ''
// 문제1. 입력받은 줄수[line]만큼 출력


let line1 = Number( prompt( '문제1' ) ) 
for(let i=1 ; i<=line1 ; i++ ){
	// 1. 별 찍기
	for(let s=1 ; s<=i ; s++ ){ output += '*' }
	// 2. 줄 바꿈
	output += '\n'
}
console.log( output )
*/


/*output = ''	
// 문제2. 입력받은 줄수 [line]만큼 출력 [역방향]
let line2 = Number( prompt( '문제2' ) )
for(let i=1 ; i<=line2 ; i++ ){
	for(let s=1 ; s<=line2-i+1 ; s++ ){
		output += '*'
	}
	output += '\n'
}
console.log( output )*/


/*							  [ line2-i+1 ]
i=1		s=1 2 3 4 5		입력받은줄수 5 - i [1] + 1 = 5
i=2		s=1 2 3 4   	입력받은줄수 5 - i [2] + 1 = 4
i=3		s=1 2 3 		입력받은줄수 5 - i [3] + 1 = 3
i=4		s=1 2       	입력받은줄수 5 - i [4] + 1 = 2
i=5		s=1         	입력받은줄수 5 - i [5] + 1 = 1
*/ 



// 문제3. 입력받은 줄수 [line] 만큼 출력
//       *		공백 [4]			별 [1] 
//      **		공백 [3]	-1		별 [2] +1
//     ***		공백 [2]	-1		별 [3] +1
//    ****		공백 [1]	-1		별 [4] +1
//   *****		공백 [0]	-1		별 [5] +1		
/*output = ''	
let line3 = Number( prompt( '문제3' ) )
for( let i=1 ; i<=line3 ; i++ ){
	for( let b=1 ; b<=line3-i ; b++ ){
		output += ' '
	}
	for( let s=1 ; s<=i ; s++ ){
		output += '*'			
	}
	output += '\n'
}
console.log( output )*/
/*
	line3 = 5 일때 
	i=1 일때, b = 5-1 = 4 [공백 4개], s=1 [별 1개]
	i=2 일때, b = 5-2 = 3 [공백 3개], s=2 [별 2개]
	i=3 일때, b = 5-3 = 2 [공백 2개], s=3 [별 3개]
	i=4 일때, b = 5-4 = 1 [공백 1개], s=4 [별 4개]
	i=5 일때, b = 5-5 = 0 [공백 0개], s=5 [별 5개]
	i=6 일때, i<=line3 False 이므로 반복문 종료 
*/


// 문제4. 입력받은 줄수 [line] 만큼 출력
//     *****		공백 [0]			별 [5] 
//      ****		공백 [1]	+1		별 [4] -1
//       ***		공백 [2]	+1		별 [3] -1
//        **		공백 [3]	+1		별 [2] -1
//         *		공백 [4]	+1		별 [1] -1
// i=line4 ; b=i-1=0 ; s=line4-i+1
/*output=''
let line4 = Number( prompt( '문제4' ) )
for( let i=1 ; i<=line4 ; i++ ){
	for( let b=1 ; b<=i-1 ; b++ ){
		output += ' '
	}
	for( let s=1 ; s<=line4-i+1 ; s++ ){
		output += '*'		
	}
	output += '\n'
}
console.log( output )*/


// 문제5. 입력받은 줄수 [line] 만큼 출력
//     *		공백 [4]			별 [1] 
//    ***		공백 [3]	-1		별 [3] +2
//   *****		공백 [2]	-1		별 [5] +2
//  *******		공백 [1]	-1		별 [7] +2
// *********	공백 [0]	-1		별 [9] +2
// i=line5 ; b=line5-1 ; s=      
/*output=''
let line5 = Number( prompt( '문제5' ) )
for( let i=1 ; i<=line5 ; i++ ){
	
	// 1. 공백
	for( let b=1 ; b<=line5-i ; b++ ){
		output += ' '
	}
	
	// 2. 별
	for( let s=1 ; s<=i*2-1 ; s++ ){
		output += '*'		
	}
	
	// 3. 줄 바꿈
	output += '\n'
}
console.log( output )*/
/*
	i=1 값 : 5
		b=1		1<=5-1 4 T	output = ' '
		b=2		2<=5-1 4 T	output = '  '
		b=3		3<=5-1 4 T	output = '   '
		b=4		4<=5-1 4 T	output = '    '
		b=5		5<=5-1 4 F
		
		s=1     1<=1*2-1 1 T	output = '    *'
		s=2     2<=1*2-1 1 F				
	\n
	
	i=2
		b=1		1<=5-1 4 T	output = ' '
		b=2		2<=5-1 4 T	output = '  '
		b=3		3<=5-1 4 T	output = '   '
		b=4		4<=5-1 4 T	output = '    '
		b=5		5<=5-1 4 F
		
		s=1     1<=2*2-1 3 T	output = '    *\n    *'
		s=2     2<=2*2-1 3 T	output = '    *\n    **'
		s=3     3<=2*2-1 3 T	output = '    *\n    ***'
		s=4     3<=2*2-1 3 F
	\n
	
	i=3
		b=1		1<=5-2 3 T	output = ' '
		b=2		2<=5-2 3 T	output = '  '
		b=3		3<=5-2 3 T	output = '   '
		b=4		4<=5-2 3 F
		
		s=1     1<=3*2-1 5 T	output = '    *\n    ***\n   **'
		s=3     2<=3*2-1 5 T	output = '    *\n    ***\n   ***'
		s=4     3<=3*2-1 5 T	output = '    *\n    ***\n   ****'
		s=5     4<=3*2-1 5 T	output = '    *\n    ***\n   *****'
		s=6     5<=3*2-1 5 F
*/


/*
   *     *		별	공백	공백	공백	공백	공백	별
	*   *		별 	공백 	공백 	공백 	별
	 * *    	공백 	별 	공백 	별 
	  *			공백 	공백 	별 
	 * *		공백	별	공백	별	
	*   *		별	공백	공백	공백	별
   *     *  	별 	공백	공백 	공백	공백	공백	별	

	i=1
		b=F
		s=T
		s=F
	\n
*/
output = '' 
let line6 = Number( prompt( 'X 모양' ) )
for( let i=1 ; i<=line6 ; i++ ){
	for( let s=1 ; s<=line6 ; s++ ){
		if( i == s || s == line6+1-i ){ output += '*' }
		else { output += ' ' }
	}
	output += '\n'
}
console.log( output )

/*
	line6 = 5
	i=1 		s=1			1<=5			(5+1-1)5 = 1 성립 X || i(1) == s(1) 조건성립 O 조건에의해 output = '*'				
				s=2			2<=5			(5+1-1)5 = 2 성립 X || i(1) == s(2) 조건성립 X else 에 의해 output = ' ' 공백추가
				s=3			3<=5			(5+1-1)5 = 3 성립 X || i(1) == s(3) 조건성립 X else 에 의해 output = ' ' 공백추가
				s=4			4<=5			(5+1-1)5 = 4 성립 X || i(1) == s(4) 조건성립 X else 에 의해 output = ' ' 공백추가
				s=5			5<=5			(5+1-1)5 = 5 성립 O 조건에 의해 output = '*'
				s=6			6<=5 			조건성립 X for 문 종료 ===> i=1 에대한 최종 누적 output = '*   *' 별 공백 공백 공백 별
	\n 에 의한 줄바꿈 output 누적
	
	
	i=2			s=1			1<=5			(5+1-2)4 = 1 성립 X || i(2) == s(1) 조건성립 X else 에 의해 output = ' ' 공백추가	
 				s=2			2<=5			(5+1-2)4 = 2 성립 X || i(2) == s(2) 조건에의해 output = '*'
 				s=3			3<=5			(5+1-2)4 = 3 성립 X || i(2) == s(3) 조건성립 X else 에 의해 output = ' ' 공백추가
 				s=4			4<=5			(5+1-2)4 = 4 성립 O 조건에 의해 output = '*'
 				s=5			5<=5			(5+1-2)4 = 5 성립 X || i(2) == s(5) 조건성립 X else 에 의해 output = ' ' 공백추가
 				s=6			6<=5			조건성립 X for 문 종료 ===> i=2 에대한 최종 누적 output = ' * * '
 	\n 에 의한 줄바꿈 output 누적
 	
 	
 	i=3			s=1			1<=5			(5+1-3)3 = 1 성립 X || i(3) == s(1) 조건성립 X else 에 의해 output = ' ' 공백추가
 				s=2			2<=5			(5+1-3)3 = 2 성립 X || i(3) == s(2) 조건성립 X else 에 의해 output = ' ' 공백추가
 				s=3			3<=5			(5+1-3)3 = 3 성립 O 조건에 의해 output = '*'
 				s=4			4<=5			(5+1=3)3 = 4 성립 X || i(3) == s(4) 조건성립 X else 에 의해 output = ' ' 공백추가
 				s=5			5<=5			(5+1=3)3 = 5 성립 X || i(3) == s(5) 조건성립 X else 에 의해 output = ' ' 공백추가
 				s=6			6<=5			조건성립 X for 문 종료 ===> i=3 에대한 최종 누적 output = '  *  '
 	\n 에 의한 줄바꿈 output 누적
 	
 	
 	i=4			s=1			1<=5			(5+1-4)2 = 1 성립 X || i(4) == s(1) 조건성립 X else 에 의해 output = ' ' 공백추가
 				s=2			2<=5			(5+1-4)2 = 2 성립 O 조건에 의해 output = '*'
 				s=3			3<=5			(5+1-4)2 = 3 성립 X || i(4) == s(3) 조건성립 X else 에 의해 output = ' ' 공백추가
 				s=4			4<=5			(5+1-4)2 = 4 성립 X || i(4) == s(4) 조건성립 O 조건에 의해 output = '*'
 				s=5			5<=5			(5+1-4)2 = 5 성립 X || i(4) == s(5) 조건성립 X else 에 의해 output = ' ' 공백추가
 				s=6			6<=6			조건성립 X for 문 종료 ===> i=4 에대한 최종 누적 output = ' * * '
 	\n 에 의한 줄바꿈 output 누적
 	
 	
 	i=5			s=1			1<=5			(5+1-5)1 = 1 성립 O 조건에 의해 output = '*'
 				s=2			2<=5			(5+1-5)1 = 2 성립 X || i(5) == s(2) 조건성립 X else 에 의해 output = ' ' 공백추가
 				s=3			3<=5			(5+1-5)1 = 3 성립 X || i(5) == s(3) 조건성립 X else 에 의해 output = ' ' 공백추가
 				s=4			4<=5			(5+1-5)1 = 4 성립 X || i(5) == s(4) 조건성립 X else 에 의해 output = ' ' 공백추가
 				s=5			5<=5 			(5+1-5)1 = 5 성립 X || i(5) == s(5) 조건성립 O 조건에 의해 output = '*'
 				s=6			6<=5			조건성립 X for 문 종료 ===> i=5 에대한 최종 누적 output = '*   *'
 	\n 에 의한 줄바꿈 output 누정
 	
 	
 	i=6   		6<=5 조건에 의해 for 문 종료
 	최종 : *   *		\n
 		   * *		\n
			* 		\n
		   * *		\n
		  *   *   	\n
 	
	
*/	







// 과제1 : 아래 코드 실행
// 확인/검토/설명 : 2인1조 [ 풀이 설명 ]
//
//     *		공백 [4]			별 [1] 
//    ***		공백 [3]	-1		별 [3] +2
//   *****		공백 [2]	-1		별 [5] +2
//  *******		공백 [1]	-1		별 [7] +2
// *********	공백 [0]			별 [9] 
// *********	공백 [0]			별 [9] 
//  *******		공백 [1]	+1		별 [7] -2
//   *****		공백 [2]	+1		별 [5] -2
//    ***		공백 [3]	+1		별 [3] -2
//     *		공백 [4]			별 [1] 

output = ''
let line7 = Number( prompt( '과제' ) )
for( let i=1 ; i<=line7 ; i++ ){
	
	// 1. 공백
	for( let b=1 ; b<=line7-i ; b++ ){
		output += ' '
	}
	
	// 2. 별
	for( let s=1 ; s<=i*2-1 ; s++ ){
		output += '*'		
	}
	
	// 3. 줄 바꿈
	output += '\n'
}

for( let i=1 ; i<=line7 ; i++ ){
	
	// 1. 공백
	for( let b=1 ; b<=i-1 ; b++ ){
		output += ' '
	}
	
	// 2. 별
	for( let s=1 ; s<=(line7-i)*2+1 ; s++ ){
		output += '*'		
	}
	
	// 3. 줄 바꿈
	output += '\n'
}
console.log( output )

/* 

	1<=(line7-i)*2+1
	line7 = 5
	
	i=1		1<=5-1*2+1	1<=9
						1<=8
						1<=7
						1<=6
						1<=5
						1<=4
							
					
	i=2		1<=5-2		
	i=3		1<=5-3		
	i=4		1<=5-4		
	i=5		1<=5-5

	
	i=1 		b=1 2 3 4 		s=1
	i=2			b=1 2 3			s=1 2 3
	i=3			b=1 2			s=1 2 3 4 5
	i=4			b=1				s=1 2 3 4 5 6 7
	i=5			b=0				s=1 2 3 4 5 6 7 8 9
	
	i=1			b=0				s=1 2 3 4 5 6 7 8 9
	i=2	        b=1				s=1 2 3 4 5 6 7
	i=3			b=1 2			s=1 2 3 4 5
	i=4			b=1 2 3 		s=1 2 3
	i=5			b=1 2 3 4  		s=1 	
		
	입력받은 값은 5이고 i 일때 정상피라미드
	조건 : i<=line7 입력받은 값 
	공백조건 : b<=line7 입력받은 값 - i
	별조건 : s<=i * 2 - 1
	
	[입력값 : 5 ]
	[조건 : i<=line7 ]
	i=1		1<=5 True 성립
		
		[조건 : b<=line7-i ]
		b=1		1<=5-1  	>>		1<=4		True		output=' '
		b=2		2<=5-1  	>>		2<=4		True		output='  '
		b=1		3<=5-1  	>>		3<=4		True		output='   '
		b=1		4<=5-1  	>>		4<=4		True		output='    '
		b=1		5<=5-1  	>>		5<=4		False		X
		
		[조건 : s<=i*2-1 ]
		s=1		1<=1*2-1	>>		1<=1		True		output='    *'
		s=2		2<=1*2-1	>>		2<=1		False		x
	\n
	
	i=2		2<=5 True 성립
		
		[조건 : b<=line7-i ]
		b=1		1<=5-2  	>>		1<=3		True		output=' '
		b=2		2<=5-2  	>>		2<=3		True		output='  '
		b=1		3<=5-2  	>>		3<=3		True		output='   '
		b=1		4<=5-2  	>>		4<=3		False		X
		
		[조건 : s<=i*2-1 ]
		s=1		1<=2*2-1	>>		1<=3		True		output='   *'
		s=2		2<=2*2-1	>>		2<=3		True		output='   **'
		s=3		2<=2*2-1	>>		4<=3		True		output='   ***'
		s=4		3<=2*2-1	>>		4<=3		False		X
							
						

*/
































