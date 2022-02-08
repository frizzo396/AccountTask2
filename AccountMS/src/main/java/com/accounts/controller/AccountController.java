package com.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.request.OpenAccountRequest;
import com.accounts.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	
	@PostMapping(value="/openAccount")
	public ResponseEntity<String> openAccount(@RequestBody OpenAccountRequest request){
		
		
		return null;
	}
	
}
