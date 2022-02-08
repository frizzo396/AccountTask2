package com.transactions.service;

import org.springframework.http.ResponseEntity;

import com.transactions.request.SendStdTransactionRequest;
import com.transactions.rto.TransactionRTO;

public interface TransactionService {
	ResponseEntity<TransactionRTO> sendStandardTransaction(SendStdTransactionRequest request);
}
