package com.mulcam.bank.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.bank.dto.Member;

@Mapper
@Repository
public interface MemberDAO {
	public Member queryMember(String id) throws Exception;
	public void insertMember(Member mem) throws Exception;
}
