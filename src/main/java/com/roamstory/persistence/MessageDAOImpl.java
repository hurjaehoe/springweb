package com.roamstory.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.roamstory.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.roamstory.mapper.MessageMapper";

	@Override
	public void create(MessageVO messageVO) throws Exception {
		session.insert(namespace+".create", messageVO);
		
	}

	@Override
	public MessageVO readMessage(Integer mno) throws Exception {
		return session.selectOne(namespace+".readMessage", mno);
	}

	@Override
	public void updateState(Integer mno) throws Exception {
		session.update(namespace+".updateState", mno);
	}
	
	
}
