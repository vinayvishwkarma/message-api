package com.fsecure.messageapi.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsecure.messageapi.model.Message;
import com.fsecure.messageapi.repository.MessageRepository;


@Service
public class CreateMessageService {
	
	
	
	@Autowired
	private MessageRepository messageRepository;
	
	public void addMessage(Message message) {
		
		
		messageRepository.save(message);
		
		
		
	
	}
	 public  boolean isValidURL(String url) {
		 
		 //String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		 String regex= "^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$";
		 
	        try {
	            Pattern patt = Pattern.compile(regex);
	            Matcher matcher = patt.matcher(url);
	            return matcher.matches();
	        } catch (RuntimeException e) {
	        return false;
	    }       
	}   
	

}
