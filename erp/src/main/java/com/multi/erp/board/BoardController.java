package com.multi.erp.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multi.erp.member.MemberDTO;

@Controller
public class BoardController {
	BoardService service;
	public BoardController() {
		
	}
	
	@Autowired
	public BoardController(BoardService service) {
		super();
		this.service = service;
	}
	@GetMapping("/board/write")
	public String writePage() {
		return "board/writepage"; //view
	}
	@PostMapping("/board/write")
	private String write(BoardDTO board) {
		System.out.println(board);
		service.insert(board);
		System.out.println(board);
		return "redirect:/board/list.do"; //컨트롤러요청재지정
	}
	@RequestMapping("/board/list.do")
	public ModelAndView list(String category) {
		System.out.println("카테고리>>>"+category);
		ModelAndView mav=new ModelAndView("board/list");
		List<BoardDTO> boardlist= service.findByCategory(category);
		mav.addObject("category",category);
		mav.addObject("boardlist",boardlist);
		System.out.println(boardlist);
		return mav; //view
	}
	
	/*
	 * @RequestMapping("/board/search.do") public ModelAndView search(String search)
	 * { ModelAndView mav=new ModelAndView("board/list"); List<BoardDTO> boardlist=
	 * service.search(search); mav.addObject("boardlist",boardlist);
	 * System.out.println(boardlist); return mav; //view }
	 */
	@RequestMapping("/board/read.do")
	public String read(String board_no,String state, Model model) {
		BoardDTO board= service.getBoardInfo(board_no);
		String view="";
		if(state.equals("READ")) {
			view="board/read";
		}else {
			view="board/update";
		}
		model.addAttribute("board", board);
		return view;
	}
	@RequestMapping("/board/delete.do")
	public String delete(String board_no,HttpSession session) {
		MemberDTO user=(MemberDTO)session.getAttribute("user");
		String view="";
		if(user==null) {
			view="redirect:/emp/login.do";
		} else {
			int result=service.delete(board_no);
			view="redirect:/board/list.do";
		}
		return view;
	}
	@PostMapping("/board/update.do")
	private String update(BoardDTO board) {
		System.out.println(board);
		service.update(board);
		return "redirect:/board/list.do"; //컨트롤러요청재지정
	}
	
	@RequestMapping("/board/search.do")
	public ModelAndView search(String tag,String search) {
		ModelAndView mav=new ModelAndView("board/list");
		List<BoardDTO> boardlist= service.search(tag,search);
		mav.addObject("boardlist",boardlist);
		System.out.println(boardlist);
		return mav; //view
	}
	
	
}
