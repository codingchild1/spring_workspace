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
		ModelAndView modelAndView=new ModelAndView("bankmain");
		try {
			String id=info.get("id");
			String password=info.get("password");
			if(memberService.accessMember(id, password)) {
				Member mem = memberService.memberInfo(id);
				session.setAttribute("name", mem.getName());
				session.setAttribute("id", id);
				modelAndView.addObject("cpage", "bankmain2");
			} else throw new Exception();
		} catch(EmptyResultDataAccessException e) {
			modelAndView.addObject("err", "로그인에 실패하였습니다.");
			modelAndView.addObject("cpage", "err");
		} catch(Exception e){
			modelAndView.addObject("err", e.getMessage());
			modelAndView.addObject("cpage", "err");
		}
		return modelAndView;
	}
	

	@GetMapping("/memmenu")
	public String memMenu(HttpServletRequest request, Model model) {
		String cpage=request.getParameter("cpage");
		model.addAttribute("cpage", cpage);
		return "bankmain";
	}


	@GetMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		model.addAttribute("cpage","login");
		return "bankmain";

	}
	@PostMapping("/join")
	public ModelAndView join(@ModelAttribute Member mem) {
		ModelAndView modelAndView=new ModelAndView("bankmain");
		try {
			memberService.makeMember(mem);
			modelAndView.addObject("cpage", "login");
		} catch(Exception e) {
			modelAndView.addObject("err", e.getMessage());
			modelAndView.addObject("cpage", "err");
		}
		return modelAndView;
	}

	@ResponseBody
	@PostMapping("/memidoverlap")
	public String memidoverlap(@RequestParam(value="id", required=true)String id) {
//		required=true면 무조건 값이 있어야됨 없으면 예외처리됨. false면 값이없어도 예외처리 안함
		boolean overlap=false;
		try {
			overlap=memberService.memOverlap(id);
		} catch(Exception e) {
		}
		return String.valueOf(overlap);
	}

}
