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
	
	/**
	 * Method for sending a standard transaction after account opening
	 * @param SendStdTransactionRequest
	 * @return ResponseEntity<TransactionRTO>
	 */
	@Transactional
	public ResponseEntity<TransactionRTO> sendStandardTransaction(SendStdTransactionRequest request){		
		TransactionRTO response = transactionDao.sendStandardTransaction(request.getAccountId(), request.getCustomerId());		
		return new ResponseEntity<TransactionRTO>(response, HttpStatus.OK);
	}
	
	/**
	 * Method for retrieving all transactions
	 * @return ResponseEntity<List<TransactionRTO>>
	 */
	@Transactional
	public ResponseEntity<List<TransactionRTO>> getCustomerTransactions(Integer customerId) {
		List<TransactionRTO> response = transactionDao.getCustomerTransactions(customerId);
		return new ResponseEntity<List<TransactionRTO>>(response, HttpStatus.OK);
	}

}
