package com.accounts.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.accounts.request.OpenAccountRequest;

@Service
public class AccountServiceImpl implements AccountService {

	
	@Transactional
	public ResponseEntity<String> openAccount(OpenAccountRequest request) {
		
		
		
		
		return null;
	}

}
