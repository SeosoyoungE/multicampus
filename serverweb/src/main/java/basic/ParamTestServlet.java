package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamTestServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); //한글인코딩 설정
		//1. 응답데이터의 형식과 인코딩설정
		resp.setContentType("text/html;charset=UTF-8");
		//2. 클라이언트에 응답할 스트림객체를 생성
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>안녕</hr>");
		System.out.println("doPost요청성공"); //확인하기 위한 sysout
		String id = req.getParameter("id"); 
		String pass=req.getParameter("pass");
		pw.print("<h1>id: "+id+"</h1>");
		pw.print("<h1>password: "+pass+"</h1>");
	}
	
}
