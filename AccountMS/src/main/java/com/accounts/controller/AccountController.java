package com.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.service.AccountService;
import com.common.request.OpenAccountRequest;
import com.common.rto.AccountRTO;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	
	@PutMapping(value="/openAccount", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountRTO> openAccount(@RequestBody OpenAccountRequest request){		
		ResponseEntity<AccountRTO> response = accountService.openAccount(request);
		return response;
	}
		
}
