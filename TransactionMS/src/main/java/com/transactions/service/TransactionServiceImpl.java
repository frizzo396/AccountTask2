package com.transactions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.request.SendStdTransactionRequest;
import com.common.rto.TransactionRTO;
import com.transactions.dao.TransactionDao;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionDao transactionDao;
	
	@Transactional
	public ResponseEntity<TransactionRTO> sendStandardTransaction(SendStdTransactionRequest request){		
		TransactionRTO response = transactionDao.sendStandardTransaction(request.getAccountId());
		
		return new ResponseEntity<TransactionRTO>(response, HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<List<TransactionRTO>> getAllTransactions() {
		List<TransactionRTO> response = transactionDao.findAllTransactions();
		return new ResponseEntity<List<TransactionRTO>>(response, HttpStatus.OK);
	}

}
