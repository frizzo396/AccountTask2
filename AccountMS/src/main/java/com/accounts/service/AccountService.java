package com.accounts.service;

import org.springframework.http.ResponseEntity;

import com.common.request.OpenAccountRequest;
import com.common.rto.AccountRTO;
import com.common.rto.UserInfoRTO;

public interface AccountService {
	
	/**
	 * Method used to open a new account
	 * @param OpenAccountRequest
	 * @return ResponseEntity<AccountRTO>
	 */
	ResponseEntity<AccountRTO> openAccount(OpenAccountRequest request);
	
	/**
	 * Method used to retrieve user's informations
	 * @param customerId
	 * @return ResponseEntity<UserInfoRTO>
	 */
	ResponseEntity<UserInfoRTO> getUserInfo(Integer customerId);
}
