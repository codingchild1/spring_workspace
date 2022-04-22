package com.mulcam.bank.service;

import com.mulcam.bank.dto.Member;

public interface MemberService {
	boolean login(String id, String password) throws Exception;
	void join(Member member) throws Exception;
	boolean idOverlap(String id) throws Exception;
}
