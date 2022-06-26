package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;

@Mapper
public interface BoardMapper {
	//@Select("SELECT * FROM TBL_BOARD")
	public List<BoardVO> getList(Criteria criteria);
	
	public void insert(BoardVO board);
	public BoardVO read(Long bno);
	public int delete(Long bno);
	public int update(BoardVO board);

}
