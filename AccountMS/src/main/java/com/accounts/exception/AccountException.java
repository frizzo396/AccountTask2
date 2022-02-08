package com.accounts.exception;

@SuppressWarnings("serial")
public class AccountException extends RuntimeException {
	
	private String message;
	
	public AccountException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
