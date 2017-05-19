package com.roamstory.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.roamstory.domain.BoardVO;
import com.roamstory.domain.PageCriteriaVO;
import com.roamstory.domain.SearchCriteriaVO;
import com.roamstory.web.BoardDAOTest;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.roamstroy.mapper.BoardMapper";

	@Override
	public void create(BoardVO boardVO) throws Exception {
		session.insert(namespace+".create", boardVO);
		
	}

	@Override
	public BoardVO read(Integer bbsno) throws Exception {
		
		return session.selectOne(namespace+".read", bbsno);
	}

	@Override
	public void update(BoardVO boardVO) throws Exception {
		session.update(namespace+".update", boardVO);
		
	}

	@Override
	public void delete(Integer bbsno) throws Exception {
		session.delete(namespace+".delete", bbsno);
		
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		
		return session.selectList(namespace+".listAll");
	}

	@Override
	public List<BoardVO> listCriteria(PageCriteriaVO criteriaVO) throws Exception {
		return session.selectList(namespace+".listCriteria", criteriaVO);
	}

	@Override
	public int countPaging(PageCriteriaVO criteriaVO) throws Exception {
		return session.selectOne(namespace+".countPaging", criteriaVO);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteriaVO criteriaVO) throws Exception {
		return session.selectList(namespace+".listSearch", criteriaVO);
	}

	@Override
	public int listSearchCount(SearchCriteriaVO criteriaVO) throws Exception {
		return session.selectOne(namespace+".listSearchCount", criteriaVO);
	}

}
