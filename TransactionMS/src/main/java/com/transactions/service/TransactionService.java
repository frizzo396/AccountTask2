package com.transactions.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.common.request.SendStdTransactionRequest;
import com.common.rto.TransactionRTO;

public interface TransactionService {
	
	/**
	 * Method for sending a standard transaction after account opening
	 * @param SendStdTransactionRequest
	 * @return ResponseEntity<TransactionRTO>
	 */
	ResponseEntity<TransactionRTO> sendStandardTransaction(SendStdTransactionRequest request);
	
	/**
	 * Method for retrieving all transactions
	 * @return ResponseEntity<List<TransactionRTO>>
	 */
	ResponseEntity<List<TransactionRTO>> getAllTransactions();

}
