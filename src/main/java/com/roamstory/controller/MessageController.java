package com.roamstory.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.roamstory.domain.MessageVO;
import com.roamstory.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {

	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Inject
	private MessageService messageService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> addMessage(@RequestBody MessageVO messageVO) {
		ResponseEntity<String> entity = null;
		try {
			messageService.addMessage(messageVO);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

}
