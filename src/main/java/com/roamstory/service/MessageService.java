package com.roamstory.service;

import com.roamstory.domain.MessageVO;

public interface MessageService {
	
	public void addMessage(MessageVO messageVO) throws Exception;
	
	public MessageVO readMessage(String uid, Integer mno) throws Exception;

}
