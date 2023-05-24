<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="controller.Dto"%>
<%@page import="java.util.List"%>
<%@page import="controller.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<div style="width: 1000px; margin: 0 auto; text-align: center;">
		<h3> 투표검수조회 </h3>
		<table border="1" style="border-collapse: collapse; text-align: center; margin: 0 auto; width: 700px;" >
			<tr>
				<th> 성명 </th>
				<th> 생년월일 </th>
				<th> 나이 </th>
				<th> 성별 </th>
				<th> 후보번호 </th>
				<th> 투표시간 </th>
				<th> 유권자확인 </th>
			</tr>
			
			<%
				Dao dao = new Dao();
				List<Dto> list = dao.getConfirm();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date =new Date();
				
				String today = sdf.format(date);
				
				int year = Integer.parseInt( today.split("-")[0] )  ;
				int month = Integer.parseInt( today.split("-")[1] )  ;
				int day = Integer.parseInt( today.split("-")[2] )  ;
				
				for( int i=0; i<list.size(); i++ ){
				
					Dto dto = list.get(i);
					
					// 생년월일 표시
					String birth = 
							"19" + dto.getV_jumin().charAt(0) + dto.getV_jumin().charAt(1) + "년" +
							dto.getV_jumin().charAt(2) + dto.getV_jumin().charAt(3) + "월" +
							dto.getV_jumin().charAt(4) + dto.getV_jumin().charAt(5) + "일생" ;  
					
					int memberYear = Integer.parseInt( "19" + dto.getV_jumin().charAt(0) + dto.getV_jumin().charAt(1) );
					int memberMonth = Integer.parseInt( "" + dto.getV_jumin().charAt(2) + dto.getV_jumin().charAt(3) );
					int memberDay = Integer.parseInt( "" + dto.getV_jumin().charAt(4) + dto.getV_jumin().charAt(5) );
					
					// 나이 구하기
					int age = 0 ;
					String ageText = null;
					
					if( memberMonth <= month ){
						if( memberDay <= day ){
							age = year - memberYear ;
							ageText = "만 " + Integer.toString(age) + "세" ;
						}
					}else{
						age = year - memberYear + 1 ;
						ageText = "만 " + Integer.toString(age) + "세" ;
					}
					
					// 성별 구하기
					int gender = Integer.parseInt( dto.getV_jumin().charAt(6) + "" );
					
					// 시간
					StringBuffer buf = new StringBuffer( dto.getV_time() );
					
					buf.insert( 2 , ":" );
					
			%>
				<tr>
					<td><%=dto.getV_name()%></td>
					<td><%=birth %></td>
					<td><%=ageText%></td>
					<td><%=gender == 1 ? "남" : "여" %></td>
					<td><%=dto.getM_no()%></td>
					<td><%=buf%></td>
					<td><%=dto.getV_confirm().equals("Y") ? "확인" : "미확인" %></td>
				</tr>
				
			<%
				}
			%>
			
		</table>
	</div>

	
	<%@ include file="footer.jsp" %>
</body>
</html>