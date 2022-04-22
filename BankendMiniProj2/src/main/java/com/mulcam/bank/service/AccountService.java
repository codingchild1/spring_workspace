package com.mulcam.bank.service;

import java.util.List;

import com.mulcam.bank.dto.Account;

public interface AccountService {
	Account accountInfo(String id) throws Exception;
	List<Account> allAccountInfo() throws Exception;
	Account makeAccount(Account acc) throws Exception;
	boolean accOverlap(String id) throws Exception;
//	String allAccountInfo_json() throws Exception;
	int deposit(String id, int money) throws Exception;
	int withdraw(String id, int money) throws Exception;
	boolean idOverlap(String id) throws Exception;
}
