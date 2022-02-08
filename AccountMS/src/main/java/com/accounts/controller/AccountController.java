package com.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.request.OpenAccountRequest;
import com.accounts.rto.AccountRTO;
import com.accounts.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	
	@PostMapping(value="/openAccount",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountRTO> openAccount(@RequestBody OpenAccountRequest request){		
		ResponseEntity<AccountRTO> response = accountService.openAccount(request);
		return response;
	}
	
}
