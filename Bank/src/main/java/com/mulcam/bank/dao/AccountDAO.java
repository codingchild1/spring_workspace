package com.mulcam.bank.dao;

import java.util.List;

import com.mulcam.bank.dto.Account;

public interface AccountDAO {
	public void insertAccount(Account acc) throws Exception;
	public List<Account> accountList() throws Exception;
	public Account queryAccount(String id) throws Exception;
	public void updateAccount(Account acc) throws Exception;
}

