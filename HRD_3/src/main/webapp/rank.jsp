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
	
	<center>
		<h3> 후보자등수 </h3>
		<table border="1" style="border-collapse: collapse; text-align: center;">
			<tr>
				<th>후보번호</th>
				<th>성명</th>
				<th>총득표건수</th>
			</tr>
			
			<%
			
				Dao dao = new Dao();
				List<Dto> list = dao.getRank();
				
				
				
				for( int i=0; i<list.size(); i++ ){
					Dto dto = list.get(i);
			
			%>
			
				<tr>
					<td><%=dto.getM_no()%></td>
					<td><%=dto.getM_name()%></td>
					<td><%=dto.getV_confirm_count()%></td>
				</tr>
			<%
				}
			%>
			
		</table>
	</center>
	
	<%@ include file="footer.jsp" %>
</body>
</html>