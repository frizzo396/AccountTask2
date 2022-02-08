package com.accounts.service;

import org.springframework.http.ResponseEntity;

import com.accounts.request.OpenAccountRequest;

public interface AccountService {
	ResponseEntity<String> openAccount(OpenAccountRequest request);
}
