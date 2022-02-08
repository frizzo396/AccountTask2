package com.accounts.service;

import org.springframework.http.ResponseEntity;

import com.common.request.OpenAccountRequest;
import com.common.rto.AccountRTO;

public interface AccountService {
	ResponseEntity<AccountRTO> openAccount(OpenAccountRequest request);
}
