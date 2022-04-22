package com.mulcam.bank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mulcam.bank.dto.Member;
import com.mulcam.bank.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@Autowired
	HttpSession session;
	
	@PostMapping("/login")
	public String login(@RequestParam(value="id") String id, @RequestParam(value="password") String password,
			Model model) {
		try {
			memberService.login(id, password);
			session.setAttribute("id", id);
			model.addAttribute("cpage", "makeaccount");
		} catch(Exception e) {
			model.addAttribute("cpage", "err");
			model.addAttribute("err", e.getMessage());
		}
		return "bankmain";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute Member member, Model model) {
		try {
			memberService.join(member);
			model.addAttribute("cpage", "login");
		} catch(Exception e) {
			model.addAttribute("cpage", "err");
			model.addAttribute("err", e.getMessage());
		}
		return "bankmain";
	}
	
	@ResponseBody
	@PostMapping("/memberoverlap")
	public String memberOverlap(@RequestParam(value="id") String id) {
		boolean overlap = true;
		try {
			overlap = memberService.idOverlap(id);
		} catch(Exception e) {
		}
		return String.valueOf(overlap);
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("cpage", "login");
		session.removeAttribute("id");
		return "bankmain";
	}
}
