package kr.multicampus.erp.user.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.multicampus.erp.user.EmpDAO;
import kr.multicampus.erp.user.EmpDAOImpl;
import kr.multicampus.erp.user.EmpDTO;

/**
 * Servlet implementation class EmpLoginServlet
 */
@WebServlet(name = "emplogin", urlPatterns = { "/mvc/login.do" })
public class EmpLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		
		EmpDAO dao=new EmpDAOImpl();
		EmpDTO emp=dao.login(id, pass);
		//3. 데이터공유 - 사이트를 이동하는 동안 로그인이 계속 유지되도록 로그인정보를 세션객체에 저장한다.
		//3-1) 세션객체를 만들기
		// 1)getSession()
		//- request에서 세션id를 꺼내고 서버에 할당된 세션의 세션id와 일치하는게 없거나 세션id가 존재하지 않으면 세션을 HttpSession객체로 만들어서 리턴한다.
		//- 일치하는 세션id가 있으면 그 세션id로 정의한 세션을 HttpSession객체로 만들어서 리턴한다.
		// 2)getSession(true) - 1번과동일
		// 3)getSession(false)
		//- 일치하는 세션 id가 존재하면 세션객체를 만들어서 리턴
		//- 일치하는 세션 id가 존재하지 않으면 null리턴
		//ex) 세션유무를 체크하는 경우 사용(로그아웃)
	
		String view="";
		if(emp==null) { //로그인이 성공하면 세션을 만든다.
			view="/user_mvc/login.jsp";
		}else {
			view="/index.jsp";
			HttpSession session=request.getSession(); //세션만들기
			session.setAttribute("emp",emp);
		}
		RequestDispatcher rd=request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}
