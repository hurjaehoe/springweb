package com.roamstory.persistence;

import com.roamstory.domain.MessageVO;

public interface MessageDAO {
	public void create(MessageVO messageVO) throws Exception;
	
	public MessageVO readMessage(Integer mno) throws Exception;
	
	public void updateState(Integer mno) throws Exception;
}
