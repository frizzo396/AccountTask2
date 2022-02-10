package com.accounts.dao.account;

import java.util.List;

import com.common.request.OpenAccountRequest;
import com.common.rto.AccountRTO;

public interface AccountDao {
	
	/**
	 * Method used to open a new account
	 * @param OpenAccountRequest
	 * @return AccountRTO
	 */
	AccountRTO openAccount(OpenAccountRequest request);
	
	/**
	 * Method used to update account credit
	 * @param accountId, amountTransactions
	 * @return Double
	 */
	Double updateCredit(Integer accountId, Double amountTransactions);
	
	/**
	 * Method used find account list by customer id
	 * @param customerId
	 * @return List<AccountRTO>
	 */
	List<AccountRTO> findAccountsByCustomerId(Integer customerId);
}
