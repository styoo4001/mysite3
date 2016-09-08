package kr.co.saramin.mysite.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping( "/index" )
	public String index() {
		
		System.out.println(" hollo jrebel");
		return "main/index";
	}
	
	
	@RequestMapping( "/hello")
	@ResponseBody
	public String hello() {
		
		return "안녕";
	}
	
	@RequestMapping( "/ajax")
	@ResponseBody
	public Object ajax(){
		
		Map<String, Object> map = new HashMap<String, Object>();
				
		map.put("name", "안대혁");
		map.put("value", new Integer(1) );
		
		return map;
	 // 이걸 그냥 리턴 하면 맵을 메세지컨버터 하지 못하기땜에 에러가 난다. 이 맵 자체를 json으로 바로 바꿔주는 메세지컨버터를 쓰면 됨..
		
		
	}
	
	
}
