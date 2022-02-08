package com.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.common.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
