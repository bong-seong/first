alert('js열림');


function ex1(){
	
	// 변수10개 ---------> 객체 { } 1개 
	let info = {
		data1 : document.querySelector('.data1').value,
		data2 : document.querySelector('.data2').value,
		data3 : document.querySelector('.data3').value,
		data4 : document.querySelector('.data4').value,
		data5 : document.querySelector('.data5').value,
		data6 : document.querySelector('.data6').value,
		data7 : document.querySelector('input[name="data7"]:checked').value,	// radio 에서 선택된 버튼의 value
		data8 : document.querySelector('.data8').checked,  			   			// 체크여부 [ true / false ]
		data9 : document.querySelector('.data9').value,
		data10 :document.querySelector('.data10').value,
	}
	
	console.log( info ); // data8 외 모두 문자열 임 ... [ 추후 형 변환 ]
	
	// 비동기 통신
	$.ajax({ 						// * jquery 라이브러리 필수!!
		url : "/jsp_web/Ex2",		// 1. 서블릿 주소 [ /프로젝트명/서블릿주소 ]
		method : "post",			// 2. 메소드 방식 [ doGet vs doPost ]
		data : info,				// 3. 보낼 데이터 [ 객체 vs { } ]
		success : function( result ){
			console.log(result);
			if( result ){
				alert('등록성공'); getData();
			}else{
				alert('등록실패');
			}
		} // 4. 받을 데이터
	});
}


getData();
function getData(){
	
	$.ajax({
		url : "/jsp_web/Ex2",
		method : "get",
		success : function( result ){
			// console.log( result );
			// document.querySelector('.ex1_box').innerHTML = result;
			
			let html = `<table border="1">
							<tr>
								<th>data1</th> <th>data2</th> <th>data3</th> <th>data4</th> <th>data5</th>
								<th>data6</th> <th>data7</th> <th>data8</th> <th>data9</th> <th>data10</th>
							</tr>`
						
			
			result.forEach(( o , i ) =>{ // 객체명.forEach( (반복변수 , 반복인덱스 )=>{ 실행문 })
				
				html += `
							<tr>
								<td> ${o.data1 } </td> <td> ${o.data2 } </td> <td> ${o.data3 } </td> <td> ${o.data4 } </td> <td> ${o.data5 } </td>
								<td> ${o.data6 } </td> <td> ${o.data7 } </td> <td> ${o.data8 } </td> <td> ${o.data9 } </td> <td> ${o.data10 }</td>
							</tr>	
						`
			});
			
			html += `</table>`
			document.querySelector(".ex1_box").innerHTML = html ;
		}
	});
	
}


function add_student_info(){
	
	let info = {
		name : document.querySelector('.student_name').value,
		phone : document.querySelector('.student_phone').value,
		height : document.querySelector('.student_height').value,
		age : document.querySelector('.student_age').value,
		reg_date : document.querySelector('.student_reg_date').value,
		gender : document.querySelector('input[name="student_gender"]:checked').value,
		agreed : document.querySelector('.student_agreed').checked,
		area : document.querySelector('.student_area').value,
		about_me : document.querySelector('.student_about_me').value
	}
	
	
	$.ajax({ 						
		url : "/jsp_web/StudentServlet",		
		method : "post",			
		data : info,				
		success : function( student ){
			if( student ){
				alert('등록성공'); getStudent();
			}else{
				alert('등록실패');
			}
		} // 4. 받을 데이터
	});
	
}


getStudent();
function getStudent(){
	
	$.ajax({
		url : "/jsp_web/StudentServlet",
		method : "get",
		success : function( student ){
			// console.log( result );
			// document.querySelector('.ex1_box').innerHTML = result;
			
			let html = `<table border="1">
							<tr>
								<th>이름</th> <th>전화번호</th> <th>키</th> <th>나이</th> <th>등록일</th>
								<th>성별</th> <th>개인정보동의여부</th> <th>지역</th> <th>자기소개</th>
							</tr>`
						
			
			student.forEach(( o , i ) =>{ // 객체명.forEach( (반복변수 , 반복인덱스 )=>{ 실행문 })
				
				html += `
							<tr>
								<td> ${o.name } </td> <td> ${o.phone } </td> <td> ${o.height } </td> <td> ${o.age } </td>
								<td> ${o.reg_date } </td> <td> ${o.gender } </td> <td> ${o.agreed } </td> <td> ${o.area } </td> <td> ${o.about_me }</td>
							</tr>	
						`
			})
			
			html += `</table>`
			document.querySelector(".student_info_box").innerHTML = html ;
		}
	});
	
}








