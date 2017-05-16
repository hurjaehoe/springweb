package com.roamstory.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roamstory.domain.BoardVO;
import com.roamstory.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService boardService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGet(BoardVO boardVO, Model model) throws Exception {
		logger.info("register get.....");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPost(BoardVO boardVO, RedirectAttributes rttr) throws Exception {
		
		logger.info("register get.....");
		logger.info(boardService.toString());
		
		boardService.regist(boardVO);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("listAll get.....");
		
		model.addAttribute("boardList", boardService.listAll());
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void listAll(@RequestParam("bbsno") int bbsno, Model model) throws Exception {
		logger.info("read get.....");
		
		model.addAttribute(boardService.read(bbsno));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGet(BoardVO boardVO, Model model) throws Exception {
		logger.info("modify get.....");
		
		model.addAttribute(boardService.read(boardVO.getBbsno()));
	}
	
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPost(BoardVO boardVO, RedirectAttributes rttr) throws Exception {
		logger.info("modify post.....");
		boardService.modify(boardVO);
		
		rttr.addFlashAttribute("msg","success");
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bbsno") int bbsno, RedirectAttributes rttr) throws Exception {
		logger.info("read get.....");
		boardService.remove(bbsno);
		
		rttr.addFlashAttribute("msg","success");
		
		return "redirect:/board/listAll";
	}

}
