package com.transactions.dao;

import java.util.List;
import com.common.rto.TransactionRTO;

public interface TransactionDao {
	TransactionRTO sendStandardTransaction(Integer accountId);
	List<TransactionRTO> findAllTransactions();
}
