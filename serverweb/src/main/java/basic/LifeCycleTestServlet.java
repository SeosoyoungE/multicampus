package basic;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleTestServlet extends HttpServlet{
	public LifeCycleTestServlet() {
		System.out.println("LifeCycleTestServlet객체생성!!");
		
	}
	@Override
	public void init() throws ServletException {
		System.out.println("init호출");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet호출");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost호출");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service호출..."+req.getMethod());
		if(req.getMethod().equals("GET")) {
			doGet(req, resp);
		}else {
			doPost(req, resp);
		}
	}

	@Override
	public void destroy() { //서블릿 객체가 소멸될때 호출 (서블릿객체가 컴파일될때, WAS가 reload될때, context가 reload될때)
		System.out.println("destroy호출");
	}


}
