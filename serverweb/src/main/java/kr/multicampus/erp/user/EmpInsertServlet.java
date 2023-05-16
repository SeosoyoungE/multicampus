package kr.multicampus.erp.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "empInsert", urlPatterns = {"/emp/insert.do"})
public class EmpInsertServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=resp.getWriter();
		int result=0;
		
		String deptno=req.getParameter("deptno");
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		String addr=req.getParameter("addr");
		String grade=req.getParameter("grade");
		EmpDTO emp=new EmpDTO(deptno, name, id, pass, addr, grade);
		EmpDAO dao=new EmpDAOImpl();
		result=dao.insert(emp);
		
		//3. 클라이언트에 응답하기
		
		//응답화면을 가져오기
		String view=""; //응답할 뷰에대한 정보
		if(result>0) {
			view="/serverweb/user_mvc/insertOK.jsp";
		} else {
			view="/serverweb/user_mvc/insertF.jsp";
		}
		
		resp.sendRedirect(view);
	}
	
}
