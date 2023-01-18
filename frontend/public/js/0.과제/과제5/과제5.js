

// 등록된 카테고리 목록
let categoryList = [ '프리미엄', '스페셜', '와퍼', '올데이킹', '치킨버거' ]

// 등록된 버거 목록
let burgerList = [
	{ name: '기네스와퍼', price: 10000, img: '기네스와퍼.png', category: '프리미엄' },
	{ name: '스태커3와퍼', price: 9500, img: '스태커3와퍼.png', category: '와퍼' },
	{ name: '오믈렛킹모닝', price: 7000, img: '오믈렛킹모닝.png', category: '올데이킹' }
]


let cartList = [] // 카트 목록
let orderList = [] 

categoryPrint();
categoty_select( 0 );
productPrint( 0 );

// 1. 카테고리 출력하는 함수 // [1. js 열렸을때 ]
function categoryPrint(){
	
	// 1. html 구성
	let html = `<ul>`
				
	// *
	for( let i=0 ; i<categoryList.length ; i++ ){
		html += `<li class="categoryli" onclick="categoty_select( ${i} )"> ${ categoryList[i] } </li>`
	}
	html += `</ul>`
				
	// 2. 해당 마크업에 html 출력
	document.querySelector('.categorybox').innerHTML = html
	
}

// 2. 카테고리 선택 함수
function categoty_select( i ){
	// 1. 모든 li 가져와서 배열에 저장
	let categoryli = document.querySelectorAll(".categoryli")
	
	// 2. 모든 li 배열에 반복문
	for( let j=0 ; j<categoryList.length ; j++ )
		if( j == i ){ // 만약에 li 배열에서 내가 선택한 li 인덱스와 같으면
			categoryli[j].classList.add( 'categoryselect' ) ; // 해당 마크업의 class 식별자 추가			
		}else{ // 선택되지 않은 li
			categoryli[j].classList.remove( 'categoryselect' ) ; // 해당 마크업의 class 식별자 제거
		}
	// 3. 제품목록 렌더링 [ 화면 업데이트 ]
	productPrint( i )
}


// 3. 제품 출력 함수 // [ 1. js 열렸을때 / 2. 카테고리 바뀌었을때 ]
function productPrint( index ){
	// 1. html 구성
	let html = ''
	 
	for( let i=0 ; i<burgerList.length ; i++ ){
		// i는 0번째 인덱스부터 마지막 인덱스까지 버거 객체 가져온다.
		
		if( burgerList[i].category == categoryList[index]){
			// i번째 버거객체의 카테고리와 선택된 카테고리가 같으면 
			html = `<div class="product" onclick="cartAdd( ${ i } )">
						<img src="img/${ burgerList[i].img }" width="100%"/>
						<div class="productinfo">
							<div class="ptitle">${burgerList[i].name} </div>
							<div class="pprice">~${ burgerList[i].price.toLocaleString() } 원 </div>
						</div>
					</div>`
		}
	}
	
	// 2. 구성된 html 마크업에 대입
	document.querySelector('.productbox').innerHTML = html
}


// 4. 선택된 제품을 카트에 담기
function cartAdd(i){
	// 1. 선택한 i번째 버거의 객체를 cartlist에 추가
	cartList.push( burgerList[i] )	
	cart_print() // 카트 내 제품 화면 랜더링 (새로고침)
	
}

// 5. 주문 취소
function cancel(){
	alert('주문을 취소합니다.')
	cartList.splice(0);
	cart_print() // 카트 내 제품 화면 랜더링 (새로고침)
}


// 6. 주문 하기 버튼 
function order(){
	alert('주문 합니다.');
	
	console.log( '주문하기전' ) 
	console.log( cartList ) 
	// 1. 주문번호 만들기 // 마지막인덱스 : 배열명.length-1
	let no = 0;
		// 1. 만약에 길이가 0이면 [ 주문이 하나도 없으면 주문번호 1 ]
	if( orderList.length == 0 ){ no = 1 ;}
		// 2. 아니면 마지막인덱스의 주문객체의 주문번호+1 를 다음 주문번호 사용 
	else{ no = orderList[ orderList.length-1 ].no+1 }
	
	// 2. 카트배열 -> 새로운 배열 [ 주문객체에 카트배열 대입시 카트배열 초기화시 주문객체내 카트배열도 초기화 = 메모리 동일하기 때문에 ]
	let 새로운배열 = cartList.map( (o)=>{ return o; } )
	
	// 3. 총 가격 만들기
	let total = 0;
	for( let i=0 ; i<새로운배열.length ; i++ ){ total += cartList[i].price }
			
	
	// 1. 주문
		// 1. order 객체 만들기
		let order = { 
			no : no,
			items : 새로운배열,		// 카트배열 ---> 새로운배열 
			time : new Date(), 	// new Date() : 현재 날짜/시간 호출 함수 
			state : true ,		// true : 일단 주문 // false : 주문 전 
			complete : 0,		// 아직 주문 완료 되기 전
			price : total
		}
		
		// 2. order 객체 배열에 저장
		console.log( '주문 후 ' ) 
		console.log( orderList )
		
		
	orderList.push( order )
	
	// 2. 주문완료 후
	 
	cartList.splice(0)
	cart_print();
}



// 7. 카트 내 버거 출력 [ 1. 제품 클릭할때 마다 / 2. 취소/주문 ]
function cart_print(){
	// 2. 버거 개수 카운트
	document.querySelector('.pcount').innerHTML = cartList.length
	// 3. 버거 총 개수
	let total = 0;
	for( let j=0 ; j<cartList.length ; j++ ){ total += cartList[j].price }
	document.querySelector('.ptotal').innerHTML = total.toLocaleString()
	// 4. 버거 출력
		// 1. 기본 html 구성
	let html = '';
	for( let j=0 ; j<cartList.length ; j++ ){
		html += `<div class="item">
					<div class="ititle"> ${ cartList[j].name } </div>
					<div class="iprice"> ${ cartList[j].price.toLocaleString() } 원 </div>
				</div>`
	}
		// 2. 구성된 html 마크업에 대입
	document.querySelector('.cartbottom').innerHTML = html
}












 