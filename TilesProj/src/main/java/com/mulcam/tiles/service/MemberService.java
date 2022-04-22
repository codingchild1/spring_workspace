package com.mulcam.tiles.service;

import java.util.List;

import com.mulcam.tiles.dto.Member;

public interface MemberService {
	Member login(String id, String password) throws Exception;
	void join(Member member) throws Exception;
	boolean idOverlap(String id) throws Exception;
	List<Member> memberList() throws Exception;
}
