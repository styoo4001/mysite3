package kr.co.saramin.mysite.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.saramin.mysite.dto.JSONResult;
import kr.co.saramin.mysite.service.UserService;
import kr.co.saramin.mysite.vo.UserVo;

@Controller ( "userApiController") // 패키지가 다르지만 컨트롤러가 같은경우 컨테이너에 올라갈 클래스 이름을 위와 같이 지정할 수 있다. 
@RequestMapping("/user/api")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping( "/checkemail")
	@ResponseBody
	public Object checkEmail() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("result", "success");
		map.put("message", "................." );
		map.put("data", new Integer(1) );
		
		return map;
		
		
		
	}
	
	@RequestMapping( "/checkemaildto")
	@ResponseBody
	public Object checkEmailDto(
			@RequestParam( value="email", required=false, defaultValue="") String email) {
		
		UserVo userVo= userService.getUser( email);
		
		Boolean result = userVo== null;// true-> 사용중이 아님
										//false -> 사용중
		
		
				
		return new JSONResult(true, result);
		
		
		
	}
	
}
