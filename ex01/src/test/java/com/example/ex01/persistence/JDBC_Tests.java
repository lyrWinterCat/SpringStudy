package com.example.ex01.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class JDBC_Tests {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	//에러가 생길 시 자동 close
	@Test
	public void testConnection() {
		try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr")){
			log.info(connection);
		}catch(Exception e) {
			//JUnit의 메소드. 무조건 실패로 처리한 뒤 실행을 중지함
			fail(e.getMessage());
		}
	}

}
