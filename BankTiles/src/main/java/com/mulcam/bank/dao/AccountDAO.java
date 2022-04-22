package com.mulcam.bank.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.bank.dto.Account;

//마이바티스 mapper로 지정해주는 어노테이션 Mapper(일종의 상속구조)

//Repository 어노테이션을 통해 Bean 객체로 자동생성 시킨다.
//Bean 객체의 이름을 어노테이션에 지정하지 않을 경우 디폴트값으로 클래스(인터페이스)명을 소문자로 변환해서 생성
@Mapper
@Repository
public interface AccountDAO {
	public Account queryAccount(String id) throws Exception;
	public List<Account> accountList() throws Exception;
	public void insertAccount(Account acc) throws Exception;
	public void updateAccount(Account acc) throws Exception;
}
