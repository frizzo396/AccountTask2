package com.accounts.dao;

import com.common.rto.CustomerRTO;

public interface CustomerDao {
		
	Boolean isValidCustomer(Integer customerId);
	
	CustomerRTO findCustomerById(Integer customerId);
	
}
