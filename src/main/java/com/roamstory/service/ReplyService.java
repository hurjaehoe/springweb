package com.roamstory.service;

import java.util.List;

import com.roamstory.domain.PageCriteriaVO;
import com.roamstory.domain.ReplyVO;

public interface ReplyService {
	
	public void addReply(ReplyVO replyVO) throws Exception;
	
	public List<ReplyVO> listReply(Integer bbsno) throws Exception;
	
	public void modifyReply(ReplyVO replyVO) throws Exception;
	
	public void removeReply(Integer replyno) throws Exception;
	
	public  List<ReplyVO> listReplyPage(Integer bbsno, PageCriteriaVO criteriaVO) throws Exception;
	
	public int count(Integer bbsno) throws Exception;

}
