package com.fsecure.messageapi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsecure.messageapi.dto.FirstVersionMessageDTO;
import com.fsecure.messageapi.dto.SecoundVersionMessageDTO;
import com.fsecure.messageapi.model.Message;
import com.fsecure.messageapi.repository.MessageRepository;



@Service
public class ListMessagesService {
	
 @Autowired
 private MessageRepository messageRepository;
 
	
   public List<FirstVersionMessageDTO> getAllV1Messages(){
		
		List<Message> messages=new ArrayList<Message>();
		messageRepository.findAll().forEach(messages::add);
		
		return messageToFirstVersionMessageDTO(messages);
		  
		 
	}
   
   public List<SecoundVersionMessageDTO> getAllV2Messages(){
		
		List<Message> messages=new ArrayList<Message>();
		messageRepository.findAll().forEach(messages::add);
		
		return messageToSecoundVersionMessageDTO(messages);
		  
		 
	}


	
    
   public List<FirstVersionMessageDTO> messageToFirstVersionMessageDTO(List<Message> messages){
	   
	   List<FirstVersionMessageDTO> firstVersionMessageDTO = new ArrayList<FirstVersionMessageDTO>();
	   
	   
	   for(Iterator<Message> itr = messages.iterator();itr.hasNext();) {
		   
		   Message m =itr.next();
		   
		   firstVersionMessageDTO.add(new FirstVersionMessageDTO(m.getTitle(),m.getContent(),m.getSender()));
	   }
	   
	   return firstVersionMessageDTO;
   }
   
  public List<SecoundVersionMessageDTO> messageToSecoundVersionMessageDTO(List<Message> messages){
	   
	   List<SecoundVersionMessageDTO> secoundVersionMessageDTO = new ArrayList<SecoundVersionMessageDTO>();
	   
	   
	   for(Iterator<Message> itr = messages.iterator();itr.hasNext();) {
		   
		   Message m =itr.next();
		   SecoundVersionMessageDTO svm = new SecoundVersionMessageDTO();
		   svm.setTitle(m.getTitle());
		   svm.setContent(m.getContent());
		   svm.setSender(m.getSender());
		   svm.setUrl(m.getURL());
		   
		   secoundVersionMessageDTO.add(svm);
	   }
	   
	   
	   return secoundVersionMessageDTO;
   }
   
	
}
