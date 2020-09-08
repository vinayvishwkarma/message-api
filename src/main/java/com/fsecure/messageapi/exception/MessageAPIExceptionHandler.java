package com.fsecure.messageapi.exception;

import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
 

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
 
@ControllerAdvice
public class MessageAPIExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
   // private String BAD_REQUEST = "BAD_REQUEST";
     
    @ExceptionHandler(VersionException.class)
    public final ResponseEntity<ErrorResponse> invalidURLException
                        (VersionException ex, WebRequest request) 
    {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(INCORRECT_REQUEST, details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}