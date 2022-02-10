package com.accounts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.common.entities.Account;
import com.common.rto.AccountRTO;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	@Query("SELECT " +
		   "new com.common.rto.AccountRTO(a.accountId, a.credit, a.customerId) " +
		   "FROM Account a " +
		   "WHERE a.customerId = :customerId")
	List<AccountRTO> findAccountsByCustomerId(@Param("customerId") Integer customerId);

}
