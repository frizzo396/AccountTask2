package com.transactions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.common.entities.Transaction;
import com.common.rto.TransactionRTO;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
		
	@Query("SELECT " +
		       "new com.common.rto.TransactionRTO(t.transactionId, t.amount, t.accountId) " +
		       "FROM Transaction t")
	List<TransactionRTO> findAllTransactions();
		
}
