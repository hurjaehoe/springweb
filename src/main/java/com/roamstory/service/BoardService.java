package com.roamstory.service;

import java.util.List;

import com.roamstory.domain.BoardVO;

public interface BoardService {
	public void regist(BoardVO boardVO) throws Exception;
	
	public BoardVO read(Integer bbsno) throws Exception;
	
	public void modify(BoardVO boardVO) throws Exception;
	
	public void remove(Integer bbsno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;

}
