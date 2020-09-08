package com.fsecure.messageapi.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "message")
public class SecoundVersionMessageDTO {
	
	
	  private String title;
	  private String content;
	  private String sender;
	  private String url;
	  
	  
	public SecoundVersionMessageDTO() {
		super();
		
	}


	public SecoundVersionMessageDTO(String title, String content, String sender, String url) {
		super();
		this.title = title;
		this.content = content;
		this.sender = sender;
		this.url = url;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	  
	  

}
