package com.accounts.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.common.entities.Account;
import com.common.rto.AccountRTO;


public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	/**
	 * Method which returns an AccountRTO list with Account entities informations finded by customerId
	 * @param customerId
	 * @return List<AccountRTO>
	 */
	@Query("SELECT " +
		   "new com.common.rto.AccountRTO(a.accountId, a.credit, a.customer) " +
		   "FROM Account a " +
		   "WHERE a.customer = :customerId")
	List<AccountRTO> findAccountRTObyIdCustomer(@Param("customerId") Integer customerId);

}
