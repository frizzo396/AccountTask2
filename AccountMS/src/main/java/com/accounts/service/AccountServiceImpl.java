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
import com.common.messages.ErrorMessages;
import com.common.request.OpenAccountRequest;
import com.common.request.SendStdTransactionRequest;
import com.common.rto.AccountRTO;
import com.common.rto.TransactionRTO;
import com.common.rto.UserInfoRTO;

@Service
public class AccountServiceImpl implements AccountService {
	
	public static final Double CREDIT_ZERO = 0.0; 	
	private AccountDao accountDao;	
	private CustomerDao customerDao;	
	private AccountClient accountClient;
	
	@Autowired
	public AccountServiceImpl(AccountDao accountDao, CustomerDao customerDao, AccountClient accountClient) {
	    this.accountDao = accountDao;
	    this.customerDao = customerDao;
	    this.accountClient = accountClient;
	}
	
	@Transactional
	public ResponseEntity<AccountRTO> openAccount(OpenAccountRequest request) {	
		AccountMsInputValidator.validateInput(request);
		if(!customerDao.isValidCustomer(request.getCustomerId())) throw new AccountException(ErrorMessages.CUST_NOT_EXISTS);		
		
		AccountRTO accountRTO = accountDao.openAccount(request);
		
		if(accountRTO.getCredit() > CREDIT_ZERO) {
			ResponseEntity<TransactionRTO> response = accountClient.sendStandardTransaction(new SendStdTransactionRequest(accountRTO.getAccountId()));
			
			if(!(response.getBody() == null)) {
				accountRTO.getTransactionsList().add(response.getBody());
			}		
		}
			
		return new ResponseEntity<AccountRTO>(accountRTO, HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<UserInfoRTO> getUserInfo(Integer customerId) {
		if(!customerDao.isValidCustomer(customerId)) throw new AccountException(ErrorMessages.CUST_NOT_EXISTS);	
		
		
		
		return null;
	}

}
