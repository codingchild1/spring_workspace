package com.mulcam.bank.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.bank.dao.AccountDAO;
import com.mulcam.bank.dto.Account;

@Service
public class AccountServiceImpl implements AccountService {
	
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
			throw new Exception("잔액이 부족합니다");
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
		// TODO Auto-generated method stub
		return accountDAO.accountList();
	}

	@Override
	public boolean accOverlap(String id) throws Exception {
		Account acc = accountDAO.queryAccount(id);
		if(acc==null) return false;
		return true;
	}

	@Override
	public String allAccountInfo_json() throws Exception {
		List<Account> accs = accountDAO.accountList();
		JSONObject totalObject = new JSONObject();
		JSONArray accArray = new JSONArray();			
		for(Account acc: accs) {
			JSONObject accObject = new JSONObject();
			accObject.put("id", acc.getId());
			accObject.put("name", acc.getName());
			accObject.put("balance", acc.getBalance());
			accObject.put("type", acc.getType());				
			accObject.put("grade", acc.getGrade());
			accArray.add(accObject);
		}
		
		totalObject.put("accs", accArray);
		return totalObject.toJSONString();
	}
	
}
