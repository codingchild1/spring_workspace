package com.mulcam.bank;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.bank.dto.Account;
import com.mulcam.bank.dto.Member;
import com.mulcam.bank.service.MemberServiceImpl;

@Controller
public class MemberController {
	@Autowired
	MemberServiceImpl memberService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView("bankmain");
		try {
			String id=request.getParameter("id");
			String password=request.getParameter("password");
			if(memberService.accessMember(id, password)) {
				HttpSession session=request.getSession();
				session.setAttribute("id", id);
				modelAndView.addObject("cpage", "makeaccount");
			} else throw new Exception();
		} catch (EmptyResultDataAccessException e) {
			modelAndView.addObject("err", "로그인에 실패했습니다.");
			modelAndView.addObject("cpage", "err");
		} catch(Exception e){
			modelAndView.addObject("err", e.getMessage());
			modelAndView.addObject("cpage", "err");
		}
		return modelAndView;
	}

	
	
	@RequestMapping(value = "/memmenu", method = RequestMethod.GET)
	public String memmemu(HttpServletRequest request, Model model) {
		String capge = request.getParameter("cpage");
		model.addAttribute("cpage",capge);
		return "bankmain";
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		model.addAttribute("cpage","login");
		return "bankmain";
		
	}
	@RequestMapping(value="/join", method=RequestMethod.POST)
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
	@RequestMapping(value="/memberoverlap", method=RequestMethod.POST)
	public String memberOverlap(@RequestParam(value="id", required=true)String id) {
		boolean overlap=false;
		try {
			overlap=memberService.memOverlap(id);
		} catch(Exception e) {
		}
		return String.valueOf(overlap);
	}

}
