package com.accounts.dao.customer;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accounts.repository.CustomerRepository;
import com.common.entities.Customer;
import com.common.rto.CustomerRTO;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	CustomerRepository customerRepository;

	/**
	 * Method for checking if customer exists
	 * @param customerId
	 * @return Boolean
	 */
	public Boolean isValidCustomer(Integer customerId) {		
		Optional<Customer> customer = customerRepository.findById(customerId);
		
		if(customer.isPresent())
			return true;
		
		return false;
	}


	/**
	 * Method to find customer by his id
	 * @param customerId
	 * @return CustomerRTO
	 */
	public CustomerRTO findCustomerById(Integer customerId) {		
		CustomerRTO customerRTO = customerRepository.findCustomerRTObyIdCustomer(customerId);		
		return customerRTO;
	}
}
