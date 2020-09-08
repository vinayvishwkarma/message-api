package com.fsecure.messageapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsecure.messageapi.model.Message;
import com.fsecure.messageapi.service.CreateMessageService;


@RestController
public class CreateMessageController {
	
	@Autowired
	private CreateMessageService createMessageService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/createMessages" )
	public ResponseEntity<String> addMessage(@RequestBody Message message) {
		
		if(createMessageService.isValidURL(message.getURL()))
		 createMessageService.addMessage(message);
		
		else
			return new ResponseEntity<>("Enter valid url e.g. message.com", HttpStatus.BAD_REQUEST);

		
		
		return new ResponseEntity<>("Message saved Successful message id is "+message.getTitle(), HttpStatus.OK);

	}

}
