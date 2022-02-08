package com.transactions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.transactions.dao.TransactionDao;
import com.transactions.request.SendStdTransactionRequest;
import com.transactions.rto.TransactionRTO;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionDao transactionDao;
	
	public ResponseEntity<TransactionRTO> sendStandardTransaction(SendStdTransactionRequest request){		
		TransactionRTO response = transactionDao.sendStandardTransaction(request.getAccountId());
		
		return new ResponseEntity<TransactionRTO>(response, HttpStatus.OK);
	}
}
