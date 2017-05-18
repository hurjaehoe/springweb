package com.roamstory.service;

import java.util.List;

import com.roamstory.domain.BoardVO;
import com.roamstory.domain.PageCriteriaVO;

public interface BoardService {
	public void regist(BoardVO boardVO) throws Exception;
	
	public BoardVO read(Integer bbsno) throws Exception;
	
	public void modify(BoardVO boardVO) throws Exception;
	
	public void remove(Integer bbsno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listCriteria(PageCriteriaVO pageCriteriaVO) throws Exception;
	
	public int listCountPageCriteria(PageCriteriaVO pageCriteriaVO) throws Exception;

}
