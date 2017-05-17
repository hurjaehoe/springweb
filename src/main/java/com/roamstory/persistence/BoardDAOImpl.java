package com.roamstory.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.roamstory.domain.BoardVO;
import com.roamstory.domain.PageCriteriaVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
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
	public List<BoardVO> listCriteria(PageCriteriaVO pageCriteriaVO) throws Exception {
		return session.selectList(namespace+".listCriteria", pageCriteriaVO);
	}

}
