package kr.co.saramin.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.saramin.mysite.service.GuestbookService;
import kr.co.saramin.mysite.service.UserService;
import kr.co.saramin.mysite.vo.GuestbookVo;
import kr.co.saramin.mysite.vo.UserVo;

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
		
	//	return "CGuestController:list";
		return "/WEB-INF/views/guestbook/list_jstlel.jsp";
	}
	
	
	
	@RequestMapping("/write")
	public String write( @ModelAttribute GuestbookVo guestbookVo){
		
		System.out.println(guestbookVo);
	//	GuestbookVo bookVo= GuestbookService.setWrite(guestbookVo);
		guestbookService.setWrite(guestbookVo);
		  
	//	System.out.println(bookVo);
		
		return "redirect:/guestbook/list";
		
	 
	 
	//	return "CGuestController:list";
	}
	
	 
	@RequestMapping("/delete")
	public String delete( Model model){
		
		List<GuestbookVo> list =guestbookService.getList();
		
		System.out.println(list);
		model.addAttribute("list" , list);
		
		return "CGuestController:list";
	}
	
 
	
	@RequestMapping("/writeform")
	public String writeform( HttpSession session ){
		 
		return "/WEB-INF/views/guestbook/write.jsp";
	}
	
}
