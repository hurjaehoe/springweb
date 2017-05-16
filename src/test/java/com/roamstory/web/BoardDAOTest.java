package com.roamstory.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.roamstory.domain.BoardVO;
import com.roamstory.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {
	
	@Inject
	private BoardDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Test
	public void testCreate() throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("스프링이란?");
	    board.setContent("스프링은 POJO....");
	    board.setWriter("user01");
	    dao.create(board);
	    
	}
	
	@Test
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVO board = new BoardVO();
		board.setBbsno(1);
		board.setTitle("스프링이란??");
	    board.setContent("스프링은 POJO 방식...");
	    board.setWriter("user01");
	    dao.update(board);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}

}
