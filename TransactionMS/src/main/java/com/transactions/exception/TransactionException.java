package com.transactions.exception;

@SuppressWarnings("serial")
public class TransactionException extends RuntimeException {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
	
	
	public TransactionException(String message) {
		this.message = message;
	}
}
