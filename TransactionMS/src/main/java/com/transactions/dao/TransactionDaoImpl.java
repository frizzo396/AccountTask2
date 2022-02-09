package com.transactions.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.common.entities.Transaction;
import com.common.messages.ErrorMessages;
import com.common.rto.TransactionRTO;
import com.transactions.exception.TransactionException;
import com.transactions.repository.TransactionRepository;

@Repository
public class TransactionDaoImpl implements TransactionDao {
	public static final Double STD_TRANS_AMOUNT = -1.0;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	public TransactionRTO sendStandardTransaction(Integer accountId) {	
		Transaction entity = createStdTransactionEntity(accountId);	
		Transaction result = Optional.of(transactionRepository.saveAndFlush(entity))
									 .orElseThrow(() -> new TransactionException(ErrorMessages.SAVE_ERROR));
			
		return new TransactionRTO(result.getTransactionId(), result.getAmount(), result.getAccountId());
	}
	
	
	private Transaction createStdTransactionEntity(Integer accountId) {
		Transaction entity = new Transaction();		
		entity.setAmount(STD_TRANS_AMOUNT);
		entity.setAccountId(accountId);	
		return entity;
	}

}
