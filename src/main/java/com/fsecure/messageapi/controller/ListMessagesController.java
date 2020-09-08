package com.fsecure.messageapi.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsecure.messageapi.dto.FirstVersionMessageDTO;
import com.fsecure.messageapi.dto.SecoundVersionMessageDTO;
import com.fsecure.messageapi.exception.VersionException;
import com.fsecure.messageapi.service.ListMessagesService;



@RestController
public class ListMessagesController {
	
	@Autowired
	private ListMessagesService listMessagesService;
	
	
	@RequestMapping(value ="v1/listMessages" , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<FirstVersionMessageDTO> getAllV1Messages(@RequestParam Map<String,String> allParams){
		
		   if (allParams.get("version").equalsIgnoreCase("v1") && allParams.size() == 1)
			return listMessagesService.getAllV1Messages();
		
		
		   else
			   throw new VersionException("only one parameter is valid i.e. version") ;
			
	}
	
	
	@RequestMapping(value ="v2/listMessages" , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<SecoundVersionMessageDTO> getAllV2Messages(@RequestParam Map<String,String> allParams){
		
		   if (allParams.get("version").equalsIgnoreCase("v2") && allParams.containsKey("format") 
				   && (allParams.get("format").equalsIgnoreCase("xml") || allParams.get("format").equalsIgnoreCase("json") ) 
				   && allParams.size() > 1) {
			   	return listMessagesService.getAllV2Messages();
		   }
		   
		   else
			  throw new VersionException("please make request as version=v2&format=xml or json") ;
		
			
	}
	
	
	
}
