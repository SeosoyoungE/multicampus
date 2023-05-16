package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.multicampus.erp.user.EmpDTO;


@WebServlet(name = "include", urlPatterns = { "/include" })
public class IncludeTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		
		System.out.println("Include연습 - Include서블릿 실행");
		pw.println("<h1>요청재지정연습 - Include</h1>");
		pw.print("<hr/><hr/><hr/><hr/>");
		
		//1. 데이터공유
		EmpDTO dto = new EmpDTO("bts","1234","서울",100,"VIP");
		//공유하고 싶은 scope를 나타내는 객체에 이름을 정의하고 저장
		request.setAttribute("mydata", dto);
		
		//2. 요청재지정
		RequestDispatcher rd= request.getRequestDispatcher("/basicview/result.jsp");
		rd.include(request, response);
	}

}
