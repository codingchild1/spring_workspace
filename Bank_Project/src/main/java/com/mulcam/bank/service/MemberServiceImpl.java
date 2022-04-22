package com.mulcam.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.bank.dao.MemberDAO;
import com.mulcam.bank.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO memberDAO;

	@Override
	public boolean memOverlap(String id) throws Exception {
		Member mem=memberDAO.queryMember(id);
		if(mem==null) return false;
		return true;
	}

	@Override
	public void makeMember(Member mem) throws Exception {
		memberDAO.insertMember(mem);
	}

	@Override
	public boolean accessMember(String id, String password) throws Exception {
		Member mem=memberDAO.queryMember(id);
		if(id.equals(mem.getId())&&password.equals(mem.getPassword())) {
			return true;
		} else if(id.equals(mem.getId())&&!password.equals(mem.getPassword())) {
			throw new Exception("로그인에 실패하였습니다.");
		} else return false;
	}
}
