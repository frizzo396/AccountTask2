package com.common.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.common.messages.ErrorMessages;

/**
 * Request for /openAccount endpoint
 *
 */
public class OpenAccountRequest {
	
	/**
	 * Fields
	 */
	@NotNull(message = ErrorMessages.CUST_NOT_VALORIZED)
	@Min(value = 1, message = ErrorMessages.CUST_MIN_VALUE)
	private Integer customerId;	
	
	@NotNull(message = ErrorMessages.INIT_CREDIT_NOT_VALORIZED)
	@Min(value = 0, message = ErrorMessages.INIT_CREDIT_NEGATIVE)
	private Double initialCredit;
	
	/**
	 * Getters and setters
	 */
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Double getInitialCredit() {
		return initialCredit;
	}
	public void setInitialCredit(Double initialCredit) {
		this.initialCredit = initialCredit;
	}
	
	
}
