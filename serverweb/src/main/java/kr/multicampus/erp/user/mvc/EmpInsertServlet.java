package kr.multicampus.erp.user.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.multicampus.erp.user.EmpDAO;
import kr.multicampus.erp.user.EmpDAOImpl;
import kr.multicampus.erp.user.EmpDTO;

@WebServlet(name = "empInsert_mvc", urlPatterns = {"/mvc/insert.do"})
public class EmpInsertServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String deptno=req.getParameter("deptno");
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		String addr=req.getParameter("addr");
		String grade=req.getParameter("grade");
		
		//2.비드니스메소드호출
		EmpDTO emp=new EmpDTO(deptno, name, id, pass, addr, grade);
		EmpDAO dao=new EmpDAOImpl();
		int result=dao.insert(emp);
		//3. 데이터공유
		req.setAttribute("insertuser", name);
		
		//4. 요청재지정
		
		//응답화면을 가져오기
		String view=""; //응답할 뷰에대한 정보
		if(result>0) {
			view="/user_mvc/insertOK.jsp";
		} else {
			view="/user_mvc/insertF.jsp";
		}
		//응답뷰가 클라이언트에게 response되도록 재요청
		RequestDispatcher rd=req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
	
}
