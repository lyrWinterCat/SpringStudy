package service;

import java.util.List;

import dao.BoardDAOImpl;

public class BoardServiceImpl implements BoardService{

	BoardDAOImpl dao;// 처음 생성시에는 null이지만 객체 생성지 생성자를 통해 값을 받아서 주입됨
//	UserDAOImpl dao2;
	
//	BoardDAOImpl dao = new BoardDAOImpl(); // 이 작업을 root-Context에서 한 것
	
	//String str;//=null 클래스 생성을 해놓으면 null값
	
							//,UserDAOImpl dao2
	public BoardServiceImpl(BoardDAOImpl dao) {
		//객체 생성될 시 외부에서 값을 받아서 BoardDAOImpl에 값이 들어가게 됨
		// 외부에서 들어온 dao를 생성자 injection을 통해서 받아 줄 예정(BoardDAOImple에 들어감)
		this.dao=dao;
	}
	
	@Override
	public List selectList() {
		//과일 목록이 들어있던 리스트를 반환해준다
		return dao.selectList();
	}
//	@Override
//	public List selectList() {
//		//유저 목록이 들어있던 리스트를 반환해준다
//		return dao2.selectList();
//	}
	
	/*
	 * 이런 식으로 dao를 여러개 받아서 적용할 수 있음
	 */

}
