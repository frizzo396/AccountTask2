package com.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.common.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
