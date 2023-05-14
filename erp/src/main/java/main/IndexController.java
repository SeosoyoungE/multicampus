package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@RequestMapping("/index.do")
	public String index() {
		
		return "index";
	}
	
	
	@RequestMapping("/menu/board.do")
	public String board() {
		
		return "menu/board";
	}
}