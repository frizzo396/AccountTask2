package com.accounts.dao;

import com.accounts.request.OpenAccountRequest;
import com.accounts.rto.AccountRTO;

public interface AccountDao {
	
	AccountRTO openAccount(OpenAccountRequest request);
}
