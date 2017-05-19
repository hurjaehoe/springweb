package com.roamstory.persistence;

import java.util.List;

import com.roamstory.domain.BoardVO;
import com.roamstory.domain.PageCriteriaVO;
import com.roamstory.domain.SearchCriteriaVO;

public interface BoardDAO {
	
	public void create(BoardVO boardVO) throws Exception;
	
	public BoardVO read(Integer bbsno) throws Exception;
	
	public void update(BoardVO boardVO) throws Exception;
	
	public void delete(Integer bbsno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listCriteria(PageCriteriaVO pageCriteriaVO) throws Exception;
	
	public int countPaging(PageCriteriaVO pageCriteriaVO) throws Exception;
	
	public List<BoardVO> listSearch(SearchCriteriaVO searchCriteriaVO) throws Exception;
	
	public int listSearchCount(SearchCriteriaVO searchCriteriaVO) throws Exception;
	
}
