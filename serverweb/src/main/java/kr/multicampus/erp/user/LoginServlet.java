package kr.multicampus.erp.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.CustomerVO;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=resp.getWriter();
		CustomerDAO dao=new CustomerDAOImpl();
		
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		CustomerVO customer= dao.login(id,pass);
		if(customer!=null) {
			pw.write("<h1>"+customer.getId()+"님 로그인성공</h1>");
		} else {
			pw.write("<h1>로그인실패</h1>");
		}
	}
}
