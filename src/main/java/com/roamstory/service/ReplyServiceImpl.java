package com.roamstory.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.roamstory.domain.PageCriteriaVO;
import com.roamstory.domain.ReplyVO;
import com.roamstory.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO replyDAO;

	@Override
	public void addReply(ReplyVO replyVO) throws Exception {
		replyDAO.create(replyVO);
	}

	@Override
	public List<ReplyVO> listReply(Integer bbsno) throws Exception {
		return replyDAO.list(bbsno);
	}

	@Override
	public void modifyReply(ReplyVO replyVO) throws Exception {
		replyDAO.update(replyVO);
	}

	@Override
	public void removeReply(Integer replyno) throws Exception {
		replyDAO.delete(replyno);
		
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer bbsno, PageCriteriaVO criteriaVO) throws Exception {
		return replyDAO.listPage(bbsno, criteriaVO);
	}

	@Override
	public int count(Integer bbsno) throws Exception {
		return replyDAO.count(bbsno);
	}

}
