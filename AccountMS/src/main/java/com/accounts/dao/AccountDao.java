package com.accounts.dao;

import com.common.request.OpenAccountRequest;
import com.common.rto.AccountRTO;

public interface AccountDao {
	
	AccountRTO openAccount(OpenAccountRequest request);
}
