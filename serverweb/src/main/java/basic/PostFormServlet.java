package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostFormServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("post가 성공적으로 실행됨!");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=resp.getWriter();
		String userId = req.getParameter("userId");
		String userName=req.getParameter("userName");
		String passwd=req.getParameter("passwd");
		String gender=req.getParameter("gender");
		String job=req.getParameter("job");
		//String Favorites=req.getParameter("Favorites");
		String[] Favorites=req.getParameterValues("item");
		
		pw.write("<h1><"+userName+">님의 회원정보</h1>");
		pw.write("<h3>ID: "+userId+"</h3>");
		pw.write("<h3>비밀번호: "+passwd+"</h3>");
		pw.write("<h3>이름: "+userName+"</h3>");
		pw.write("<h3>성별: "+gender+"</h3>");
		pw.write("<h3>직업: "+job+"</h3>");
		pw.write("<h3>관심사: ");
		for(int i=0;i<Favorites.length;i++) {
			pw.write(Favorites[i]+" ");
		}
		pw.write("</h3>");
	}
	
}
