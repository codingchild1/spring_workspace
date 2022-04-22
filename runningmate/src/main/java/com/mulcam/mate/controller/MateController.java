package com.mulcam.mate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mulcam.mate.service.MateService;

@Controller
public class MateController {
	
	@Autowired
	MateService mateService;
	
	//메인페이지 이동
	@GetMapping("/mate_main")
	public String main() {
		return "mate_main";
	}
	
	//번개글작성페이지 이동
	@PostMapping("/mate_makemate")
	public String makemate() {
		return "mate_makemate";
	}
	
	//소모임글작성페이지 이동
	@PostMapping("/mate_makegroup")
	public String makegroup() {
		return "mate_makegroup";
	}
	
	//지도로보기페이지 이동
	@PostMapping("/mate_map")
	public String map() {
		return "mate_map";
	}
	
	//검색으로보기페이지 이동
	@PostMapping("/mate_search")
	public String search() {
		return "mate_search";
	}
	
	//게시물 더보기 ajax
	@PostMapping("/postInfo")
	public String postInfo() {
		return "postInfo";
	}
	//게시물 삭제요청 ajax
	@PostMapping("/deletepost")
	public String deletepost() {
		return "deletepost";
	}
	
	//게시물 신고 ajax
	@PostMapping("/report")
	public String report() {
		return "report";
	}
	
	//번개 참여자 조회 요청 ajax
	@PostMapping("/mateptpInfo")
	public String mateptpInfo() {
		return "mateptpInfo";
	}
	
	//번개 참여자 참여 요청 ajax
	@PostMapping("/matelike")
	public String matelike() {
		return "matelike";
	}
	
	//모임종류,지역,키워드 기반 검색 요청 ajax
	@PostMapping("/postsearch")
	public String postsearch() {
		return "postsearch";
	}
	
	//번개 게시물 ajax
	@PostMapping("/matepost")
	public String matepost() {
		return "matepost";
	}
	
	//소모임 게시물 ajax
	@PostMapping("/grouppost")
	public String grouppost() {
		return "grouppost";
	}
	
		
	
	
}
