package com.accounts.dao.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accounts.exception.AccountException;
import com.accounts.repository.AccountRepository;
import com.common.entities.Account;
import com.common.messages.ErrorMessages;
import com.common.request.OpenAccountRequest;
import com.common.rto.AccountRTO;

@Repository
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	AccountRepository accountRepository;
	
	
	/**
	 * Method used to open a new account
	 * @param OpenAccountRequest
	 * @return AccountRTO
	 */
	public AccountRTO openAccount(OpenAccountRequest request) {
		
		Account entity = buildAccountEntity(request.getCustomerId(), request.getInitialCredit()); //Builds entity to save on DB		
		Account response = Optional.of(accountRepository.saveAndFlush(entity))
								   .orElseThrow(() -> new AccountException(ErrorMessages.SAVE_ERROR));
		
		return new AccountRTO(response.getAccountId(), response.getCredit(), response.getCustomer());
	}
	
	/**
	 * Private method to build an Account entity
	 * @param customerId
	 * @param initialCredit
	 * @return Account
	 */
	private Account buildAccountEntity(Integer customerId, Double initialCredit) {
		Account entity = new Account();
		entity.setCustomer(customerId);
		entity.setCredit(initialCredit);	
		return entity;
	}

	/**
	 * Method used find account list by customer id
	 * @param customerId
	 * @return List<AccountRTO>
	 */
	public List<AccountRTO> findAccountsByCustomerId(Integer customerId) {
		List<AccountRTO> result = accountRepository.findAccountRTObyIdCustomer(customerId);
		return result;
	}


	/**
	 * Method used to update account credit
	 * @param accountId, amountTransactions
	 * @return Double
	 */
	public Double updateCredit(Integer accountId, Double amountTransactions) {
		//Check if account exists
		Account account = accountRepository.findById(accountId).orElseThrow(() -> new AccountException(ErrorMessages.ACCOUNT_NOT_FOUND));		
		account.setCredit(account.getCredit() + amountTransactions); //Set new credit	
		accountRepository.saveAndFlush(account); //Update credit on DB with new value
		
		return account.getCredit();
	}
	

}
