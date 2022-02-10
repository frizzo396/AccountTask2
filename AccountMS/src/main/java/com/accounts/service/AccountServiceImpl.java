package com.accounts.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounts.client.AccountClient;
import com.accounts.dao.AccountDao;
import com.accounts.dao.CustomerDao;
import com.accounts.exception.AccountException;
import com.accounts.utility.AccountMsInputValidator;
import com.common.entities.Transaction;
import com.common.messages.ErrorMessages;
import com.common.request.OpenAccountRequest;
import com.common.request.SendStdTransactionRequest;
import com.common.rto.AccountRTO;
import com.common.rto.CustomerRTO;
import com.common.rto.TransactionRTO;
import com.common.rto.UserInfoRTO;

@Service
public class AccountServiceImpl implements AccountService {
	
	public static final Double CREDIT_ZERO = 0.0; 	
	private AccountDao accountDao;	
	private CustomerDao customerDao;	
	private AccountClient accountClient;
	
	@Autowired
	public AccountServiceImpl(AccountDao accountDao, CustomerDao customerDao, AccountClient accountClient) {
	    this.accountDao = accountDao;
	    this.customerDao = customerDao;
	    this.accountClient = accountClient;
	}
	
	@Transactional
	public ResponseEntity<AccountRTO> openAccount(OpenAccountRequest request) {	
		AccountMsInputValidator.validateInput(request);
		if(!customerDao.isValidCustomer(request.getCustomerId())) throw new AccountException(ErrorMessages.CUST_NOT_EXISTS);		
		
		AccountRTO accountRTO = accountDao.openAccount(request);
		
		if(accountRTO.getCredit() > CREDIT_ZERO) {
			ResponseEntity<TransactionRTO> response = accountClient.sendStandardTransaction(new SendStdTransactionRequest(accountRTO.getAccountId()));
			
			if(!(response.getBody() == null)) {
				accountRTO.getTransactionsList().add(response.getBody());
				Double newCredit = accountDao.updateCredit(accountRTO.getAccountId(), response.getBody().getAmount());
				accountRTO.setCredit(newCredit);
			}		
		}		
		return new ResponseEntity<AccountRTO>(accountRTO, HttpStatus.OK);
	}

	
	@Transactional
	public ResponseEntity<UserInfoRTO> getUserInfo(Integer customerId) {
		if(!customerDao.isValidCustomer(customerId)) throw new AccountException(ErrorMessages.CUST_NOT_EXISTS);	
		
		CustomerRTO customerRTO = customerDao.findCustomerById(customerId);		
		List<AccountRTO> accountList = accountDao.findAccountsByCustomerId(customerId); 	
		List<TransactionRTO> transactionsList = accountClient.getAllTransactions().getBody();
		
		UserInfoRTO response = buildUserInfoRTO(customerRTO, accountList, transactionsList);
	
		return new ResponseEntity<UserInfoRTO>(response, HttpStatus.OK);
	}

	
	private UserInfoRTO buildUserInfoRTO(CustomerRTO customerRTO, List<AccountRTO> accountList, List<TransactionRTO> transactionsList) {
		UserInfoRTO userInfoRTO = new UserInfoRTO();
		userInfoRTO.setName(customerRTO.getFirstName());
		userInfoRTO.setSurname(customerRTO.getLastName());
		
		for(AccountRTO aRto: accountList) {
			List<TransactionRTO> subList = transactionsList.stream().filter(a -> a.getAccountId().equals(aRto.getAccountId())).collect(Collectors.toList());
			aRto.setTransactionsList(subList);
			userInfoRTO.setTotalBalance(userInfoRTO.getTotalBalance()+ aRto.getCredit());
		}	
		userInfoRTO.setAccounts(accountList);
				
		return userInfoRTO;
	}
	
}
