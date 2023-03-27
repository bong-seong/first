console.log( 'write.js 열림');

if( memberInfo.mid == null ){
	alert('로그인 후 제품 등록이 가능합니다.')
	location.href = "/jsp_web/member/login.jsp"
}


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
	// 폼 데이터 객체에 필드 추가 [ set 필드명 중복 불가능 ]
	writeFormData.set( "plat" , plat );
	writeFormData.set( "plng" , plng );
		console.log( writeFormData );
		
	if( plat == 0 || plng == 0 ){ alert('위치 선택 후 등록해주세요.'); return;}
	if( fileList.length < 1 ){
		alert('하나 이상의 이미지 등록해주세요.')
		return;
	}
	
	// 폼에 [드래그된 파일을들] 첨부파일 등록
	fileList.forEach( (f) => {
		// 배열에 존재하는 파일들을 하나씩 폼에 필드 추가
		// [ append 필드명 중복 가능 ]
		writeFormData.append("fileList" , f );
	})
	
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

// ----------------------------------- 드래그 앤 드랍 -----------------------------------
// 1. 드래그앤드랍할 구역 [ DOM ]
let fileDrop = document.querySelector('.fileDrop');
// * 해당 구역에 드래그된 파일들을 저장하는 리스트 / 배열
let fileList = [];

// 2. 해당 구역에 이벤트 등록

	// 1. dragenter
fileDrop.addEventListener( "dragenter" , ( e ) => {
	console.log('드래그 요소가 해당 구역에 닿았을때');
	e.preventDefault(); // 고유/기존[브라우저내 이벤트] 이벤트 제거
})

	// 2. dragover
fileDrop.addEventListener( "dragover" , ( e ) => {
	console.log('드래그 요소가 해당 구역에 위치했을때');
	e.preventDefault(); // 고유 이벤트 제거
	fileDrop.style.backgroundColor = "#e8e8e8";
})

	// 3. dragleave
fileDrop.addEventListener( "dragleave" , ( e ) => {
	console.log('드래그 요소가 해당 구역에서 나갔을때');
	e.preventDefault(); // 고유 이벤트 제거
	fileDrop.style.backgroundColor = "#ffffff"; // 배경색 되돌리기
})

	//4. drop
fileDrop.addEventListener( "drop" , ( e ) => {
	console.log('드래그 요소가 해당 구역에 드랍되었을때');
	// 문제점 : 브라우저에 드랍했을때 해당 페이지 열림 [ 브라우저 이벤트가 먼저 실행 ]
	e.preventDefault(); // 고유 이벤트 제거
	// 1. 드랍된 파일[dataTransfer]을 호출
	let files = e.dataTransfer.files // forEach 사용 불가능
	console.log( files );
	
	for( let i=0; i<files.length; i++ ){
		
		console.log( files[i] );
		
		if( files[i] != null && files[i] != undefined ){ //파일이 존재하면 // 비어있지 않고 정의되어 있으면
			fileList.push( files[i] );
		}
	}
	fileDrop.style.backgroundColor = "#ffffff";
	printFiles();
	console.log( fileList );
})


// 3. 해당 구역에 드랍된 파일 목록 출력
function printFiles(){
	let html = '';
	
	fileList.forEach( (f , i) => {
		
		let fname = f.name; // 파일명 호출
			console.log( f.name ); 
		let fsize = ( f.size / 1024 ).toFixed(2); // 파일 용량 [ 바이트 --> KB 변경 ]
			// toFixed( 표시할소수자리수 ) 
			console.log( f.size );
			
		html += `
				<div>
					<span> ${ fname } </span>
					<span> ${ fsize }KB </span>
					<span> <button type="button" onclick="fileDelete(${i})"> 삭제 </button> </span>
				</div>
				` 
		
		
	})
	fileDrop.innerHTML = html;
}

// 4. 드래그앤드랍된 파일 목록에서 특정 인덱스의 파일 제거
function fileDelete( i ){
	fileList.splice( i , 1 );
	printFiles();
}






















