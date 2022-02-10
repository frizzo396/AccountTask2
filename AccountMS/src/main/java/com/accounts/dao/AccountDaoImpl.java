package com.accounts.dao;

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
	
	
	public AccountRTO openAccount(OpenAccountRequest request) {
		
		Account entity = buildAccountEntity(request.getCustomerId(), request.getInitialCredit());		
		Account response = Optional.of(accountRepository.saveAndFlush(entity))
								   .orElseThrow(() -> new AccountException(ErrorMessages.SAVE_ERROR));
		
		return new AccountRTO(response.getAccountId(), response.getCredit(), response.getCustomer());
	}
	
	
	private Account buildAccountEntity(Integer customerId, Double initialCredit) {
		Account entity = new Account();
		entity.setCustomer(customerId);
		entity.setCredit(initialCredit);	
		return entity;
	}


	public List<AccountRTO> findAccountsByCustomerId(Integer customerId) {
		List<AccountRTO> result = accountRepository.findAccountRTObyIdCustomer(customerId);
		return result;
	}


	
	public Double updateCredit(Integer accountId, Double amountTransactions) {
		Account account = accountRepository.findById(accountId).orElseThrow(() -> new AccountException("Account not found"));		
		account.setCredit(account.getCredit() + amountTransactions);	
		accountRepository.saveAndFlush(account);
		
		return account.getCredit();
	}
	

}
