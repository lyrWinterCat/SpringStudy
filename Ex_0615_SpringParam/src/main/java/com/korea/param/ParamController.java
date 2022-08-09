package com.korea.param;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.MyPath;
import vo.PersonVO;

@Controller
public class ParamController {
	
	// value라고 하는 속성은 배열 형식으로 여러가지 매핑을 줄 수 있다.
	@RequestMapping(value= {"/","/insert_form.do"})
	public String insert() {
		return MyPath.PATH+"insert_form.jsp";
	}
	
	@RequestMapping("insert1.do") //name=홍길동&age=12&tel=010-111-1111 값이 알아서 들어감
	public String insert1(Model model,String name, int age, String tel) {//insert1.do에서 넘어온 값을 이렇게 받는것 가능
//		String name=request.getParameter("") 으로 받았었음
		
		// name,age,tel 파라미터가 자동으로 넘어옴
		// 단 form에서의 name과 여기서 ()안의 name이 같아야 넘어옴
		// + 자료형이 일치해야 받아올 수 있음
		
		//insert_form에서 post로 보낼 경우 한글이 깨져서 들어옴 (HttpServletRequest request를 해도 먹지 않음)
		// 한글 깨짐 처리를 위해 encoding을 했지만 먹히지 않음
		// >> web.xml에서 처리를 해 주어야 함
		
//		try {
//			request.setCharacterEncoding("utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		PersonVO vo = new PersonVO();
		vo.setName(name);
		vo.setAge(age);
		vo.setTel(tel);
		
		model.addAttribute("vo",vo);
		
		return MyPath.PATH+"insert_result.jsp";
	}
	
	@RequestMapping("insert2.do")
	public String insert2(Model model,PersonVO vo) {
		//파라미터로 넘어온 name,age,tel을 vo객체에 자동으로 setting을 해준다.
		//vo에 있는 이름이 있다면 따로 받는 파라미터에 같은 이름이 있으면 오류가 난다
		//ex) PersonVO에 name이라는 객체가 있다면, (PersonVO vo , String name) 이렇게 쓸 경우 에러가 난다.
		
		model.addAttribute("vo",vo);
		return MyPath.PATH+"insert_result.jsp";
	}

}
