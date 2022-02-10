package com.common.rto;

import java.util.List;

public class UserInfoRTO {
		
	private String name;
	
	private String surname;
	
	private Double totalBalance = new Double(0.0);
	
	private List<AccountRTO> accounts;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(Double totalBalance) {
		this.totalBalance = totalBalance;
	}

	public List<AccountRTO> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountRTO> accounts) {
		this.accounts = accounts;
	}
}
