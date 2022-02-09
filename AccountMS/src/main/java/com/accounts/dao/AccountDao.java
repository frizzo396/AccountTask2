package com.accounts.dao;

import java.util.List;

import com.common.request.OpenAccountRequest;
import com.common.rto.AccountRTO;

public interface AccountDao {
	
	AccountRTO openAccount(OpenAccountRequest request);
	
	List<AccountRTO> findAccountsByCustomerId(Integer customerId);
}
