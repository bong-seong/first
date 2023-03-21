console.log( 'api3.js 실행' );


// --------------------------------------- 지도 생성
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.3218778,126.8308848), // 지도의 중심좌표
        level: 4 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

// --------------------------------------- 마커 이미지 변경
var imageSrc = '/jsp_web/img/약국.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)

let addrArray = [];

$.ajax({
	url : "https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=292&serviceKey=3zQogYLFxx%2BFClPZRnCo%2FD0rGd%2BCXtMLZ5%2Fw756iUPnyOA8xKUXrzRs09ZtYjAWsTe3%2Fu5aAi4%2BZX0%2FZoycn3A%3D%3D",
	method : "get",
	async : false,
	success : ( r ) => {
		console.log( r );
		r.data.forEach( (o) =>{
			addrArray.push( o.주소 );
		})
		
	}
})

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();
var coords = [];

for( let i=0; i<addrArray.length; i++ ){
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch( addrArray[i], function(result, status) {
	
	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
	
	        coords.push( new kakao.maps.LatLng(result[0].y, result[0].x) );
	    } 
	});
}

// 마커 클러스터러를 생성합니다 
var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
    minLevel: 6 // 클러스터 할 최소 지도 레벨 
});
 
// 데이터를 가져오기 위해 jQuery를 사용합니다
// 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
$.get("https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=292&serviceKey=3zQogYLFxx%2BFClPZRnCo%2FD0rGd%2BCXtMLZ5%2Fw756iUPnyOA8xKUXrzRs09ZtYjAWsTe3%2Fu5aAi4%2BZX0%2FZoycn3A%3D%3D", 
	
	function(r) {
   		// 데이터에서 좌표 값을 가지고 마커를 표시합니다
    	// 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
	    var markers = $(r.data).map(function(i, o ) {
	        let marker = new kakao.maps.Marker({
	            position : coords[i],
	            image : markerImage
	        });
	        
	        kakao.maps.event.addListener(marker, 'click', function() {
				// 모달 정보 담기
				document.querySelector('.modal_title').innerHTML = o.약국명;
				document.querySelector('.modal_content').innerHTML = `대표전화 : ${o.대표전화} <br/> 주소 : ${o.주소}` ;
				
				// 모달 띄우기 
		      	openModal();
			});
			
			return marker ;
	        
	    });
    // 클러스터러에 마커들을 추가합니다
    clusterer.addMarkers(markers);
});


        
	

/*

let marker = new kakao.maps.Marker({
            position : new kakao.maps.LatLng( position['위도(WGS84)'] , position['경도(WGS84)'] ),
            image : markerImage
        });

*/
