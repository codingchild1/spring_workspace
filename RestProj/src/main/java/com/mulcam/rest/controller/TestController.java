package com.mulcam.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/*")
public class TestController {
	@RequestMapping("/hello")
	public String hello() {
		return "Hello Rest!!";
	}
	@RequestMapping("/member")
	public Member member() {
		Member mem = new Member();
		mem.setId("hong");
		mem.setPwd("1234");
		mem.setName("홍길동");
		mem.setEmail("hong@test.com");
		return mem;
	}
	@RequestMapping("/memberList")
	public List<Member> listMember(){
		List<Member> mems = new ArrayList<Member>();
		for(int i=0;i<10;i++) {
			Member m = new Member();
			m.setId("hong"+i);
			m.setPwd("123"+i);
			m.setName("홍길동"+i);
			m.setEmail("hong"+i+"@.test.com");
			mems.add(m);
		}
		return mems;
	}
	@RequestMapping("/memberList2")
	public ResponseEntity<List<Member>> listMember2(){
		List<Member> mems = new ArrayList<Member>();
		for(int i=0;i<10;i++) {
			Member m = new Member();
			m.setId("hong"+i);
			m.setPwd("123"+i);
			m.setName("홍길동"+i);
			m.setEmail("hong"+i+"@.test.com");
			mems.add(m);
		}
		return new ResponseEntity<List<Member>>(mems, HttpStatus.OK);
	}
	@RequestMapping("/memberMap")
	public Map<Integer, Member> memberMap(){
		Map<Integer, Member> map = new HashMap<Integer, Member>();
		for(int i=0;i<10;i++) {
			Member m = new Member();
			m.setId("hong"+i);
			m.setPwd("123"+i);
			m.setName("홍길동"+i);
			m.setEmail("hong"+i+"@test.com");
			map.put(i,m);
		}
		return map;
	}
	@RequestMapping("/memberMap2")
	public ResponseEntity<Map<Integer, Member>> memberMap2(){
		Map<Integer, Member> map = new HashMap<Integer, Member>();
		for(int i=0;i<10;i++) {
			Member m = new Member();
			m.setId("hong"+i);
			m.setPwd("123"+i);
			m.setName("홍길동"+i);
			m.setEmail("hong"+i+"@test.com");
			map.put(i,m);
		}
		return new ResponseEntity<Map<Integer, Member>>(map, HttpStatus.CREATED);
	}
}

