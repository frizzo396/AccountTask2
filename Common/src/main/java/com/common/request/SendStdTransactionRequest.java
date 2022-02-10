package com.common.request;

/**
 * Request for /sendStandardTransaction endpoint
 *
 */
public class SendStdTransactionRequest {
	
	/**
	 * Fields
	 */
	private Integer accountId;
	
	
	/**
	 * Getters and setters
	 */
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public SendStdTransactionRequest() {
		
	}
	
	public SendStdTransactionRequest(Integer accountId) {
		this.accountId = accountId;
	}
	
}
