package com.bank.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//Handling Specific Exception - AccountException
	@ExceptionHandler(AccountException.class)
	public ResponseEntity<ErrorDetails> handleAccountException(AccountException exc, WebRequest webReq){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), exc.getMessage(), webReq.getDescription(false), "ACCOUNT_NOT_FOUND");
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
	
	
	//Handling generic exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGenericException(Exception exc, WebRequest webReq){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), exc.getMessage(), webReq.getDescription(false), "INTERNAL_SERVER_ERROR");
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
