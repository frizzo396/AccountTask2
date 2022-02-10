package com.transactions.dao;

import java.util.List;
import com.common.rto.TransactionRTO;

public interface TransactionDao {
	
	/**
	 * Method to send a standard transaction after account opening
	 * @param accountId
	 * @return TransactionRTO
	 */
	TransactionRTO sendStandardTransaction(Integer accountId);
	
	/**
	 * Method for retrieve all transactions
	 * @return List<TransactionRTO>
	 */
	List<TransactionRTO> findAllTransactions();
}
