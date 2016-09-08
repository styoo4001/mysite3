package kr.co.saramin.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthLogoutInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
	
		HttpSession session = request.getSession();
		
		if( session== null){
			
			response.sendRedirect( request.getContextPath());
			return false;
		}
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		System.out.println("logout success");
		
		return false;
		//return super.preHandle(request, response, handler);
	}

	
	
	
}
