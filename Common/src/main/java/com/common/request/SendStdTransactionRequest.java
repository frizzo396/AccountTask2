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
	
	private Integer customerId;
	
	
	/**
	 * Getters and setters
	 */
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public SendStdTransactionRequest() {
		
	}
	
	public SendStdTransactionRequest(Integer accountId, Integer customerId) {
		this.accountId = accountId;
		this.customerId = customerId;
	}
	
}
