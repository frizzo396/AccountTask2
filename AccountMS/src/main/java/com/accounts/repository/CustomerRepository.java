package com.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.common.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
