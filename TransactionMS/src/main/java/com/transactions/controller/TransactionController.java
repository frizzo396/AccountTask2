package com.transactions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.common.request.SendStdTransactionRequest;
import com.common.rto.TransactionRTO;
import com.transactions.service.TransactionService;

@RestController
public class TransactionController {
		
	@Autowired
	TransactionService transactionService;
	
	/**
	 * Method to send a standard transaction after account opening
	 * @param SendStdTransactionRequest
	 * @return ResponseEntity<TransactionRTO>
	 */
	@PutMapping(value = "/sendStdTransaction", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionRTO> sendStandardTransaction(@RequestBody SendStdTransactionRequest request){	
		ResponseEntity<TransactionRTO> response = transactionService.sendStandardTransaction(request);		
		return response;
	}
	
	/**
	 * Method for retrieve all transactions
	 * @return ResponseEntity<List<TransactionRTO>>
	 */
	@GetMapping(value = "/getAllTransactions", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionRTO>> getAllTransactions(){	
		ResponseEntity<List<TransactionRTO>> response = transactionService.getAllTransactions();		
		return response;
	}
	
}
