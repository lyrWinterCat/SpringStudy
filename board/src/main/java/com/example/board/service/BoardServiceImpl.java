package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.domain.vo.BoardVO;
import com.example.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void register(BoardVO board) {
		boardMapper.insert(board);
	}

	@Override
	public BoardVO get(Long bno) {		
		return boardMapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return boardMapper.update(board) !=0;
	}

	@Override
	public boolean remove(Long bno) {
		return boardMapper.delete(bno) !=0;
	}

	@Override
	public List<BoardVO> getList() {
		return boardMapper.getList();
	}

}
