package com.roamstory.persistence;

import java.util.List;

import com.roamstory.domain.BoardVO;

public interface BoardDAO {
	
	public void create(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer bbsno) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public void delete(Integer bbsno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
}
