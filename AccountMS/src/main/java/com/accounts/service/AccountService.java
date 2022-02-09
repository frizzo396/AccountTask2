package com.accounts.service;

import org.springframework.http.ResponseEntity;

import com.common.request.OpenAccountRequest;
import com.common.rto.AccountRTO;
import com.common.rto.UserInfoRTO;

public interface AccountService {
	ResponseEntity<AccountRTO> openAccount(OpenAccountRequest request);
	ResponseEntity<UserInfoRTO> getUserInfo(Integer customerId);
}
