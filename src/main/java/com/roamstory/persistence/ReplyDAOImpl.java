package com.roamstory.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.roamstory.domain.PageCriteriaVO;
import com.roamstory.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.roamstory.mapper.ReplyMapper";

	@Override
	public List<ReplyVO> list(Integer bbsno) throws Exception {
		
		return session.selectList(namespace + ".list", bbsno);
	}

	@Override
	public void create(ReplyVO replyVO) throws Exception {
		
		session.insert(namespace + ".create", replyVO);
		
	}

	@Override
	public void update(ReplyVO replyVO) throws Exception {
		session.update(namespace + ".update", replyVO);
		
	}

	@Override
	public void delete(Integer replyno) throws Exception {
		session.delete(namespace + ".delete", replyno);
		
	}

	@Override
	public List<ReplyVO> listPage(Integer bbsno, PageCriteriaVO criteriaVO) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("bbsno", bbsno);
		paramMap.put("criteriaVO", criteriaVO);
		
		return session.selectList(namespace + ".listPage", paramMap);
	}

	@Override
	public int count(Integer bbsno) throws Exception {
		return session.selectOne(namespace + ".count", bbsno);
	}

	@Override
	public int getBbsno(Integer replyno) throws Exception {
		return session.selectOne(namespace+ ".getBbsno", replyno);
	}

}
