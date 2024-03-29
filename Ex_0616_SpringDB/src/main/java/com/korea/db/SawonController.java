package com.korea.db;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.SawonDAO;
import vo.SawonVO;

@Controller
public class SawonController {
	
	SawonDAO sawonDAO;
	public SawonController(SawonDAO sawonDAO) {
		this.sawonDAO=sawonDAO;
	}
	
	@RequestMapping(value= {"/","/sawon_list.do"})
	public String list(Model model) {
		List<SawonVO> list = sawonDAO.selectList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/sawon/sawon_list.jsp";
	}

}
