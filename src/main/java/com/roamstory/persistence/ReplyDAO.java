package com.roamstory.persistence;

import java.util.List;

import com.roamstory.domain.PageCriteriaVO;
import com.roamstory.domain.ReplyVO;

public interface ReplyDAO {
	
	public List<ReplyVO> list(Integer bbsno) throws Exception;
	
	public void create(ReplyVO replyVO) throws Exception;
	
	public void update(ReplyVO replyVO) throws Exception;
	
	public void delete(Integer replyno) throws Exception;
	
	public List<ReplyVO> listPage(Integer bbsno, PageCriteriaVO criteriaVO) throws Exception;
	
	public int count(Integer bbsno) throws Exception;

}
