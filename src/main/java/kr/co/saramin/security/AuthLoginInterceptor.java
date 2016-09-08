package kr.co.saramin.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.saramin.mysite.service.UserService;
import kr.co.saramin.mysite.vo.UserVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		String email =request.getParameter("email");
		
		String password= request.getParameter("password");
		
		
		// 서비스 시작하면 클래스들이 자동으로 컨테이너안에 올라가있는 것..그중에 있는 서비스를 꺼내서 쓴다는것이다.
		ApplicationContext applicationContext = 
				WebApplicationContextUtils.getWebApplicationContext( request.getServletContext());
		
		
		UserService userService= applicationContext.getBean( UserService.class);
		
		UserVo userVo= new UserVo();
		userVo.setEmail(email);
		userVo.setPassword(password);
		
		
		UserVo authUser= userService.login(userVo);
		
		if(authUser==null){
			
			response.sendRedirect(request.getContextPath() + "/user/loginform?result=fail");
			return false;
		}
		
		
		//인증처리
		
		HttpSession session= request.getSession( true );
		
		session.setAttribute("authUser", authUser);
		
		System.out.println("login success");
		
		//리다이렉트
		response.sendRedirect(request.getContextPath() + "/index");
		
		return false;
		
		//return super.preHandle(request, response, handler);
	}

	
	
}
