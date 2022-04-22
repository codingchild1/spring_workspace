package com.mulcam.tiles.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mulcam.tiles.dto.Member;
import com.mulcam.tiles.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/listMembers.do")
	public ModelAndView listMembers(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			List<Member> list = memberService.memberList();
			mv.addObject("membersList", list);
			mv.setViewName((String)request.getAttribute("viewName"));
			//mv.setViewName("/member/listMembers");
		} catch(Exception e) {
			mv.addObject("err", e.getMessage());
			mv.setViewName("err");
		}
		return mv;
	}
	
	@GetMapping("/loginForm.do")
	public String loginForm(@RequestParam(value="result", required=false) String result, Model model,
			HttpServletRequest request) {
		model.addAttribute("result", result);
		return (String)request.getAttribute("viewName");
		//return "/member/loginForm";
	}
	
	@PostMapping("/login.do")
	public ModelAndView login(@RequestParam(value="id") String id, @RequestParam(value="pwd") String pwd, 
			RedirectAttributes rAttr) {
		ModelAndView mv = new ModelAndView();
		Member mem = null;
		try {
			mem = memberService.login(id, pwd);
			if(mem!=null) {
				session.setAttribute("isLogOn", true);
				session.setAttribute("member", mem);
				mv.setViewName("redirect:/member/listMembers.do");
			} else throw new Exception();
		} catch(Exception e) {
			rAttr.addAttribute("result", "loginFailed");
			//mv.addObject("result", "loginFailed");
			mv.setViewName("redirect:/member/loginForm.do");
		}
		return mv;
	}

	@GetMapping("/logout.do")
	public String logout() {
		session.removeAttribute("isLogOn");
		session.removeAttribute("member");
		return "/member/loginForm";
	}
}
