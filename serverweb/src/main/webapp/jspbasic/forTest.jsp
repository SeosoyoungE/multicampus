<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>fortest</h1>
	<hr/>
	<table border="1" height="300" width="50" style="text-align: center;">
		<%for(int i=1;i<=10;i++){ %>
		<tr>
		<td><%=i%></td>
		</tr>
		<%} %>
	</table>
</body>
</html>