package com.fsecure.messageapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@SpringBootApplication
@EnableWebMvc
public class MessageApiApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/message-api");
		SpringApplication.run(MessageApiApplication.class, args);
	}

}
