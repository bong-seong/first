/*
	1. productlist() 	: 모든 제품 목록 html 출력 함수
	2. productprint() 	: productlist 내 i번째 제품 1개 html 출력 함수
	3. chatprint() 		: 채팅창 html 구성 후 출력하는 함수
	4. sendchar()		: 입력한 채팅을 ajax 로 보내 DB 에 저장하는 함수
	5. getproductlist() : 기준[ 동서남북 , 검색 ]에 따른 제품 목록을 요청해서 결과를 받아 출력하는 함수 / 마커생성
	6. get동서남북()		: 현재 보고 있는 지도의 좌표 구하기
	7. setplike()		: 찜하기등록
	8. getplike()		: 찜하기 상태 호출
*/


// 전역변수
let productList = null // getproductlist() 의 ajax 로 부터 요청된 결과를 담는곳
let no = null

function productlistprint(){
	
	let html = '';
       
    productList.forEach( (p,i) => {
	
		html += `
				<div onclick="productprint( ${i} )" class="productbox">
					<div class="pimgbox">
						<img src="/jsp_web/product/pimg/${p.pimglist[0]}">
					</div>
					<div class="pcontentbox">
						<div class="pdate"> ${p.pdate} </div>
						<div class="pname"> ${p.pname} </div>
						<div class="pprice"> ${p.pprice.toLocaleString() }원 </div>
						<div class="petc">
							<i class="far fa-eye"></i> ${p.pview}
							<i class="far fa-thumbs-up"></i> 5
							<i class="far fa-comment-dots"></i> 2
						</div>
					</div>
				</div>`
								
	})
	
	document.querySelector('.productlistbox').innerHTML = html;
} // end

// 제품 개별 조회
function productprint( i ){
	
	let p = productList[i];
	
	// 이미지 슬라이드에 대입할 html 구성
	let imghtml = ``;
	
	p.pimglist.forEach( ( img , i ) => {
		// bs class : active 	현재 보여지는 이미지
		if( i == 0 ){	// 첫 이미지에만 active 클래스 적용
			imghtml += `<div class="carousel-item active">
				      <img src="/jsp_web/product/pimg/${ img }" class="d-block w-100" alt="...">
				    </div>`;	
		}else{
			imghtml += `<div class="carousel-item">
				      <img src="/jsp_web/product/pimg/${ img }" class="d-block w-100" alt="...">
				    </div>`;
		}
	})
	
	let html = ``
		html += `
				<div class="pviewbox">
			
					<div class="pviewinfo">
						<div class="mimgbox">
							<img src="/jsp_web/member/mimg/${p.mimg == null ? 'default.png' : p.mimg }" class="hpimg">
							<span class="mid">${ p.mid }</span>
						</div>
						<div>
							<button onclick="productlistprint( )" class="pbadge" type="button"> 목록보기 </button>
						</div>
					</div>
				
					
					<div id="carouselExampleControls" class="carousel carousel-dark slide" data-bs-ride="carousel">
					  <div class="carousel-inner">
					  	${ imghtml }
					  </div> 
					    
					  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="visually-hidden">Previous</span>
					  </button>
					  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
					    <span class="carousel-control-next-icon" aria-hidden="true"></span>
					    <span class="visually-hidden">Next</span>
					  </button>
					</div>
					<div class="pdate"> ${p.pdate} </div>
					<div class="pname"> ${p.pname} </div>
					<div class="pstate"> ${p.pstate == 1 ? '판매중' : p.pstate == 2 ? '거래중' : '거래완료' } </div>
					<div class="pcomment"> ${p.pcomment} </div>
					<div class="pprice"> ${p.pprice.toLocaleString()}원 </div>
					<div class="petc">
						<i class="far fa-eye"></i> ${p.pview}
						<i class="far fa-thumbs-up"></i> 5
						<i class="far fa-comment-dots"></i> 2 
					</div>
					<div class="pviewbtnbox"> 
						<button onclick="setplike(${ p.pno })" type="button" class="likebtn"> <i class="far fa-heart"></i> </button>
						<button type="button" onclick="chatprint(${ i })" class="notebtn"> <i class="far fa-paper-plane"></i> &nbsp; 대화하기 </button> 
					</div>
				</div>`
		document.querySelector('.productlistbox').innerHTML = html;
		getplike( p.pno );
}


// 9. 제품별 채팅 목록 페이지 이동
function chatlistprint( i ){
	
	let p = productList[i];
	
	let html = ``;
	
	$.ajax({
		url : "/jsp_web/product/chat",
		method : "get",
		async : false,
		data : { "pno" : p.pno , "chatmno" : 0 },
		success : ( r ) => {
			console.log( r );
			
			let printfrommno = []; // 출력된 mno 
			
			r.forEach( (o) => {
				if( !printfrommno.includes( o.from_mno ) ){ // 구매자 채팅을 출력한적이 없으면
					printfrommno.push( o.from_mno ); // 구매자번호 저장 후 // 구매자별 1번씩만 출력
				
				// 구매자별 1개씩만 출력
				html += `<div onclick="chatinfoprint(${i} , ${ o.from_mno } )" class="chatlist">
							<div class="frommimg">
								<img class="hpimg" scr="/jsp_web/member/mimg/${ o.frommimg == null ? 'default.png' : o.frommimg }">
							</div>
							<div class="frominfo">
								<div class="fromndate"> ${ o.ndate } </div>
								<div class="frommid"> ${ o.frommid } </div> 
								<div class="fromncontent"> ${ o.ncontent } </div>
							</div>
						</div>`
				}
			})
			if( printfrommno.length == 0 ){ html = `채팅 목록이 없습니다.` }
		}
	})
	document.querySelector('.productlistbox').innerHTML = html;
}

// * 
let index = 0; 		// 현재 보고 있는 제품의 제품인덱스
let chatmno = 0;	// 현재 채팅하고있는 상대방의 mno

// 10.
function getcontent() {
	
	let chathtml = ``;
	let p = productList[index]
	
	$.ajax({
		url : "/jsp_web/product/chat",
		method : "get",
		data : { "pno" : p.pno , "chatmno" : chatmno },
		async : false, /* 동기식 */
		success : ( r ) => {
			
			r.forEach( (o) => {
				if( o.from_mno == memberInfo.mno ){
					chathtml += `<div class="sendbox"> ${ o.ncontent } </div>`
				}else{ // 메시지 보낸 사람과 채팅대상자가 일치하면
					chathtml += `<div class="recvbox"> ${ o.ncontent } </div>`
				}
			})
		}
	})
	document.querySelector('.chatcontent').innerHTML = chathtml;
}

// 11.
function chatinfoprint( i , to_mno ){
	console.log( to_mno + '에게 메시지 전송 페이지')
	
	let p = productList[index];
	
	let html = `<h3> ${ p.pno } 제품 채팅방 </h3>`;
	
	// 전역변수에 담기
	index = i;
	chatmno = to_mno;
	
	
	
	html += `
			<div class="chatbox">
				<div class="pviewinfo">
					<div class="mimgbox">
						<img src="/jsp_web/product/pimg/${ p.pimglist[0] }" class="hpimg">
						<span class="pname"> ${p.pname} </span>
					</div>
					<div>
						<button onclick="productlistprint()" class="pbadge" type="button"> 목록보기 </button>
					</div>
				</div>
				
				<div class="chatcontent">
					
				</div>
				
				<div class="chatbtn">
					<textarea class="ncontent" rows="" cols=""></textarea>
					<button onclick="sendchat(${ p.pno })" type="button"> Send </button>
				</div>
			</div>`
			
	document.querySelector('.productlistbox').innerHTML = html;
	getcontent();
}

// 3. 채팅 페이지 이동 [ 로그인 유효성 검사 ]
function chatprint( i ){
	
	let p = productList[i];
	
	if( memberInfo.mid == null ){
		alert('로그인 후 이용 가능한 서비스입니다.'); return;
	}
	
	if( memberInfo.mno == p.mno ){ // 만약에 등록한 회원이면 [ 판매자 ]
		chatlistprint( i ) // 채팅 목록으로 이동 
		return;
	} 
	// 만약에 등록한 회원이 아니면 [ 구매자 ]
	chatinfoprint( i , p.mno );
}


// 5. 
function sendchat( pno ){
	
	let ncontent = document.querySelector('.ncontent').value;
	
	$.ajax({
		url : "/jsp_web/product/chat",
		method : "post",
		data : {"pno" : pno , "to_mno" : chatmno , "ncontent" : ncontent },
		success : ( r ) => {
			console.log( r );
			if( r == 'true' ){
				document.querySelector('.ncontent').value = '' ;				
			}
		}
	})
	getcontent();
}



var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(37.37773589703581, 126.78118307978525), // 지도의 중심좌표 
        level : 3 // 지도의 확대 레벨 
    });
    
    // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 5 // 클러스터 할 최소 지도 레벨 
    });
    
// ---------------------------- 마커 이미지 변경 ------------------------------

var imageSrc = '/jsp_web/img/charge.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(50, 50), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다

// ---------------------------- 마커 1개 생성 -----------------------------------
    
 
// 1. 제품목록 호출 [ 1. 현재 보이는 지도 좌표내 포함된 제품만 2. ]
function getProductList( dong , seo , nam , book ){
	
	clusterer.clear(); // 클러스터 비우기 [ 기존 마커들 제거 ]
	
	$.ajax({
		url : "/jsp_web/product/info",
		method : "get",
		async : false,
		data : { dong : dong , seo : seo , nam : nam , book : book },
		success : ( r ) => {
			
			// -------------------- 사이드바 제품목록 --------------------------
			productList = r;		// 제품목록 결과를 전역변수에 담아주기
	        productlistprint();
	        
	        // .map( ( 인덱스 , 반복객체명 ) ) => { } ) 실행문에서 return 값을 배열에 대입  
	        // vs 
	        // .forEach( (반복객체명 , 인덱스 ) =>{ } ) 실행문에서 return x
	        
	        // ------------------ 마커작업 -------------------
	        var markers = $( r ).map( ( i , p ) => {
				console.log( p );
				no = p.pno;
				// 마커에 추가코드 작성하기 위해 변수화
	            let marker =  new kakao.maps.Marker({
	                position : new kakao.maps.LatLng(p.plat, p.plng),
	                image : markerImage
	            });
	            
	            // 마커에 클릭이벤트를 등록합니다
				kakao.maps.event.addListener(marker, 'click', function() {
					productprint( i );
				});
	            return marker ;
	        });
	
	        clusterer.addMarkers(markers);
        } // success end
    }); // ajax end
} // m end 


    
// -------------------------- 현재 지도 정보 얻기 -----------------------------
// 2. 현재 지도의 좌표얻기
get동서남북();
function get동서남북(){
	// 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds();
    
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest(); 
    
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); 

    let nam = swLatLng.getLat();
    let seo = swLatLng.getLng();
    let book = neLatLng.getLat();
    let dong = neLatLng.getLng();
    
    getProductList( dong , seo , nam , book );
}

// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'dragend', function() {
	get동서남북();
});
    
    
    
// 3. 찜하기 버튼을 눌렀을때 [ 첫 클릭시 찜하기 다음 클릭시 찜하기 취소 , 다음 클릭시 찜하기 ]
function setplike( pno ){
	
	if( memberInfo.mid == null ){
		alert('로그인 후 이용 가능한 서비스입니다.'); return;
	}
	
	// 1. get 방식 전송
	$.ajax({
		url : "/jsp_web/product/like",
		method : "post",
		async : false,
		data : { "pno" : pno },
		success : ( r ) => {
			console.log ( r );
			if( r == 'true' ){
				alert('찜하기 등록')
				document.querySelector('.likebtn').innerHTML = '❤'
			}else{
				alert('찜하기 취소')
				document.querySelector('.likebtn').innerHTML = '<i class="far fa-heart">'
			}
		}
	})
	// vs
	// $.get( "/jsp_web/product/like?pno="pno="+pno , ()=?{ })
	// $.post( "/jsp_web/product/like , { "data" : data } , ()=?{ })
}

// 4. 현재 회원이 해당 제품의 찜하기 상태 호출
function getplike( pno ){
	
	if( memberInfo.mid == null ){ document.querySelector('.likebtn').innerHTML = '<i class="far fa-heart">' }
	
	$.ajax({
		url : "/jsp_web/product/like",
		method : "get",
		data : { "pno" : pno },
		success : ( r ) => {
			console.log( r );
			if( r == 'true' ){ document.querySelector('.likebtn').innerHTML = '❤'}
			else{ document.querySelector('.likebtn').innerHTML = '<i class="far fa-heart">' }
		}
	})
}
    
   