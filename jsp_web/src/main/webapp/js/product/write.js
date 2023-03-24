console.log( 'write.js 열림');

// 전역변수
let plat = 0;
let plng = 0;

function onwrite(){
	
	// 1. 폼전송
	let writeForm = document.querySelectorAll('.writeform')[0];
		console.log( writeForm )
	// 2. 폼 데이터 객체 선언
	let writeFormData = new FormData( writeForm );
	// 3. 좌표[ 위도, 경도 ]추가
	// 폼 데이터 객체에 필드 추가
	writeFormData.set( "plat" , plat );
	writeFormData.set( "plng" , plng );
		console.log( writeFormData );
		
	if( plat == 0 || plng == 0 ){ alert('위치 선택 후 등록해주세요.'); return;}
	
	$.ajax({
		url : "/jsp_web/product/info",
		method : "post",
		data : writeFormData,
		contentType : false,
		processData : false,
		success : ( r ) => {
			console.log('ajax 통신'); console.log( r );
			if( r == 'true' ){
				alert('등록 성공');
				location.href = "/jsp_web/index.jsp"
			}else{
				alert('등록 실패')
			}
		}
	})
}




// ----------------------- 카카오 지도를 표시할 div 객체 -------------------------
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng( 37.37773589703581, 126.78118307978525 ), // 지도의 중심좌표
        level: 4 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
});

// 지도에 마커를 표시합니다
marker.setMap(map);



// ---------------------------- 지도에 클릭 이벤트를 등록합니다 --------------------------
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
	
	// 위도    
    plat = latlng.getLat();	console.log( latlng.getLat() );
	
	// 경도
    plng = latlng.getLng();	console.log( latlng.getLng() );
    
});