package kr.multicampus.erp.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "emplist", urlPatterns = {"/emp/list.do"})
public class EmpListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=resp.getWriter();
		
		EmpDAO dao =new EmpDAOImpl();
		ArrayList<EmpDTO> emplist = dao.select();
		
		pw.write("<h1>전체사원조회</h1>");
		pw.print("<table width='600' border='1'>");
		pw.write("<tr>");
		pw.write("<th>부서코드</th><th>성명</th><th>아이디</th><th>패스워드</th><th>주소</th><th>포인트</th><th>등급</th><th>삭제</th>");
		pw.write("</tr>");
		for(int i=0;i<emplist.size();i++) {
			EmpDTO emp=emplist.get(i);
			pw.write("<tr>");
			pw.write("<td>"+emp.getDeptno()+"</td><td>"+emp.getId()+"</td><td>"+emp.getId()+"</td><td>"+emp.getPass()+"</td><td>"+emp.getAddr()+"</td><td>"+emp.getPoint()+"</td><td>"+emp.getGrade()+"</td>");
			pw.write("<td><a href='/serverweb/emp/delete.do?test=info&id="+emp.getId()+"'>삭제</a></td>");
			pw.write("</tr>");
		}
	}
	
}
