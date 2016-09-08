package kr.co.saramin.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.saramin.mysite.vo.UserVo;
import kr.co.saramin.security.annotation.Auth;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler)
			throws Exception {
	
		//handler 안에  정보가 있다? 뭔말임.
		
		// 이걸 해야되는게 중요한거같은데.. 
		if  ( handler instanceof HandlerMethod == false){
			return true;
		}
		
		// 핸들러 메소드에 Auth 클래스가 있냐고 ...있으면.
		Auth auth=((HandlerMethod)handler).getMethodAnnotation( Auth.class);
		
		// @Auth 가 안달린 핸들러 메서드
		
		if( auth==null){
			return true;
		}
		// 접근 제어
		
		HttpSession session= request.getSession();
		
		if( session ==null){
			
			response.sendRedirect(request.getContextPath() + "/user/loginform");
			return false;
		}
		
		UserVo authUser= (UserVo)session.getAttribute("authUser");
		
		if( authUser==null){
			response.sendRedirect(request.getContextPath() + "/user/loginform");
			return false;
		}
		
		// 이제 다 인증된 사용자..
		
		return true;
	//	return super.preHandle(request, response, handler);
	}

	
	
	
}
