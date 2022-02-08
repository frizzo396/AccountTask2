package com.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounts.entities.Customer;

public interface CustomerRepositoy extends JpaRepository<Customer, Integer> {

}
