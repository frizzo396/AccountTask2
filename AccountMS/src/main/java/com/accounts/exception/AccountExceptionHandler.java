package com.accounts.exception;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.common.messages.ErrorMessages;

@RestControllerAdvice(basePackages = "com.accounts.controller")
public class AccountExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = AccountException.class)
	public ResponseEntity<String> testoException(AccountException exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<String> illegalArgumentException(IllegalArgumentException exception){
		return new ResponseEntity<String>(ErrorMessages.ACCESS_DATA_ERROR, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = ServiceException.class)
	public ResponseEntity<String> serviceException(ServiceException exception){
		return new ResponseEntity<String>(ErrorMessages.FIND_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> exception(Exception exception){
		return new ResponseEntity<String>(ErrorMessages.GENERIC_ERROR, HttpStatus.METHOD_NOT_ALLOWED);
	}
}
