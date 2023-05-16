package kr.multicampus.erp.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "board_list", urlPatterns = {"/board/list.do"})
public class BoardListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BoardDAO dao=new BoardDAOImpl();
		ArrayList<BoardDTO> boardlist=dao.select();
		
		request.setAttribute("boardlist", boardlist);
		RequestDispatcher rd=request.getRequestDispatcher("/board/board_list.jsp");
		rd.forward(request, response);
	}

}
