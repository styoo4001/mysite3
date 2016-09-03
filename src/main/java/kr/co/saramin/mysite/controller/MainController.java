package kr.co.saramin.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	final static String webpath="/WEB-INF/views/";

	@RequestMapping("/index")
	public String index() {
		
		return webpath+"main/index.jsp";
	}
	
	
	
}
