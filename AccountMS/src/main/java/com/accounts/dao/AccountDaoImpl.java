package com.accounts.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accounts.entities.Account;
import com.accounts.exception.AccountException;
import com.accounts.repository.AccountRepository;
import com.accounts.request.OpenAccountRequest;
import com.accounts.rto.AccountRTO;

@Repository
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	AccountRepository accountRepository;
	
	
	public AccountRTO openAccount(OpenAccountRequest request) {
		
		Account entity = accountRepository.saveAndFlush(buildAccountEntity(request.getCustomerId(), 
																		   request.getInitialCredit()));
		
		return new AccountRTO(entity.getAccountId(), entity.getCredit(), entity.getCustomer());
	}
	
	
	private Account buildAccountEntity(Integer customerId, Double initialCredit) {
		Account entity = new Account();
		entity.setCustomer(customerId);
		entity.setCredit(initialCredit);	
		return entity;
	}
	

}
