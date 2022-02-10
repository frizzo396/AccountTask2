package com.accounts.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounts.client.AccountClient;
import com.accounts.dao.account.AccountDao;
import com.accounts.dao.customer.CustomerDao;
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
	
	/**
	 * Constants and attributes
	 */
	public static final Double CREDIT_ZERO = 0.0; 	
	private AccountDao accountDao;	
	private CustomerDao customerDao;	
	private AccountClient accountClient;
	

	/**
	 * Autowired constructor
	 */
	@Autowired
	public AccountServiceImpl(AccountDao accountDao, CustomerDao customerDao, AccountClient accountClient) {
	    this.accountDao = accountDao;
	    this.customerDao = customerDao;
	    this.accountClient = accountClient;
	}
	
	/**
	 * Method used to open a new account
	 * @param OpenAccountRequest
	 * @return ResponseEntity<AccountRTO>
	 */
	@Transactional
	public ResponseEntity<AccountRTO> openAccount(OpenAccountRequest request) {	
		
		//Input validation
		AccountMsInputValidator.validateInput(request);
		if(!customerDao.isValidCustomer(request.getCustomerId())) throw new AccountException(ErrorMessages.CUST_NOT_EXISTS);		
		
		//Creates new account
		AccountRTO accountRTO = accountDao.openAccount(request); 
		
		//If credit > 0 a call, between Account client, to  Transaction service wil send a standard transaction
		if(accountRTO.getCredit() > CREDIT_ZERO) {
			ResponseEntity<TransactionRTO> response = accountClient.sendStandardTransaction(new SendStdTransactionRequest(accountRTO.getAccountId()));
			
			//Add transaction to account and calculate new account credit
			if(!(response.getBody() == null)) {
				accountRTO.getTransactionsList().add(response.getBody());
				Double newCredit = accountDao.updateCredit(accountRTO.getAccountId(), response.getBody().getAmount());
				accountRTO.setCredit(newCredit);
			}		
		}		
		return new ResponseEntity<AccountRTO>(accountRTO, HttpStatus.OK);
	}

	
	/**
	 * Method used to retrieve user's informations
	 * @param customerId
	 * @return ResponseEntity<UserInfoRTO>
	 */
	@Transactional
	public ResponseEntity<UserInfoRTO> getUserInfo(Integer customerId) {
		
		//Check if customer exists
		if(!customerDao.isValidCustomer(customerId)) throw new AccountException(ErrorMessages.CUST_NOT_EXISTS);	
		
		//Retrieve customer
		CustomerRTO customerRTO = customerDao.findCustomerById(customerId);		
		
		//Retrieve customer's account list
		List<AccountRTO> accountList = accountDao.findAccountsByCustomerId(customerId); 	
		
		//Retrieve transactions list
		List<TransactionRTO> transactionsList = accountClient.getAllTransactions().getBody();
		
		//Build user info RTO
		UserInfoRTO response = buildUserInfoRTO(customerRTO, accountList, transactionsList);
	
		return new ResponseEntity<UserInfoRTO>(response, HttpStatus.OK);
	}

	
	/**
	 * Method used to build UserInfoRTO object
	 * @param customerRTO
	 * @param accountList
	 * @param transactionsList
	 * @return UserInfoRTO
	 */
	private UserInfoRTO buildUserInfoRTO(CustomerRTO customerRTO, List<AccountRTO> accountList, List<TransactionRTO> transactionsList) {
		UserInfoRTO userInfoRTO = new UserInfoRTO();
		
		//Set name and surname
		userInfoRTO.setName(customerRTO.getFirstName());
		userInfoRTO.setSurname(customerRTO.getLastName());
		
		//Iterate customer's account list and, for each account, retrieve transactions and calculate total balance
		for(AccountRTO aRto: accountList) {
			List<TransactionRTO> subList = transactionsList.stream().filter(a -> a.getAccountId().equals(aRto.getAccountId())).collect(Collectors.toList());
			aRto.setTransactionsList(subList);
			userInfoRTO.setTotalBalance(userInfoRTO.getTotalBalance()+ aRto.getCredit());
		}	
		userInfoRTO.setAccounts(accountList);
				
		return userInfoRTO;
	}
	
}
