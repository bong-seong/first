console.log( 'api1.js 실행' );

// * AJAX 이용한 데이터포털의 데이터 가져오기

// 공공데이터 : 시도별 미세먼지 실시간 현황
getapi2();
function getapi2(){
	
	$.ajax({
		url : "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=3zQogYLFxx%2BFClPZRnCo%2FD0rGd%2BCXtMLZ5%2Fw756iUPnyOA8xKUXrzRs09ZtYjAWsTe3%2Fu5aAi4%2BZX0%2FZoycn3A%3D%3D&returnType=json&numOfRows=200&pageNo=1&sidoName=%EA%B2%BD%EA%B8%B0&ver=1.0",
		method : "get",
		success : ( r ) => {
			console.log( r );
		}
	})
}


// 공공데이터 : 전기차충전소 현황
getapi1();
function getapi1(){
	$.ajax({
		url : "https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=3zQogYLFxx%2BFClPZRnCo%2FD0rGd%2BCXtMLZ5%2Fw756iUPnyOA8xKUXrzRs09ZtYjAWsTe3%2Fu5aAi4%2BZX0%2FZoycn3A%3D%3D",
		method : "get",
		success : ( r ) => {
			console.log( r );
			document.querySelector('.totalcount').innerHTML = `전기차 충전소 개수 : ${ r.totalCount }`;
			
			let html = `<tr>
							<th> 시군명 </th>
							<th> 소재지우편번호 </th>
							<th> 소재지도로명주소 </th>
							<th> 소재지지번주소 </th>
							<th> 운영기관명 </th>
							<th> 충전기타입명 </th>
							<th> 충전소명 </th>
							<th> 경도(WGS84)</th>
							<th> 위도(WGS84) </th>
						</tr>`
			
			r.data.forEach( (o) =>{
				// 객체내 필드 호출하는 방법 : 1. 객체명.필드명 		2. 객체명['필드명']
				
				html += `<tr>
							<td> ${ o.시군명 } </td>
							<td> ${ o.소재지우편번호 } </td>
							<td> ${ o.소재지도로명주소 } </td>
							<td> ${ o.소재지지번주소 } </td>
							<td> ${ o.운영기관명 } </td>
							<td> ${ o.충전기타입명 } </td>
							<td> ${ o.충전소명 } </td>
							<td> ${ o['경도(WGS84)'] }</td>
							<td> ${ o['위도(WGS84)'] } </td>
						</tr>`
			})
			
			document.querySelector('.table').innerHTML = html ;
		}
	})
}


/*

경도(WGS84) : "126.8522331753"
소재지도로명주소 : "경기도 안산시 상록구 선진로 92"
소재지우편번호 : 15636
소재지지번주소 : "경기도 안산시 상록구 사동 1502번지"
시군명 : "안산시"
운영기관명 : "한국전력"
위도(WGS84) : "37.2787468594"
충전기타입명 : "DC콤보"
충전소명 :

*/