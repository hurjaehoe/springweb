package com.roamstory.service;

import java.util.List;

import com.roamstory.domain.BoardVO;
import com.roamstory.domain.PageCriteriaVO;import com.roamstory.domain.SearchCriteriaVO;

public interface BoardService {
	public void regist(BoardVO boardVO) throws Exception;
	
	public BoardVO read(Integer bbsno) throws Exception;
	
	public void modify(BoardVO boardVO) throws Exception;
	
	public void remove(Integer bbsno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listCriteria(PageCriteriaVO criteriaVO) throws Exception;
	
	public int listCountPageCriteria(PageCriteriaVO criteriaVO) throws Exception;
	
	public List<BoardVO> listSearch(SearchCriteriaVO criteriaVO) throws Exception;
	
	public int listSearchCount(SearchCriteriaVO criteriaVO) throws Exception;

}
