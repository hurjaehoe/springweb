package com.roamstory.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roamstory.domain.PageMakerVO;
import com.roamstory.domain.SearchCriteriaVO;
import com.roamstory.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {
	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listPage(@ModelAttribute("searchCriteriaVO") SearchCriteriaVO searchCriteriaVO
			,Model model) throws Exception {
		logger.info(searchCriteriaVO.toString());
		
		model.addAttribute("boardList",boardService.listSearch(searchCriteriaVO));
		
		PageMakerVO pageMakerVO = new PageMakerVO();
		
		pageMakerVO.setPageCriteriaVO(searchCriteriaVO);
		
		pageMakerVO.setTotalCount(boardService.listSearchCount(searchCriteriaVO));
		
		model.addAttribute("pageMaker", pageMakerVO);
	}

}
