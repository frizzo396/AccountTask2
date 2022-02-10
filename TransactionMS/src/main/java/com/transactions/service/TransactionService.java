package com.transactions.service;

import org.springframework.http.ResponseEntity;

import com.common.request.SendStdTransactionRequest;
import com.common.rto.TransactionRTO;

public interface TransactionService {
	ResponseEntity<TransactionRTO> sendStandardTransaction(SendStdTransactionRequest request);

}
