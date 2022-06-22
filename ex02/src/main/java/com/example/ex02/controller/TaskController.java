package com.example.ex02.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex02.domain.vo.MemberVO;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class TaskController {
	/*
	 * 아이디와 비밀번호를 입력받은 후 아이디가 admin일 경우 admin.jsp로 이동
	 * 아이디가 user일 경우 user.jsp로 이동
	 * 
	 * - admin.jsp
	 * - uer.jsp
	 */
	
	/*
	@GetMapping("/login")
	public String login(MemberVO memberVO) {
		String path="";
		if(memberVO.getId().equals("admin")) {
			path= "ex/admin";
		}
		if(memberVO.getId().equals("user")) {
			path= "ex/user";
		}
		return path;
	}
	
	@GetMapping("/admin")
	public void admin() {
		log.info("관리자페이지");
	}
	@GetMapping("/user")
	public void user() {
		log.info("회원페이지");
	}
	 * 
	 */
	@GetMapping("loginForm")
	public String goLoginForm() {
		return "task/task01/login";
	}
	
	/*
	 * 외부에서 전달받은 아이디와 패스워드를 매개변수로 받는다
	 * 만약 아이디가 admin일 경우 admin.jsp로 이동
	 * 아닐 경우 user.jsp로 이동
	 */
	@PostMapping("/login")
	public String login(@ModelAttribute("id") String id,String pw) {
		log.info("들어왔당");
		if(id.equals("admin")) {
			return "task/task01/admin";
		}
		return "task/task01/user";
	}

}
