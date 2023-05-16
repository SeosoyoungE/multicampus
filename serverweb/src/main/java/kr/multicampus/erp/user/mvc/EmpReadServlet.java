package kr.multicampus.erp.user.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.multicampus.erp.user.EmpDAO;
import kr.multicampus.erp.user.EmpDAOImpl;
import kr.multicampus.erp.user.EmpDTO;

@WebServlet(name="empread", urlPatterns = "/emp/read.do")
public class EmpReadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id= req.getParameter("id");
		
		EmpDAO dao=new EmpDAOImpl();
		EmpDTO emp=dao.read(id);
		
		req.setAttribute("emp", emp);
		String view="/user_mvc/emp_read.jsp";
		
		RequestDispatcher rd=req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
	
}
