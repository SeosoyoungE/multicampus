package com.multi.erp.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/emp") //중복되는 부분을 쓸수있다.
public class MemberController {
	
	MemberService service;
	public MemberController() {}
	
	@Autowired
	public MemberController(MemberService service) {
		super();
		this.service = service;
	}
	@GetMapping("/login.do")
	public String login() {
		return "login";
	}
	@PostMapping("/login.do")
	public ModelAndView login(MemberDTO loginUserInfo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MemberDTO user = service.login(loginUserInfo);
		String view = "";
		if(user != null) {
			//로그인 성공
			HttpSession session = request.getSession(); //세션만들기
			//세션에 데이터 공유하기
			session.setAttribute("user", user);
			view = user.getMenupath(); //사용자의 job 따른 뷰를 보여주기위해 세팅
		} else {
			//로그인 실패
			view = "redirect:/emp/login.do";
		}
		mav.setViewName(view);
		return mav;
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		if(session != null) {
			//사용하던 세션을 메모리에서 제거하기
			session.invalidate();
		}
		return "redirect:/emp/login.do";
	}
	
	@RequestMapping("/mypage")
	public String mypage(HttpSession session) {
		//나중에는 제일 복잡한 컨트롤러가 될 수 있다.
		//결재에 대한 진행상황
		//스케줄표 - 업무스케줄, 미팅일정, 휴가일전
		//진행중인 메인업무에 대한 내용
		MemberDTO user =(MemberDTO)session.getAttribute("user");
		return user.getMenupath();
	}
}	
