package com.accounts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounts.client.AccountClient;
import com.accounts.dao.AccountDao;
import com.accounts.dao.CustomerDao;
import com.accounts.exception.AccountException;
import com.accounts.utility.AccountMsInputValidator;
import com.common.request.OpenAccountRequest;
import com.common.request.SendStdTransactionRequest;
import com.common.rto.AccountRTO;
import com.common.rto.TransactionRTO;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	AccountClient accountClient;
	
	@Transactional
	public ResponseEntity<AccountRTO> openAccount(OpenAccountRequest request) {	
		AccountMsInputValidator.validateInput(request);
		
		if(!customerDao.isValidCustomer(request.getCustomerId())) throw new AccountException("Customer doesn't exists.");		
		AccountRTO accountRTO = accountDao.openAccount(request);
		
		if(accountRTO.getCredit() != 0.0) {
			@SuppressWarnings("unused")
			ResponseEntity<TransactionRTO> response = accountClient.sendStandardTransaction(new SendStdTransactionRequest(accountRTO.getAccountId()));
		}
			
		return new ResponseEntity<AccountRTO>(accountRTO, HttpStatus.OK);
	}

}
