package com.accounts.dao;

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

	
	public Boolean isValidCustomer(Integer customerId) {		
		Optional<Customer> customer = customerRepository.findById(customerId);
		
		if(customer.isPresent())
			return true;
		
		return false;
	}


	
	public CustomerRTO findCustomerById(Integer customerId) {		
		CustomerRTO customerRTO = customerRepository.findCustomerRTObyIdCustomer(customerId);		
		return customerRTO;
	}
}
