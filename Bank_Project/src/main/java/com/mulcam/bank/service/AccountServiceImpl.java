package com.mulcam.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.bank.dao.AccountDAO;
import com.mulcam.bank.dto.Account;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDAO accountDAO;

	@Override
	public Account makeAccount(Account acc) throws Exception {
		accountDAO.insertAccount(acc);
		return accountDAO.queryAccount(acc.getId());
	}

	@Override
	public int deposit(String id, int money) throws Exception {
		Account acc = accountDAO.queryAccount(id);
		acc.deposit(money);
		accountDAO.updateAccount(acc);
		return accountDAO.queryAccount(id).getBalance();
	}

	@Override
	public int withdraw(String id, int money) throws Exception {
		Account acc = accountDAO.queryAccount(id);
		if(acc.getBalance()<money) {
			throw new Exception("ÀÜ¾×ºÎÁ·");
		}
		acc.withdraw(money);
		accountDAO.updateAccount(acc);
		return accountDAO.queryAccount(id).getBalance();
	}

	@Override
	public Account accountInfo(String id) throws Exception {
		return accountDAO.queryAccount(id);
	}


	@Override
	public List<Account> allAccountInfo() throws Exception {
		return accountDAO.accountList();
	}

	@Override
	public boolean accOverlap(String id) throws Exception {
		Account acc = accountDAO.queryAccount(id);
		if(acc==null) return false;
		return true;
	}
}

