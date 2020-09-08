package com.fsecure.messageapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
    //configurer.defaultContentType(MediaType.APPLICATION_XML);
	//to achieve dynamically format to render the data 
	//set path extension to false
		configurer.favorPathExtension(false).
	    //request parameter ("format" by default) should be used to determine the requested media type
	    favorParameter(true).
	    //the favour parameter is set to "mediaType" instead of default "format"
	    parameterName("format").
	    //ignore the accept headers
	    ignoreAcceptHeader(true).
	    //dont use Java Activation Framework since we are manually specifying the mediatypes required below
	    useJaf(false).
	    defaultContentType(MediaType.APPLICATION_JSON).
	    mediaType("xml", MediaType.APPLICATION_XML).
	    mediaType("json", MediaType.APPLICATION_JSON);
  }
}