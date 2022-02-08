package com.common.request;

public class SendStdTransactionRequest {
	private Integer accountId;

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
