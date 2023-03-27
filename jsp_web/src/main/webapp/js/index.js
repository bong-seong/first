let productList = null
let no = null

function productlistprint(){
	
	let html = '';
       
    productList.forEach( (p) => {
		
		html += `<div>
					<span> ${p.pname} </span>
					<span> ${p.pcomment} </span>
					<span> ${p.pprice} </span>
					<span> ${p.pstate} </span>
					<span> ${p.pview} </span>
					<span> ${p.pdate} </span>
					<span> <button onclick="setplike(${ p.pno })" type="button" class="plikebtn"> ❤ </button></span>
				</div>`
								
	})
	
	document.querySelector('.productlistbox').innerHTML = html;
	getplike( no );
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
	                position : new kakao.maps.LatLng(p.plat, p.plng)
	            });
	            
	            // 마커에 클릭이벤트를 등록합니다
				kakao.maps.event.addListener(marker, 'click', function() {
					
					let html = `<button onclick="productlistprint( )"> << </button> <h3>제품상세페이지</h3>`
				    
				   	html += `<div>
								<div> ${p.pname} </div>
								<div> ${p.pcomment} </div>
								<div> ${p.pprice} </div>
								<div> ${p.pstate} </div>
								<div> ${p.pview} </div>
								<div> ${p.pdate} </div>
								<div> <button onclick="setplike(${ p.pno })" type="button" class="plikebtn">  </button></div>
							</div>`
					document.querySelector('.productlistbox').innerHTML = html;
					getplike( p.pno );
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
				document.querySelector('.plikebtn').innerHTML = '💖'
			}else{
				alert('찜하기 취소')
				document.querySelector('.plikebtn').innerHTML = '❤'
			}
		}
	})
	// vs
	// $.get( "/jsp_web/product/like?pno="pno="+pno , ()=?{ })
	// $.post( "/jsp_web/product/like , { "data" : data } , ()=?{ })
}

// 4. 현재 회원이 해당 제품의 찜하기 상태 호출
function getplike( pno ){
	
	if( memberInfo.mid == null ){ document.querySelector('.plikebtn').innerHTML = '❤' }
	
	$.ajax({
		url : "/jsp_web/product/like",
		method : "get",
		data : { "pno" : pno },
		success : ( r ) => {
			console.log( r );
			if( r == 'true' ){ document.querySelector('.plikebtn').innerHTML = '💖'}
			else{ document.querySelector('.plikebtn').innerHTML = '❤' }
		}
	})
}
    
   