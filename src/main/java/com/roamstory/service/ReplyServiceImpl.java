package com.roamstory.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roamstory.domain.PageCriteriaVO;
import com.roamstory.domain.ReplyVO;
import com.roamstory.persistence.BoardDAO;
import com.roamstory.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO replyDAO;
	
	@Inject
	private BoardDAO boardDAO;

	@Transactional
	@Override
	public void addReply(ReplyVO replyVO) throws Exception {
		replyDAO.create(replyVO);
		boardDAO.updateReplyCnt(replyVO.getBbsno(), 1);
	}

	@Override
	public List<ReplyVO> listReply(Integer bbsno) throws Exception {
		return replyDAO.list(bbsno);
	}

	@Override
	public void modifyReply(ReplyVO replyVO) throws Exception {
		replyDAO.update(replyVO);
	}

	@Transactional
	@Override
	public void removeReply(Integer replyno) throws Exception {
		int bbsno = replyDAO.getBbsno(replyno);
		
		replyDAO.delete(replyno);
		boardDAO.updateReplyCnt(bbsno, -1);
		
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
