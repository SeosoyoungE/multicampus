<%@page import="kr.multicampus.erp.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../top.jsp" />

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<jsp:include page="/layout/servlet_menu.jsp" />
			</div>
			<div class="col-lg-10">
				<%
				BoardDTO board = (BoardDTO) request.getAttribute("board");
				%>
				<h1>#<%=board.getBoardNo() %></h1>
				<table width='600' border='1'>
					<tr>
						<th>게시글번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>내용</th>
						<th>작성날짜</th>
					</tr>
					<tr>
						<td><%=board.getBoardNo()%></td>
						<td><%=board.getTitle()%></td>
						<td><%=board.getWriter()%></td>
						<td><%=board.getContent()%></td>
						<td><%=board.getWriteDate()%></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>