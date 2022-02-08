package com.common.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OpenAccountRequest {
	
	@NotNull(message = "Customer id must be valorized.")
	@Min(value = 1, message = "Customer id minimun value is 1.")
	private Integer customerId;	
	
	@NotNull(message = "Initial credit must be valorized.")
	@Min(value = 0, message = "Initial credi must be positive.")
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
