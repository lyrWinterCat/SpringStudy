package com.korea.test_di;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardServiceImpl;


/*
 * @ : 어노테이션 (프로그래밍 주석)
 * 컴파일러에게 오버라이딩 메서드임을 빠르게 캐치하고 
 * 정보를 제공하기 위한 용도로 사용하거나 특수한 기능으로써
 * 클래스가 작동하도록 하는 용도
 */

@Controller
public class BoardController {
	
	BoardServiceImpl service;
	
	//setter 인젝션으로 컨트롤러 생성을 하려면 기본 생성자가 있어야 함
	public BoardController() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardController(BoardServiceImpl service) {
		System.out.println("--생성자 인젝션으로 컨트롤러 생성--");
		this.service=service;
	}
	
	public void setService(BoardServiceImpl service) {
		//setter injection을 사용하기 위한 setter 메서드 생성
		System.out.println("--setter 인젝션으로 컨트롤러 생성--");
		this.service = service;
	}
	
	//사용자가 요청한 url을 접수
	// 사용자가 list.do를 요청하면 해당 메서드가 실행이 된다.
	// jsp의 url 매핑 형태라고 생각을 하면 된다.
	@RequestMapping("/list.do")
	public String list(Model model) { //HttpServletRequest request가 아니라
		//service를 통해서 dao의 selectList()를 호출할 수 있다
		List list = service.selectList();
		
		//바인딩
		//request.setAttribute("list",list); >> request는 너무 무거움
		model.addAttribute("list",list);
		return "board_list";
	}

}
