package com.mulcam.tiles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.tiles.dao.MemberDAO;
import com.mulcam.tiles.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public Member login(String id, String password) throws Exception {
		Member mem = null;
		try {
			 mem = memberDAO.queryMember(id);
			 if(!password.equals(mem.getPassword()))
				 mem = null;
		} catch(Exception e) {}
		return mem;
	}

	@Override
	public void join(Member member) throws Exception {
		memberDAO.insertMember(member);
	}

	@Override
	public boolean idOverlap(String id) throws Exception {
		Member mem = memberDAO.queryMember(id);
		if(mem != null) return true;
		return false;
	}

	@Override
	public List<Member> memberList() throws Exception {
		return memberDAO.queryMemberList();
	}
}
