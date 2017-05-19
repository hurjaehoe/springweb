package com.roamstory.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.roamstory.domain.BoardVO;
import com.roamstory.domain.PageCriteriaVO;
import com.roamstory.domain.SearchCriteriaVO;
import com.roamstory.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO;

	@Override
	public void regist(BoardVO boardVO) throws Exception {
		boardDAO.create(boardVO);
	}

	@Override
	public BoardVO read(Integer bbsno) throws Exception {
		
		return boardDAO.read(bbsno);
	}

	@Override
	public void modify(BoardVO boardVO) throws Exception {
		boardDAO.update(boardVO);
	}

	@Override
	public void remove(Integer bbsno) throws Exception {
		boardDAO.delete(bbsno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return boardDAO.listAll();
	}

	@Override
	public List<BoardVO> listCriteria(PageCriteriaVO criteriaVO) throws Exception {
		return boardDAO.listCriteria(criteriaVO);
	}

	@Override
	public int listCountPageCriteria(PageCriteriaVO criteriaVO) throws Exception {
		return boardDAO.countPaging(criteriaVO);
	}

	@Override
	public int listSearchCount(SearchCriteriaVO criteriaVO) throws Exception {
		return boardDAO.listSearchCount(criteriaVO);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteriaVO criteriaVO) throws Exception {
		
		return boardDAO.listSearch(criteriaVO);
	}

}
