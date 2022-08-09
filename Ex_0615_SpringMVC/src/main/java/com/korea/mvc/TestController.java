package com.korea.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import util.MyPath;
import util.MyPath2;

@Controller
public class TestController {
	
	public TestController() {
		System.out.println("--TestController()-- 생성자 호출");
	}
	
	@RequestMapping("/test.do")
	public String test(Model model,HttpServletRequest request) {
		
		String[] msg= {"사과","딸기", "배","수박","포도","참외"};
		String ip=request.getRemoteAddr();
		
		model.addAttribute("msg",msg);
		model.addAttribute("ip",ip);
		
		
//		return MyPath.TestClass.VIEW_PATH + "test.jsp"; >> 사용 경로가 여러개일때 : inner클래스 사용
		return MyPath2.VIEW_PATH2+"test.jsp"; // 단일 경로 사용 : 인터페이스 사용
	}

}
