package com.mulcam.bank.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.bank.dto.Account;

@Mapper
@Repository
public interface AccountDAO {
	public Account queryAccount(String id) throws Exception;
	public void insertAccount(Account acc) throws Exception;
	public List<Account> accountList() throws Exception;
	public void updateAccount(Account acc) throws Exception;
}


