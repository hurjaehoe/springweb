package com.roamstory.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roamstory.domain.BoardVO;
import com.roamstory.domain.PageCriteriaVO;
import com.roamstory.domain.PageMakerVO;
import com.roamstory.domain.SearchCriteriaVO;
import com.roamstory.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {
	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
	
	@Inject
	private BoardService boardService;
	
	/**
	 * 게시글을 등록할 수 있는 페이지로 이동한다.
	 * @param BoardVO 
	 * @param Model
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGet(BoardVO boardVO, Model model) throws Exception {
		logger.info("register get.....");
	}
	
	/**
	 * 게시글을 등록한다.
	 * @param BoardVO 
	 * @param RedirectAttributes
	 * @return /board/listAll 리다이렉트로 페이지 이동
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPost(BoardVO boardVO, RedirectAttributes rttr) throws Exception {
		
		logger.info("register get.....");
		logger.info(boardService.toString());
		
		boardService.regist(boardVO);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/sboard/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listPage(@ModelAttribute("criteriaVO") SearchCriteriaVO criteriaVO
			,Model model) throws Exception {
		logger.info(criteriaVO.toString());
		
		model.addAttribute("boardList",boardService.listSearch(criteriaVO));
		
		PageMakerVO pageMakerVO = new PageMakerVO();
		
		pageMakerVO.setCriteriaVO(criteriaVO);
		
		pageMakerVO.setTotalCount(boardService.listSearchCount(criteriaVO));
		
		model.addAttribute("pageMaker", pageMakerVO);
	}

	
	/**
	 * 해당 게시글 번호로 이동한다.
	 * @param bbsno 게시글 번호
	 * @param Model
	 * @throws Exception
	 */
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("bbsno") int bbsno
			         , @ModelAttribute("criteriaVO") SearchCriteriaVO criteriaVO
			         , Model model) throws Exception {
		logger.info("read get.....");
		
		model.addAttribute(boardService.read(bbsno));
	}
	
	/**
	 * 해당 게시글 번호를 삭제한다.
	 * @param bbsno
	 * @param RedirectAttributes
	 * @return /board/listAll
	 * @throws Exception
	 */
	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("bbsno") int bbsno,
			SearchCriteriaVO criteriaVO , RedirectAttributes rttr) throws Exception {
		
		logger.info("read get.....");
		
		boardService.remove(bbsno);
		
		rttr.addAttribute("page",criteriaVO.getPage());
		rttr.addAttribute("perPageNum",criteriaVO.getPerPageNum());
		rttr.addAttribute("searchType",criteriaVO.getSearchType());
		rttr.addAttribute("keyword",criteriaVO.getKeyword());
		rttr.addFlashAttribute("msg","success");
		
		return "redirect:/sboard/list";
	}
	
	/**
	 * 해당 게시글 번호를 수정하는 페이지로 이동한다.
	 * @param BoardVO
	 * @param Model
	 * @throws Exception
	 */
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyGet(@RequestParam("bbsno") int bbsno
			, @ModelAttribute("criteriaVO") SearchCriteriaVO criteriaVO
			, Model model) throws Exception {
		
		logger.info("modify get.....");
		
		model.addAttribute(boardService.read(bbsno));
	}
	
	/**
	 * 해당 게시글 번호를 수정한다.
	 * @param BoardVO
	 * @param RedirectAttributes
	 * @return /board/listAll
	 * @throws Exception
	 */
	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPost(BoardVO boardVO
			, SearchCriteriaVO criteriaVO
			, RedirectAttributes rttr) throws Exception {
		
		logger.info("modify post.....");
		
		boardService.modify(boardVO);
		
		rttr.addAttribute("page", criteriaVO.getPage());
		rttr.addAttribute("perPageNum", criteriaVO.getPerPageNum());
		rttr.addAttribute("searchType",criteriaVO.getSearchType());
		rttr.addAttribute("keyword",criteriaVO.getKeyword());
		rttr.addFlashAttribute("msg","success");
		
		return "redirect:/sboard/list";
	}
}
