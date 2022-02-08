package com.transactions.dao;

import com.common.rto.TransactionRTO;

public interface TransactionDao {
	TransactionRTO sendStandardTransaction(Integer accountId);
}
