package com.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.common.entities.Customer;
import com.common.rto.CustomerRTO;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	/**
	 * Method which creates a CustomerRTO object with customer entity informations, find by customer Id
	 * @param customerId
	 * @return
	 */
	@Query("SELECT " +
	       "new com.common.rto.CustomerRTO(c.firstName, c.lastName, c.address) " +
	       "FROM Customer c " +
	       "WHERE c.id = :customerId")
	CustomerRTO findCustomerRTObyIdCustomer(@Param("customerId") Integer customerId);
}
