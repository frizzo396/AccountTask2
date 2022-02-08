package com.accounts.service;

import org.springframework.http.ResponseEntity;

import com.accounts.request.OpenAccountRequest;
import com.accounts.rto.AccountRTO;

public interface AccountService {
	ResponseEntity<AccountRTO> openAccount(OpenAccountRequest request);
}
