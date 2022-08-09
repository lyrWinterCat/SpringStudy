package com.korea.visit;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.VisitDAO;
import util.MyCommon;
import vo.VisitVO;

@Controller
public class VisitOpenApiController {
	
	VisitDAO visit_dao;
	
	public void setVisit_dao(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}
	

	
	//목록 전체조회
		@RequestMapping(value= {"/","list.do"})
		public String list(Model model) {
			List<VisitVO> list = visit_dao.selectList(); 
			model.addAttribute("list",list); 
			
			 return MyCommon.VIEW_PATH+"visit_list.jsp"; 
		}
		

}
