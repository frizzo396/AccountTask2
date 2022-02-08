package com.accounts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounts.dao.AccountDao;
import com.accounts.request.OpenAccountRequest;
import com.accounts.rto.AccountRTO;
import com.accounts.utility.AccountMsInputValidator;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountDao accountDao;
	
	@Transactional
	public ResponseEntity<AccountRTO> openAccount(OpenAccountRequest request) {
		
		AccountMsInputValidator.validateInput(request);		
		AccountRTO accountRTO = accountDao.openAccount(request);
			
		return new ResponseEntity<AccountRTO>(accountRTO, HttpStatus.OK);
	}

}
