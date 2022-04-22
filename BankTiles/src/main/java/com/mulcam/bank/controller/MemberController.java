package com.mulcam.bank.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.bank.dto.Member;
import com.mulcam.bank.service.MemberServiceImpl;

@Controller
public class MemberController {
	@Autowired
	MemberServiceImpl memberService;
	
	@Autowired
	HttpSession session;
	
	@PostMapping(value="/login")
	public ModelAndView login(@RequestParam Map<String,String> info) {
		ModelAndView modelAndView=new ModelAndView();
		try {
			String id=info.get("id");
			String password=info.get("password");
			if(memberService.accessMember(id, password)) {
				session.setAttribute("id", id);
				modelAndView.addObject("cpage", "makeaccount");
				modelAndView.setViewName("/makeaccountForm");
			} else throw new Exception();
		} catch(EmptyResultDataAccessException e) {
			modelAndView.addObject("err", "아이디가 존재하지 않습니다");
			modelAndView.setViewName("/err");
		} catch(Exception e){
			modelAndView.addObject("err", e.getMessage());
			modelAndView.setViewName("/err");
		}
		return modelAndView;
	}
	
	@GetMapping(value="/memmenu")
	public String memMenu(HttpServletRequest request, Model model) {
		String cpage=request.getParameter("cpage");
		model.addAttribute("cpage", cpage);
		return "/"+cpage+"Form";
	}
	
	@GetMapping(value="/logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session=request.getSession();
		session.removeAttribute("id");
		model.addAttribute("cpage", "login");
		return "main";
	}
	
	@PostMapping(value="/join")
	public ModelAndView join(@ModelAttribute Member mem) {
		ModelAndView modelAndView=new ModelAndView();
		try {
			memberService.makeMember(mem);
			modelAndView.addObject("cpage", "login");
			modelAndView.setViewName("main");
		} catch(Exception e) {
			modelAndView.addObject("err", e.getMessage());
			modelAndView.setViewName("/err");
		}
		return modelAndView;
	}

	@ResponseBody
	@PostMapping(value="/memberoverlap")
	public String memberOverlap(@RequestParam(value="id", required=true)String id) {
		boolean overlap=false;
		try {
			overlap=memberService.memOverlap(id);
		} catch(Exception e) {
		}
		return String.valueOf(overlap);
	}
}
