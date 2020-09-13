package com.fsecure.messageapi.controller;



import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fsecure.messageapi.model.Message;




import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.springframework.http.MediaType.APPLICATION_JSON;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CreateMessageController.class)
@WebAppConfiguration
public class CreateMessageControllerTest {

	

	

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	 @Autowired
	   WebApplicationContext webApplicationContext;
	
	
	protected void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	
	@Test
	public void test() throws Exception {
	//public Message(String url  ,String title, String content, String sender)
	   Message message = new Message("google.com","Unit test","Create msg unit test","vinay");
	   
	   
	   MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/message-api/createMessages")
			      .contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(message))).andReturn();
			   
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(201, status);
	   
	   String content = mvcResult.getResponse().getContentAsString();
	   assertEquals(content, "Message saved Successful message id is "+message.getTitle());
	   
	  
	  
	
	}
}




