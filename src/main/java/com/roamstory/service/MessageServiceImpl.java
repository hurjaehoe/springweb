package com.roamstory.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roamstory.domain.MessageVO;
import com.roamstory.persistence.MessageDAO;
import com.roamstory.persistence.PointDAO;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Inject
	private MessageDAO messageDAO;
	
	@Inject
	private PointDAO pointDAO;

	@Transactional
	@Override
	public void addMessage(MessageVO messageVO) throws Exception {
		messageDAO.create(messageVO);
		pointDAO.updatePoint(messageVO.getSender(), 10);
		
	}

	@Override
	public MessageVO readMessage(String uid, Integer mno) throws Exception {
		messageDAO.updateState(mno);
		pointDAO.updatePoint(uid, 5);
		
		return messageDAO.readMessage(mno);
	}
	
	

}
