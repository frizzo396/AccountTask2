package com.accounts.dao.customer;

import com.common.rto.CustomerRTO;

public interface CustomerDao {
	
	/**
	 * Method for checking if customer exists
	 * @param customerId
	 * @return Boolean
	 */
	Boolean isValidCustomer(Integer customerId);
	
	/**
	 * Method to find customer by his id
	 * @param customerId
	 * @return CustomerRTO
	 */
	CustomerRTO findCustomerById(Integer customerId);
	
}
