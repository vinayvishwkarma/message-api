package com.fsecure.messageapi.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "message")
public class FirstVersionMessageDTO {

  private String title;
  private String content;
  private String sender;
  
   
public FirstVersionMessageDTO() {
	
}

public FirstVersionMessageDTO(String title, String content, String sender) {
	
	this.title = title;
	this.content = content;
	this.sender = sender;
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
  
  

}