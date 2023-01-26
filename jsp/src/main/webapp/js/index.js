
let productList = [
	{ img: 'item1.png' , title: '아우디 A6' , size: '[Audi]' , price: 100000000 , discount: 0.1 , like: 54 , review: 3412 },
	{ img: 'item2.jpg' , title: 'BMW 8 시리즈 그란쿠페' , size: '[BMW]' , price: 160000000 , discount: 0.03 , like: 5654 , review: 71512 },
	{ img: 'item3.png' , title: '포르쉐 파나메라' , size: '[Porsche]' , price: 240000000 , discount: 0.02 , like: 6554 , review: 13312 },
	{ img: 'item4.jpg' , title: 'BMW 3 시리즈' , size: '[BMW]' , price: 70000000 , discount: 0.02 , like: 3 , review: 41267 },
	{ img: 'item5.png' , title: '대우국민차 티코' , size: '[대우국민차]' , price: 10000000 , discount: 0.5 , like: 113254 , review: 156412 },
	{ img: 'item6.jpg' , title: '부가티 시론' , size: '[Bugatti]' , price: 1270000000 , discount: 0.01 , like: 1545 , review: 412 }
]

product_print()
// 1. 제품 출력 //1. js 열릴때
function product_print(){
	
	let html =``
	
	productList.forEach( ( o , i )=> {
		
		html += `
				<div class="item">
					<img src="img/${ o.img }">
					<div class="item_info">
					<div class="item_title"> ${ o.title } </div>
					<div class="item_size"> ${ o.size } </div>
					<div class="item_price"> ${ o.price.toLocaleString() } </div>
					<div>
						<span class="item_sale"> ${ (o.price - parseInt(o.price * o.discount) ).toLocaleString() } </span>
						<span class="item_discount"> ${ parseInt(o.discount * 100) }% </span>
					</div>
				</div>
				<div class="item_bottom">
					<div>
						<span class="badge rounded-pill text-bg-warning">주문폭주</span>
						<span class="badge rounded-pill text-bg-danger">1+1</span>
					</div>
					<div class="item_review"> 찜 ${ o.like } 리뷰수 ${ o.review }</div>
					</div>
				</div>`
	})
				
	document.querySelector('.itembox').innerHTML = html ;
}







