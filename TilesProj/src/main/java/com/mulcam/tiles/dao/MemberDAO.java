package com.mulcam.tiles.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.tiles.dto.Member;

@Mapper
@Repository
public interface MemberDAO {
	Member queryMember(String id) throws Exception;
	void insertMember(Member mem) throws Exception;
	List<Member> queryMemberList() throws Exception;
}
