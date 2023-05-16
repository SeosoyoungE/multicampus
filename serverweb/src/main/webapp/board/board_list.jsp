<%@page import="kr.multicampus.erp.board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.href{
	color: black;
}
.href:hover{
	color: blue;
	cursor: pointer;
}
</style>
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
				ArrayList<BoardDTO> boardlist = (ArrayList)request.getAttribute("boardlist");
				%>
				<h1>전체게시글조회</h1>
				<table width='600' border='0'>
					<tr style="border-bottom:1px solid;">
						<th>게시글번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>내용</th>
						<th>작성날짜</th>
					</tr>
					<%
					for (int i = 0; i < boardlist.size(); i++) {
						BoardDTO board = boardlist.get(i);
					%>
					<tr class="href" onclick="location.href='/serverweb/board/read.do?boardNo=<%=board.getBoardNo()%>'">
							<td><%=board.getBoardNo()%></td>
							<td><%=board.getTitle()%></td>
							<td><%=board.getWriter()%></td>
							<td><%=board.getContent()%></td>
							<td><%=board.getWriteDate()%></td> 
					</tr>
					<%
					}
					%>
				</table>
				<div class="write_button"><input type="button" onclick="location.href='/serverweb/board/board_write.jsp'" value="NEW"/></div>
			</div>
		</div>
	</div>
</body>
</html>