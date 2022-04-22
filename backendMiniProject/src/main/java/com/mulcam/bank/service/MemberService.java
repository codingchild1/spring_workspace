package com.mulcam.bank.service;

import com.mulcam.bank.dto.Member;

public interface MemberService {
	boolean memOverlap(String id) throws Exception;
	void makeMember(Member mem) throws Exception;
	boolean accessMember(String id, String password) throws Exception;
	Member memberInfo(String id) throws Exception;
}
