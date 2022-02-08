package com.accounts.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accounts.entities.Customer;
import com.accounts.repository.CustomerRepository;

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
}
