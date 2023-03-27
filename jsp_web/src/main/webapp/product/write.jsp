<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jsp_web/css/prod_write.css" rel="stylesheet">

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
				
			<!-- 드래그앤드랍 : multiple -->
			<div class="fileDrop">
				[드래그앤드랍] 여기에 첨부파일을 넣어주세요.
			</div>
			<button onclick="onwrite()" type="button"> 제품등록 </button>
				
				
			<div class="file_test">
				<!-- 
				첨부파일 한개
				<div>
					<h3> 첨부파일 한개 </h3>
					<input type="file" name="pfile" accept="image/*">
				</div>
				
				첨부파일 여러개
				<div>
					<h3> 첨부파일 여러개 (인풋 여러개)</h3>
					<input type="file" name="pfile1">	<br/>
					<input type="file" name="pfile2">   <br/>
					<input type="file" name="pfile3">
				</div>
				-->
				<!-- 첨부파일 여러개 -->
				<!-- 
				<div>
					<h3> 첨부파일 여러개 [ 멀티플 / cos.jar 불가능 , commons.jar 가능 ]</h3>
					<input type="file" name="pfiles" multiple="multiple" accept="image/*">
				</div>
				-->
				
				
			</div>
		</form>
	</div>

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=10ba1da6842b6225a9594bb0758c576f&libraries=services,clusterer"></script>
	<script src="/jsp_web/js/product/write.js" type="text/javascript"></script>
</body>
</html>