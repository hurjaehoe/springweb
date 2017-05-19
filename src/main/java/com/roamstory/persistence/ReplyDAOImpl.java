package com.roamstory.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

}
