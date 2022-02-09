package com.common.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.common.messages.ErrorMessages;

public class OpenAccountRequest {
	
	@NotNull(message = ErrorMessages.CUST_NOT_VALORIZED)
	@Min(value = 1, message = ErrorMessages.CUST_MIN_VALUE)
	private Integer customerId;	
	
	@NotNull(message = ErrorMessages.INIT_CREDIT_NOT_VALORIZED)
	@Min(value = 0, message = ErrorMessages.INIT_CREDIT_NEGATIVE)
	private Double initialCredit;
	
	
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
