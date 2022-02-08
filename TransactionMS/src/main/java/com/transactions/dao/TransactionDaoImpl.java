package com.transactions.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transactions.entities.Transaction;
import com.transactions.exception.TransactionException;
import com.transactions.repository.TransactionRepository;
import com.transactions.rto.TransactionRTO;

@Repository
public class TransactionDaoImpl implements TransactionDao {
	public static final Double STD_TRANS_AMOUNT = -1.0;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	public TransactionRTO sendStandardTransaction(Integer accountId) {	
		Transaction entity = createStdTransactionEntity(accountId);	
		Transaction result = Optional.of(transactionRepository.saveAndFlush(entity))
									 .orElseThrow(() -> new TransactionException("Error during transaction save."));
			
		return new TransactionRTO(result.getTransactionId(), result.getAmount(), result.getAccountId());
	}
	
	
	private Transaction createStdTransactionEntity(Integer accountId) {
		Transaction entity = new Transaction();		
		entity.setAmount(STD_TRANS_AMOUNT);
		entity.setAccountId(accountId);	
		return entity;
	}

}
