package com.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Account entity
 */
@Entity
@Table(name = "accounts")
public class Account {
	
	/**
	 * Fields
	 */
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID")
	private Integer accountId;
	
	@Column(name = "CREDIT")
	private Double credit;
	
	@Column(name = "CUSTOMER_ID")
	private Integer customer;

	
	/**
	 * Getters and setters
	 */
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

	public Integer getCustomer() {
		return customer;
	}

	public void setCustomer(Integer customer) {
		this.customer = customer;
	}
	
}
