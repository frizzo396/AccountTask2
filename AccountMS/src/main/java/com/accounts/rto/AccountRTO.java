package com.accounts.rto;

public class AccountRTO {
	
	private Integer accountId;
	
	private Double credit;
	
	private Integer customerId;
	
	
	public AccountRTO() {
		
	}
	
	public AccountRTO(Integer accountId, Double credit, Integer customerId) {
		this.accountId = accountId;
		this.credit = credit;
		this.customerId = customerId;
	}
	
	
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
		
}
