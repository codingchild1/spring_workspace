package com.mulcam.bank.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.bank.dao.AccountDAO;
import com.mulcam.bank.dto.Account;

//컨트롤러 처럼 Bean 객체 생성없이 웹 어플리케이션 실행 시 자동생성되는 클래스 어노테이션(Service)
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDAO accountDAO;
	
	@Override
	public Account accountInfo(String id) throws Exception {
		Account acc=accountDAO.queryAccount(id);
		if(acc==null) throw new Exception("계좌 오류");
		return acc;
	}

	@Override
	public Account makeAccount(Account acc) throws Exception {
//		Account qacc=accountDAO.queryAccount(acc.getId());
//		if(qacc!=null) throw new Exception("계좌 중복 오류");
		//마이바티스의 경우 PK에 없는 값을 조건으로 조회(select)하면 null을 반환한다.
		accountDAO.insertAccount(acc);
		return accountDAO.queryAccount(acc.getId());
	}

	@Override
	public int deposit(String id, int money) throws Exception {
		Account acc=accountDAO.queryAccount(id);
		acc.deposit(money);
		accountDAO.updateAccount(acc);
		return accountDAO.queryAccount(id).getBalance();
	}

	@Override
	public int withdraw(String id, int money) throws Exception {
		Account acc=accountDAO.queryAccount(id);
		acc.withdraw(money);
		accountDAO.updateAccount(acc);
		return accountDAO.queryAccount(id).getBalance();
	}


	@Override
	public List<Account> allAccountInfo() throws Exception {
		return accountDAO.accountList();
	}

	@Override
	public boolean accOverlap(String id) throws Exception {
		Account acc=accountDAO.queryAccount(id);
		if(acc==null) {
			return false;
		} return true;
	}
	
	@Override
	public String accountInfo_json() throws Exception {
		List<Account> accs=accountDAO.accountList();
		JSONObject totalObject=new JSONObject();
		JSONArray accountsArray=new JSONArray();
		for(Account acc:accs) {
			JSONObject accountInfo=new JSONObject();
			accountInfo.put("id", acc.getId());
			accountInfo.put("name", acc.getName());
			accountInfo.put("balance", acc.getBalance());
			accountInfo.put("type", acc.getType());
			accountInfo.put("grade", acc.getGrade());
			accountsArray.add(accountInfo);
		}
		totalObject.put("accounts", accountsArray);
		return totalObject.toJSONString();
	}
}
