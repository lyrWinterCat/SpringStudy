package com.example.board.domain.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.board.domain.vo.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardDAOTests {
	
	@Autowired
	BoardDAO boardDAO;
	
	
	@Test
	public void daoTest() {
		log.info(boardDAO);
	}
	
	/*
	@Test
	public void registerTest() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("새로운 제목");
		boardVO.setContent("새로운 내용");
		boardVO.setWriter("새작성자");
		
		boardDAO.register(boardVO);
	}
	 * 
	@Test
	public void getTest() {
		log.info(boardDAO.get(61L));
	}
	
	@Test
	public void modifyTest() {
		BoardVO boardVO = boardDAO.get(61L);
		if(boardVO==null) {log.info("no board"); return;}
		boardVO.setTitle("수정했지롱");
		boardVO.setContent("수정햇숑");
		
		log.info("update : "+boardDAO.modify(boardVO));
	}
	
	@Test
	public void removeTest() {
		BoardVO boardVO = boardDAO.get(61L);
		if(boardVO==null) {log.info("no board"); return;}
		
		
		log.info("delete : "+boardDAO.remove(boardVO.getBno()));
	}
	 */
	
	@Test
	public void getListTest() {
		boardDAO.getList(new Criteria()).forEach(log::info);
	}
	
	
	

}
