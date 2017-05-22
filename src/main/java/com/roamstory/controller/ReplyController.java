package com.roamstory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.roamstory.domain.PageCriteriaVO;
import com.roamstory.domain.PageMakerVO;
import com.roamstory.domain.ReplyVO;
import com.roamstory.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {

	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Inject
	private ReplyService replyService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO replyVO) {
		ResponseEntity<String> entity = null;
		try {
			replyService.addReply(replyVO);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/all/{bbsno}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bbsno") Integer bbsno) {
		ResponseEntity<List<ReplyVO>> entity = null;
		
		try {
			entity = new ResponseEntity<>(replyService.listReply(bbsno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/{replyno}", method = { RequestMethod.PUT, RequestMethod.PATCH}) 
	public ResponseEntity<String> update(@PathVariable("replyno") Integer replyno, @RequestBody ReplyVO replyVO) {
		ResponseEntity<String> entity = null;
		try {
			replyVO.setReplyno(replyno);
			replyService.modifyReply(replyVO);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/{replyno}", method = RequestMethod.DELETE) 
	public ResponseEntity<String> remove(@PathVariable("replyno") Integer replyno) {
		ResponseEntity<String> entity = null;
		try {
			replyService.removeReply(replyno);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/{bbsno}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage (
			@PathVariable("bbsno") Integer bbsno, 
			@PathVariable("page") Integer page) {
		
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			
			PageCriteriaVO criteriaVO = new PageCriteriaVO();
			
			criteriaVO.setPage(page);
			
			PageMakerVO pageMakerVO = new PageMakerVO();
			pageMakerVO.setCriteriaVO(criteriaVO);
			
			Map<String, Object> map = new HashMap<String, Object>();
			List<ReplyVO> replyList = replyService.listReplyPage(bbsno, criteriaVO);
			
			map.put("replyList", replyList);
			
			int replyCount = replyService.count(bbsno);
			pageMakerVO.setTotalCount(replyCount);
			
			map.put("pageMaker", pageMakerVO);
			
			entity =  new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			entity =  new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}
