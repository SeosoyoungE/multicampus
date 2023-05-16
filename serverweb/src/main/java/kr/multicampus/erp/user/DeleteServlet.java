package kr.multicampus.erp.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet(name = "empdelete", urlPatterns = { "/emp/delete.do" })
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		String test=request.getParameter("test");
		String id=request.getParameter("id");
		System.out.println(test+":"+id);
		EmpDAO dao=new EmpDAOImpl();
		int result=dao.delete(id);
		//요청재지
		response.sendRedirect("/serverweb/emp/list.do");
	}

}
