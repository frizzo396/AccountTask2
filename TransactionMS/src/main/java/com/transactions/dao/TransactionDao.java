package com.transactions.dao;

import com.transactions.rto.TransactionRTO;

public interface TransactionDao {
	TransactionRTO sendStandardTransaction(Integer accountId);
}
