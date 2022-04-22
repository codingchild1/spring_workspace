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
	public Account accountInfo(String id) throws Exception {
		Account acc = accountDAO.queryAccount(id);
		if(acc==null) throw new Exception("계좌 오류");
		return acc;
	}
	@Override
	public List<Account> allAccountInfo() throws Exception {
		return accountDAO.accountList();
	}

	@Override
	public Account makeAccount(Account acc) throws Exception {
		Account qacc = accountDAO.queryAccount(acc.getId());
		if(qacc!=null) throw new Exception("계좌 중복 오류");
		accountDAO.insertAccount(acc);
		return accountDAO.queryAccount(acc.getId());
	}
	@Override
	public boolean accOverlap(String id) throws Exception {
		Account acc = accountDAO.queryAccount(id);
		if(acc==null) return false;
		return true;
	}

	@Override
	public int deposit(String id, int money) throws Exception {
		Account acc = accountDAO.queryAccount(id);
		if(acc==null) throw new Exception("존재하지 않은 계좌입니다.");
		acc.deposit(money);
		accountDAO.updateAccount(acc);
		return accountDAO.queryAccount(id).getBalance();
	}

	@Override
	public int withdraw(String id, int money) throws Exception {
		Account acc = accountDAO.queryAccount(id);
		if(acc.getBalance()<money) {
			throw new Exception("잔액이 부족합니다.");
		}
		acc.withdraw(money);
		accountDAO.updateAccount(acc);
		return accountDAO.queryAccount(id).getBalance();
	}

	@Override
	public int transfer(String id1, String id2, int money, String bank, String password) throws Exception {
		Account acc = accountDAO.queryAccount(id1);
		Account acc2 = accountDAO.queryAccount(id2);
		int tax = 0;
		if(!bank.equals("멀캠")) {
			 tax= 500;
		}
		if(acc.getBalance()-tax<money) {
			throw new Exception("잔액이 부족합니다.");
		}
		if((acc2==null) || !bank.equals(acc2.getBank())) throw new Exception("존재하지 않은 계좌입니다.");
		if(!password.equals(acc.getPassword())) throw new Exception("비밀번호가 일치하지 않습니다.");
		if(!bank.equals("멀캠")) {
		acc.withdraw(money);
		acc.tax();
		acc2.deposit(money);
		accountDAO.updateAccount(acc);
		accountDAO.updateAccount(acc2);
		}else {
		acc.withdraw(money);
		acc2.deposit(money);
		accountDAO.updateAccount(acc);
		accountDAO.updateAccount(acc2);
		}

		return accountDAO.queryAccount(id1).getBalance();
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


