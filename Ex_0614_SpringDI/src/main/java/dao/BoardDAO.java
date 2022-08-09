package dao;

import java.util.List;

public interface BoardDAO {
	/*
	 * DAO : (Data Access Object)
	 * 기본적으로 CRUD기능을 가지고 있음
	 * 나중에 사용할 추상메서드 준비해놓기
	 */

	//어떤 객체가 올 지 모르니까 최상위 객체로 써주기
	int insert(Object ob); //create
	List<Object> selectList(); //read
	int update(Object ob); //update
	int delete(int idx); //delete
}
