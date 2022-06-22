package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// 어떤 프로그램으로 돌릴거야? + root-context에 경로 알려주기 + log객체로 출력해서 알아보기
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DependencyTests {
	@Autowired
	private Coding coding;
	
	@Test
	public void checkDependencyInjection() {
		log.info("-----------------------------");
		log.info("coding : "+coding);
		log.info("computer : "+coding.getComputer());
		log.info("-----------------------------");
	}
	// root0context.xml에서 namespace 설정 + source에 context-scan 설정 적어주기

}
