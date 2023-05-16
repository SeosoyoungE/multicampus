<%@page import="kr.multicampus.erp.user.EmpDTO"%>
<%@page import="kr.multicampus.erp.user.EmpDAO"%>
<%@page import="java.util.ArrayList"%>
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
				ArrayList<EmpDTO> emplist = (ArrayList) request.getAttribute("userlist");
				%>
				<h1>전체사원조회</h1>
				<table width='600' border='1'>
					<tr>
						<th>부서코드</th>
						<th>성명</th>
						<th>아이디</th>
						<th>패스워드</th>
						<th>주소</th>
						<th>포인트</th>
						<th>등급</th>
						<th>삭제</th>
					</tr>
					<%
					for (int i = 0; i < emplist.size(); i++) {
						EmpDTO emp = emplist.get(i);
					%>
					<tr>
						<td><%=emp.getDeptno()%></td>
						<td><%=emp.getName()%></td>
						<td><a href='/serverweb/emp/read.do?id=<%=emp.getId()%>'><%=emp.getId()%></a></td>
						<td><%=emp.getPass()%></td>
						<td><%=emp.getAddr()%></td>
						<td><%=emp.getPoint()%></td>
						<td><%=emp.getGrade()%></td>
						<td><a
							href='/serverweb/emp/delete.do?test=info&id=<%=emp.getId()%>'>삭제</a></td>
					</tr>
					<%
					}
					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>