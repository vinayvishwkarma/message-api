package com.fsecure.messageapi.controller;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import static org.hamcrest.core.Is.is;

import static org.mockito.BDDMockito.given;

import static org.springframework.http.MediaType.APPLICATION_JSON;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.fsecure.messageapi.dto.FirstVersionMessageDTO;
import com.fsecure.messageapi.dto.SecoundVersionMessageDTO;
import com.fsecure.messageapi.service.ListMessagesService;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ListMessagesController.class)
public class ListMessagesControllerTest {
	
	@InjectMocks
	private ListMessagesController  listMessagesController;
	
	
	@MockBean
	private ListMessagesService listMessagesService;
	
	
	
	@Autowired
	MockMvc mockMvc;
	
	@BeforeEach
	void setUp() throws Exception{
		
		MockitoAnnotations.initMocks(this);

	}
	
	@Test
	public void test()  throws Exception{
		//public FirstVersionMessageDTO(String title, String content, String sender)
		 FirstVersionMessageDTO message = new FirstVersionMessageDTO("Alpha","greek letters","vinay");
		 
		    List<FirstVersionMessageDTO> allMessages = singletonList(message);
		    
		    Map<String, String> urlInput = new HashMap<String, String>();
		    urlInput.put("version","v1");
		 
	        given(listMessagesController.getAllV1Messages(urlInput)).willReturn(allMessages);
		 
	        MvcResult   result= mockMvc.perform(get("/message-api/v1/listMessages")
		      .contentType(MediaType.APPLICATION_JSON)).andReturn();
	        
	        
	        
	 	   int status = result.getResponse().getStatus();
	 	   assertEquals(201, status);
		
		   
	}
	
	@Test
	public void test_2()  throws Exception{
		//public SecoundVersionMessageDTO(String title, String content, String sender, String url) {
		 SecoundVersionMessageDTO message = new SecoundVersionMessageDTO("Alpha","greek letters","vinay","google.com");
		 
		    List<SecoundVersionMessageDTO> allMessages = singletonList(message);
		    
		    Map<String, String> urlInput = new HashMap<String, String>();
		    urlInput.put("version","v1");
		    urlInput.put("format","json");
		    
		    
		 
	        given(listMessagesController.getAllV2Messages(urlInput)).willReturn(allMessages);
		 
	        MvcResult   result=  mockMvc.perform(get("/message-api/v2/listMessages")
		      .contentType(MediaType.APPLICATION_JSON)).andReturn();
		    
		    int status = result.getResponse().getStatus();
		 	   assertEquals(201, status);
		    
		      
		    
		    
		   
	}
	
	

}
