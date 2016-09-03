package kr.co.saramin.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.saramin.mysite.service.GuestbookService;
import kr.co.saramin.mysite.service.UserService;
import kr.co.saramin.mysite.vo.GuestbookVo;

@Controller
@RequestMapping( "/guestbook")


public class GuestbookController {
	
	@Autowired
	// 바이너/ 에 의해서 주입이 되기때문에 private로 해도 된다... 난 이게 궁금해. 
	private GuestbookService guestbookService;
	
	
	@RequestMapping("/list")
	public String list( Model model){
		
		List<GuestbookVo> list =guestbookService.getList();
		
		System.out.println(list);
		model.addAttribute("list" , list);
		
		return "CGuestController:list";
	}
	
}
