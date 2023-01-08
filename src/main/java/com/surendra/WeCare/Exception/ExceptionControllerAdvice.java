package com.surendra.WeCare.Exception;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//this class is for handling controller exceptions
@RestControllerAdvice
public class ExceptionControllerAdvice {

	@Autowired
	private Environment env;
	
	//this method is for handling the general exceptions
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex) {
		return env.getProperty(ex.getMessage()) ;
	}
	
	@ExceptionHandler(WeCareException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(WeCareException ex){
		ErrorMessage error= new ErrorMessage();
		error.setMessage(env.getProperty(ex.getMessage()));
		error.setErrorCode(HttpStatus.BAD_GATEWAY.value());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.OK);
	}
}
