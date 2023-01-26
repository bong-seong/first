
// *-----------------------------------------------------------------------------------* //
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


categoryPrint();		// 카테고리 호출 함수를 호출
categoty_select( 0 );	// 카테고리 선택시 css 변경/카테고리별 제품출력 함수 호출 / 기본값 : 프리미엄


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
			html += `<div class="product" onclick="cartAdd( ${ i } )">
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
			state : true,		// true : 일단 주문 // false : 주문 전 
			complete : 0,		// 아직 주문 완료 되기 전
			price : total
		}
		
		// 2. order 객체 배열에 저장
		
	orderList.push( order )
	
	// 2. 주문완료 후
	 
	cartList.splice(0)
	cart_print();
	orderContol();
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

// ##################################################################################### //
// ########################                                    ######################### //
// ########################            관리자페이지 js             ######################### //
// ########################                                    ######################### //
// ##################################################################################### //

/* 확인용 주석입니다. *******************************************************************

categoryList = [ '프리미엄', '스페셜', '와퍼', '올데이킹', '치킨버거' ]

// 등록된 버거 목록
	burgerList = [
	{ name: '기네스와퍼', price: 10000, img: '기네스와퍼.png', category: '프리미엄' },
	{ name: '스태커3와퍼', price: 9500, img: '스태커3와퍼.png', category: '와퍼' },
	{ name: '오믈렛킹모닝', price: 7000, img: '오믈렛킹모닝.png', category: '올데이킹' }
]

cartList = [] // 카트 목록
orderList = [] 

확인용 주석입니다. ******************************************************************* */

totalBurger() // 제품 리스트 출력용 함수호출


// 입력 버튼을 눌렀을때 정보를 객체에 담는 함수
function addBurger(){
	
	let newBurger = {
		name: document.querySelector('.n_name').value, 
		category: document.querySelector('.n_category').value,
		price: parseInt(document.querySelector('.n_price').value),
		img: document.querySelector('.n_img').value
	}
	
	// 유효성검사 : 카테고리 배열에 존재하는 카테고리만 입력가능
		// ! : 부정 not / true -> false / false -> true 
	if( !categoryList.includes( newBurger.category ) ){
			alert('존재하지 않는 카테고리입니다. [등록실패]')
			return;
	}
	// 유효성검사 : 문자입력 불가능 / 숫자형식만 입력가능
	if( isNaN(newBurger.price) ){ alert('가격은 숫자 형식만 입력가능합니다. [등록실패] '); return; }
	
	burgerList.push( newBurger )
	
	// 3. 키오스크쪽 프론트 새로고침
	categoty_select( 0 );
	totalBurger()
	
}
/*

	모든 조건을 검사 하고 여러개의 true		   하나의 true
	if( 조건1 ){}
	if( 조건2 ){}
	if( 조건3 ){}
	
		vs								true 인경우 return 사용하면 차이점 없음
	
	모든 조건을 검사 하고 하나의 true
	if( 조건1 ){}
	else if( 조건 2){}
	else if( 조건 2){}
	
	
 
*/


// 전체 버거 리스트 출력 함수 
function totalBurger(){
	// 1. html 구성
	let html = `<tr>
					<th> 번호 </th> <th> 이미지 </th> <th> 버거이름 </th> 
					<th> 카테고리 </th> <th> 가격 </th> <th> 비고 </th>
				</tr>`
	// 2. 반복문을 활용하여 테이블에 제품 출력
	for( let i=0 ; i<burgerList.length ; i++ ){
		
		html += `<tr>
					<td> ${i+1} </td> 
					<td> <img class="s_img" src="img/${burgerList[i].img}"> </td> 
					<td> ${burgerList[i].name} </td> 
					<td> ${burgerList[i].category} </td> 
					<td class="price_edit${i}"> ${burgerList[i].price.toLocaleString()}원 </td> 
					<td> 
						<button type="button" onclick="burgerDel( ${i} )"> 삭제 </button>
						<button type="button" onclick="burgerEdit( ${i} )"> 수정 </button> 
					</td>
				</tr>`
	}		
	document.querySelector('.admin_burger_list').innerHTML = html
}


// 삭제버튼 함수
function burgerDel( i ){
	burgerList.splice( i , 1 )
	totalBurger()
	categoty_select( 0 )
}

// 수정버튼 함수
function burgerEdit( i ){
	document.querySelector('.price_edit' + i ).innerHTML = 
	`<input type="text" class="commit_price"> <button onclick="commitPrice( ${i} )"> 확인 </button>`
}

// 수정 확인 버튼을 눌렀을때 함수
function commitPrice( i ){
	burgerList[i].price = parseInt(document.querySelector('.commit_price').value) 
	totalBurger()
	categoty_select( 0 )
}


orderContol()
// 주문 된 주문목록 현황 출력
function orderContol(){
	
	// 1. html 구성
	let html = `<tr>
					<th> 주문번호 </th> <th> 버거이름 </th> 
					<th> 상태 </th> <th> 요청 / 완료일 </th> <th> 비고 </th>
				</tr>`
				
	
	orderList.forEach( ( order, i ) =>{ // 주문 리스트 회전
	
		let orderTime = order.time.getHours() + ':' +
						order.time.getMinutes()

		if( order.state == false ){ // 주문완료 / 주문완료시간 존재
			orderTime += ' / ' + order.complete.getHours() + ':' + order.complete.getMinutes()
		}
						
		order.items.forEach( ( burger , j )=>{ // 각 주문 마다의 버거 회전/반복 
			html += `<tr>
						<td> ${ order.no } </td> 
						<td> ${ burger.name } </td> 
						<td> ${ order.state ? "주문요청" : "주문완료" } </td> 
						<td> ${ orderTime } </td> 
						<td>
							${ 	order.state ? 
								'<button onclick="ordercomplete( '+ i +' )"> 주문완료 </button>' : 
								''
							}						
						</td>
					</tr>`
		})
	})
	
	document.querySelector('.admin_order_list').innerHTML = html
}




// 주문완료 버튼을 눌렀을때 함수
function ordercomplete( i ){ 
	orderList[i].state = false
	orderList[i].complete = new Date() ;
	orderContol()
	totalOrder()
}




totalOrder()
// 매출액 출력 함수
function totalOrder(){ // 1. js 열렸을때 // 2. 
	
	// 1. html 구성
	let html = `<tr>
					<th> 제품번호 </th> 
					<th> 버거이름 </th>
					<th> 판매수량 </th> 
					<th> 매출액 </th> 
					<th> 순위 </th>
				</tr>`
				
	burgerList.forEach( (burger , i )=>{
		html += `<tr>
					<td> ${ i+1 } </td> 
					<td> ${ burger.name } </td>
					<td> ${ sales_count(i) } </td> 
					<td> ${ (sales_count(i) * burger.price).toLocaleString() } </td> 
					<td> ${ sales_rank(i) } </td>
				</tr>`
	})
	
	document.querySelector('.admin_total_list').innerHTML = html
}




// 8. 판매수량 찾기
function sales_count( index ){ 
	
	let count = 0; // 1. i번째 제품의 누적판매량수를 저장하는 변수
	
	// 2. 주문 목록에서 i번째 제품 찾기
	orderList.forEach( ( order , i )=>{
		order.items.forEach( (burger , j )=>{ 
			// 만약에 주문목록 내 버거리스트중에서 버거이름과 index 번째 버거 이름과 같으면 
			if( burger.name == burgerList[index].name ){ count++ }
		})
	})
	
	return count ; // * i번째 제품의 누적 판매량수 변수 반환
}






// 9. 랭크
function sales_rank( index ){
	
	let rank = 1;	// 1. index 번째의 버거 순위 저장하는 변수 [ 기본값 1등 ]
	
	// 2. index 번째의 버거 순위를 구하기
		// 1. index 번째 버거의 매출액 // 매출액 : 수량 * 금액
	let total = sales_count(index) * burgerList[index].price // 매출액 : 수량 * 금액
		// 2. 모든 버거들 마다의 매출액
	burgerList.forEach( ( burger , i )=>{
		let totalprice = sales_count(i) * burger.price
		// 3. 비교 [ 만약에 index번째 버거의 매출액 보다 현재 반복되는 버거의 i번째 버거 매출액보다 작으면 ]
		if( total < totalprice ){ rank++ }
	})
	
	return rank ;
} 



// ############################################################################################################################# //












 
 