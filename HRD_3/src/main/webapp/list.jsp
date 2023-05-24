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
	
	<%
		Dao dao = new Dao();
		List<Dto> list = dao.getList();
		
	%>
	
	<center>
		<h3> 후보조회 </h3>
		<table border="1" style="border-collapse: collapse; text-align: center;">
			<tr>
				<th> 후보번호 </th>
				<th> 성명 </th>
				<th> 소속정당 </th>
				<th> 학력 </th>
				<th> 주민번호 </th>
				<th> 지역구 </th>
				<th> 대표전화 </th>
			</tr>
			
			<%
				for( int i=0; i<list.size(); i++ ){
				
					Dto dto = list.get(i);
					StringBuffer buf = new StringBuffer( dto.getM_jumin() );
					buf = buf.insert(6, "-");
			%>		
				
				<tr>
					<td><%=dto.getM_no()%></td>
					<td><%=dto.getM_name()%></td>
					<td><%=dto.getP_name()%></td>
					<td><%=dto.getP_school().equals("1") ? "고졸" :
							dto.getP_school().equals("2") ? "학사" : 
								dto.getP_school().equals("3") ? "석사" : "박사"%></td>
					<td><%=buf%></td>
					<td><%=dto.getM_city()%></td>
					<td><%=dto.getP_tel1()+"-"+dto.getP_tel2()+"-"+dto.getP_tel3()%></td>
				</tr>
				
			<%
				}
			%>
		</table>
	</center>
	
	<%@ include file="footer.jsp" %>
</body>
</html>