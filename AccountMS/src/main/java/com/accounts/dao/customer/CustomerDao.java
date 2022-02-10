package com.accounts.dao.customer;

import com.common.rto.CustomerRTO;

public interface CustomerDao {
		
	Boolean isValidCustomer(Integer customerId);
	
	CustomerRTO findCustomerById(Integer customerId);
	
}
