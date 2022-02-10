package com.common.rto;

/**
 * Transaction return object
 */
public class TransactionRTO {
	
	/**
	 * Fields
	 */
	private Integer transactionId;
	
	private Double amount;
	
	private Integer accountId;

	
	/**
	 * Constructors
	 */
	public TransactionRTO() {
		
	}
	
	public TransactionRTO(Integer transactionId, Double amount, Integer accountId) {
		this.accountId = accountId;
		this.amount = amount;
		this.transactionId = transactionId;
	}
	
	/**
	 * Getters and setters
	 */
	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	
}
