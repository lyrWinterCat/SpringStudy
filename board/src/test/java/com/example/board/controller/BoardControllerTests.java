package com.example.board.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.board.domain.vo.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //설정파일 참고해서 돌아가라고 스프링에게 알려줌
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"	
})
@Log4j
public class BoardControllerTests {
	@Autowired
	private WebApplicationContext webApplicationContext;	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void listTest() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list").param("pageNum","1").param("amount","10")).andReturn().getModelAndView().getModelMap());
	}
	/*
	 * 
	@Test
	public void registerTest() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "테스트 새 글 제목")
				.param("content","테스트 새 글 내용")
				.param("writer", "lyr01234")
				).andReturn().getFlashMap());
	}
	 * 
	@Test
	public void readTest() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/read")
				.param("bno", "21") //왠만하면 클래스 타입으로 써주기
				).andReturn().getModelAndView().getModelMap());
	}
	 * 
	@Test
	public void removeTest() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/remove")
				.param("bno", "21")
				).andReturn().getFlashMap());
	}
	 * 
	@Test
	public void modifyTest() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "1")
				.param("title", "수정한 게시글 제목")
				.param("content","수정한 게시글 내용")
				.param("writer", "modify")
				).andReturn().getFlashMap());
		// ).andReturn().getModelAndView().getModelMap()); >> model.addAttribute로 값을 넘겼을때
		// 확인하는 방법
	}
	 * 
	@Test
	public void goModifyTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/board/modify").param("bno", "41"));
	}
	 */
	
	
	
	

}
