package com.roamstory.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.roamstory.domain.BoardVO;
import com.roamstory.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardServiceTest {
	
	@Inject
	private BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);

	@Test
	public void testRegist() throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("스프링이란?");
	    board.setContent("스프링은 POJO....");
	    board.setWriter("user01");
	    boardService.regist(board);
	    
	}
	
	@Test
	public void testRead() throws Exception {
		logger.info(boardService.read(2).toString());
	}
	
	@Test
	public void testModify() throws Exception {
		BoardVO board = new BoardVO();
		board.setBbsno(2);
		board.setTitle("스프링이란??");
	    board.setContent("스프링은 POJO 방식의...");
	    board.setWriter("user01");
	    boardService.modify(board);
	    logger.info(boardService.read(2).toString());
	}
	
	@Test
	public void testRemove() throws Exception {
		boardService.remove(2);
	}
	
	
	@Test
	public void testListAll() throws Exception {
		logger.info(boardService.listAll().toString());
	}

}
