package kr.co.saramin.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import kr.co.saramin.mysite.vo.UserVo;
import kr.co.saramin.security.annotation.AuthUser;

public class AuthUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	
	// @RequestMapping("/updateform")
	//public String updateform( @AuthUser UserVo authUser, Model model ){  이거 할때 쓰는거..
	@Override
	public Object resolveArgument(
			MethodParameter parameter, 
			ModelAndViewContainer arg1, 
			NativeWebRequest webRequest,
			WebDataBinderFactory arg3) 
					throws Exception {

		System.out.println("1");
		if(supportsParameter(parameter)== false){
			return WebArgumentResolver.UNRESOLVED;
		}
		
		// webReuqest 가 네이티브 HTTPSERVLET request 가 아니다. 그러므로 이렇게 선언을 해줘야된다. 
		// 왜 네이티브를 바로 안가져오냐면 was 마다 리퀘스트가 달라서랜다..
		
		HttpServletRequest request= webRequest.getNativeRequest(HttpServletRequest.class);
		
		HttpSession session = request.getSession();

		System.out.println("2");
		if( session ==null) {
			return WebArgumentResolver.UNRESOLVED;
		}

		System.out.println("3");
		System.out.println("return authUser"+session.getAttribute("authUser"));
		return session.getAttribute("authUser");
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {

		// 파라미터로 넘어온게 AuthUser가 아니라 다른거면 
		if( parameter.getParameterAnnotation( AuthUser.class ) ==null){
			
			return false;
		}

		System.out.println("4");
		// 파라미터의 타입 그러니까 authuser의 타입( Uservo ) 가 아니면 ..
		if(parameter.getParameterType().equals( UserVo.class.toString()) ==false ){
			
			return false;
			
		}
		
		return false;
	}

}
