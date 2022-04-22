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
	public boolean login(String id, String password) throws Exception {
		try {
			Member mem = memberDAO.queryMember(id);
			if(mem == null) throw new Exception();
			if(password.equals(mem.getPassword())) {
				return true;
			}
		} catch(Exception e) {
			throw new Exception("계좌번호 오류");
		}
		return false;
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
}
