package com.transactions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transactions.request.SendStdTransactionRequest;
import com.transactions.rto.TransactionRTO;
import com.transactions.service.TransactionService;

@RestController
public class TransactionController {
		
	@Autowired
	TransactionService transactionService;
	
	
	@PutMapping(value = "/sendStdTransaction", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionRTO> sendStandardTransaction(@RequestBody SendStdTransactionRequest request){	
		ResponseEntity<TransactionRTO> response = transactionService.sendStandardTransaction(request);
		
		return response;
	}
}
