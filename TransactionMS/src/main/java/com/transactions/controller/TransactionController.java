package com.transactions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.common.request.SendStdTransactionRequest;
import com.common.rto.TransactionRTO;
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
	
	@GetMapping(value = "/getAccountsTransactions", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionRTO>> getAccountsTransactions(@RequestParam(required = true) List<Integer> accountIds){	
		//ResponseEntity<List<TransactionRTO>> response = transactionService.sendStandardTransaction(request);
		
		return null;
	}
}
