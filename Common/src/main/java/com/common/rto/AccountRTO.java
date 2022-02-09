package com.common.rto;

import java.util.List;

public class AccountRTO {
	
	private Integer accountId;
	
	private Double credit;
	
	private Integer customerId;
	
	private List<TransactionRTO> transactionsList;
		
	
	public AccountRTO() {
		
	}
	
	public AccountRTO(Integer accountId, Double credit, Integer customerId) {
		this.accountId = accountId;
		this.credit = credit;
		this.customerId = customerId;
	}
	
	
	
	public List<TransactionRTO> getTransactionsList() {
		return transactionsList;
	}

	public void setTransactionsList(List<TransactionRTO> transactionsList) {
		this.transactionsList = transactionsList;
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
