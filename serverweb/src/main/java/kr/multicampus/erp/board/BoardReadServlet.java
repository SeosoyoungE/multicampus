package kr.multicampus.erp.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "board_read", urlPatterns = { "/board/read.do" })
public class BoardReadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		BoardDAO dao=new BoardDAOImpl();
		BoardDTO board=dao.read(boardNo);
		
		request.setAttribute("board", board);
		
		RequestDispatcher rd=request.getRequestDispatcher("/board/board_read.jsp");
		rd.forward(request, response);
	}
}
