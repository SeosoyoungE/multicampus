<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- String타입으로 id변수를 정의한후 id가 "java"인지 확인 -->
	<%
		String id="java";
	
		if(id.equals("java")){
			%>
			<h1>java야 어서와!</h1>
			<img src="/serverweb/images/ses_g1.jpg"/><%
		 }else{
			%>
			<h1>코드가 틀렸습니다.</h1>
			<img src="/serverweb/images/ses_g2.jpg"/><%
		}
	%>
</body>
</html>