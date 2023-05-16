package kr.multicampus.erp.board;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet(name = "board_Write", urlPatterns = { "/board/write.do" })
public class BoardWriteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		java.util.Date today=new java.util.Date();
		BoardDAO dao=new BoardDAOImpl();
		BoardDTO board=new BoardDTO(0, title, id, content, null);
		int result=dao.insert(board);
		
		request.setAttribute("id", id);
		String view="";
		
		if(result>0) {
			view="/board/board_writeOK.jsp";
		}else {
			view="/board/board_writeFail.jsp";
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}
