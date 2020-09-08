package com.fsecure.messageapi.model;

import javax.persistence.Entity;

import javax.persistence.Id;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;



@Entity
@JacksonXmlRootElement(localName = "messages")
public class Message {
	
	
	
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private String version;
	@Id 
	private String title;
	private String content;
	private String sender;
	private String url;
	
	public Message(){
		
	}
	
	
	
	public Message(String url  ,String title, String content, String sender) {
		super();
		this.url = url;
		//this.version = version;
		this.title = title;
		this.content = content;
		this.sender = sender;
	}



	public String getURL() {
		return url;
	}
	
	public void setURL(String uRL) {
		url = uRL;
	}
	
	//@JsonIgnore
	//@JsonProperty(value = "version")
	/*public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}*/
	
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
