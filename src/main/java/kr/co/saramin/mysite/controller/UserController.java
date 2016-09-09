package kr.co.saramin.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.saramin.mysite.exception.UserDaoException;
import kr.co.saramin.mysite.service.UserService;
import kr.co.saramin.mysite.vo.UserVo;
import kr.co.saramin.security.annotation.Auth;
import kr.co.saramin.security.annotation.AuthUser;

@Controller
@RequestMapping( "/user" )
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping( "/joinform" )
	public String joinform(){
		return "/user/joinform";
	}
	
	@RequestMapping( value="/join", method=RequestMethod.POST )
	public String join(
		@ModelAttribute @Valid UserVo userVo , BindingResult result ) {
		
		if( result.hasErrors()){
			
			List<ObjectError> list= result.getAllErrors();
			
			for (ObjectError o : list){
				System.out.println("object error" + o);
			}
			
			return "redirect:/user/joinform"; 
		}
		
		userService.join( userVo );
		return "redirect:/user/loginform";
	}
	
	@RequestMapping( "/loginform" )
	public String loginform(){
		return "/user/loginform";
	}
	
	
	/*
	@RequestMapping( "/login" )
	public String login( HttpSession session, @ModelAttribute UserVo userVo){
		UserVo authUser = userService.login( userVo );
		if( authUser == null ) {
			return "redirect:/user/loginform?result=fail";
		}
		
		//인증처리
		session.setAttribute( "authUser", authUser );
		
		// 리다렉션
		return "redirect:/index";
	}
	*/
	
	/*
	@RequestMapping( "/logout" )
	public String logout( HttpSession session ){
		session.removeAttribute( "authUser" );
		session.invalidate();
		
		return "redirect:/index";
	}
	*/
	
	
	@Auth
	@RequestMapping("/updateform")
	public String updateform( @AuthUser UserVo authUser, Model model ){  
		// Model model 이렇게 하면 뷰에 같이 값을 넘긴다 자동으로..좋네 이건.
	
		System.out.println(authUser);
		UserVo userVo= userService.getUser(authUser.getNo());
		model.addAttribute("userVo", userVo);
		
		return "user/updateform";
	}
	
	
	@Auth
	@RequestMapping( "/update" )
	public String update( @AuthUser UserVo authUser , @ModelAttribute UserVo userVo ){
		
		userVo.setNo(authUser.getNo());
		userService.modifyUser(userVo);
		
		return "redirect:/index";
	}
	
	
	/*
	public String update( HttpSession session ){
		UserVo authUser= (UserVo)session.getAttribute( "authUser" );
		
		if ( authUser==null){
			
			return "redirect:/index";
			
		}
		
		UserVo userVo= new UserVo();
		userVo.setNo( authUser.getNo() );
		userVo.setName( "사람인" );
		userVo.setGender( "FEMALE" );
		userVo.setPassword("");
		userService.modifyUser(userVo);
		
		return "redirect:/index";
	}
	*/
	
	
	/*
	@ExceptionHandler( UserDaoException.class )
	public String handleUserDaoException(  Exception ex) {
		
		System.out.println(" loggin: " + ex);
		return "error/500";
	}
*/
	
	@ExceptionHandler( UserDaoException.class )
	public String handleUserDaoException(  Exception ex) {
		
		System.out.println(" loggin: " + ex);
		return "error/500";
	}
	
	
}
