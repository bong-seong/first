<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	
	<%@ include file="/header.jsp" %>
	
	<div class="container">
		<form class="writeform">
			<div>
				제품명 :
				<input type="text" name="pname">
			</div>
			<div>
				제품설명 :
				<input type="text" name="pcomment">
			</div>
			<div>
				제품가격 :
				<input type="text" name="pprice">
			</div>
			<div>
				위치 :
				<div id="map" style="width:100%;height:350px;"></div>
			</div>
			<button onclick="onwrite()" type="button"> 제품등록 </button>
					
		</form>
	</div>

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=10ba1da6842b6225a9594bb0758c576f&libraries=services,clusterer"></script>
	<script src="/jsp_web/js/product/write.js" type="text/javascript"></script>
</body>
</html>