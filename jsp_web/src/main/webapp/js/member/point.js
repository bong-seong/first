console.log('point.js 열림');

/* 포트원 가맹점[ 관리자회원 ] 식별변호 */ 
var IMP = window.IMP;   // 생략 가능
IMP.init("imp01111188"); // 예: imp00000000


let pay = 0;

function setpay( p ){
	pay = p;
	alert('결제금액 선택')
}


function requestPay() {
	
	if( pay == 0 ){
		alert('충전할 금액을 선택해주세요.');
		return;
	}
	
    IMP.request_pay({
      pg: "kakaopay",
      pay_method: "card",
      merchant_uid: "ORD20180131-0000011",   // 주문번호 // 결제DB에서 사용할 PK
      name: "이젠 포인트 결제",
      amount: pay,                         // 숫자 타입 // 결제금액
      buyer_email: "gildong@gmail.com",		// 관리자 정보 
      buyer_name: "홍길동",
      buyer_tel: "010-4242-4242",
      buyer_addr: "서울특별시 강남구 신사동",
      buyer_postcode: "01181"
    }, function (rsp) { // callback
      if (rsp.success) { // 결제성공
        console.log( rsp );
      } else { // 결제취소/실패
      	console.log( rsp );
      	// 결제 성공 했다는 가정
      	
      	let info ={
			mpcomment : '포인트 충전',
			mpamount : pay,
			mno : memberInfo.mno
		}
      	
      	$.ajax({
			  url : "/jsp_web/point",
			  method : "post",
			  data : info,
			  success : ( r ) => {
				  if( r == "true" ){
					  alert('포인트 충전 성공');
				  }
			  }
		})
      }
    });
 }
 

 
 