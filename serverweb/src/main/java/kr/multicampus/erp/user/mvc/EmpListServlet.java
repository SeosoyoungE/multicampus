package kr.multicampus.erp.user.mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.multicampus.erp.user.EmpDAO;
import kr.multicampus.erp.user.EmpDAOImpl;
import kr.multicampus.erp.user.EmpDTO;

@WebServlet(name = "emplist_mvc", urlPatterns = {"/mvc/list.do"})
public class EmpListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		EmpDAO dao =new EmpDAOImpl();
		ArrayList<EmpDTO> emplist = dao.select();
		
		req.setAttribute("userlist", emplist);
		
		String view="/user_mvc/list.jsp"; //불러올 뷰에 대한 주소값
		
		//뷰를 불러와서 고객에게 내보내기
		RequestDispatcher rd=req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
	
}
