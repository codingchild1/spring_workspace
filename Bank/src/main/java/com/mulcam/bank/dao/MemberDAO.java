package com.mulcam.bank.dao;

import com.mulcam.bank.dto.Member;

public interface MemberDAO {
	public Member queryMember(String id) throws Exception;
	public void insertMember(Member mem) throws Exception;
}
