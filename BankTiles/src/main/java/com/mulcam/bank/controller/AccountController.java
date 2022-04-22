package com.mulcam.bank.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.bank.dto.Account;
import com.mulcam.bank.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@GetMapping(value="/accmenu")
	public String accmenu(@RequestParam(value="cpage", required=false) String cpage, Model model) {
		model.addAttribute("cpage", cpage);
		return "/"+cpage+"Form";
	}
	
	@PostMapping(value="/accinfo")
	public ModelAndView accinfo(@RequestParam(value="id", required=false) String id) {
		ModelAndView mav=new ModelAndView();
		try {
			Account acc=accountService.accountInfo(id);
			mav.addObject("acc", acc);
			mav.addObject("cpage", "accinfo");
			mav.addObject("vtype", "R");
			mav.setViewName("/accinfoForm");
		} catch(Exception e) {
			mav.addObject("err", e.getMessage());
			mav.setViewName("/err");
		}
		return mav;
	}
	
	@GetMapping(value="/allaccountinfo")
	public ModelAndView allaccinfo() {
		ModelAndView mav=new ModelAndView();
		try {
			List<Account> accs=accountService.allAccountInfo();
			mav.addObject("accs", accs);
			mav.addObject("cpage", "allaccinfo");
			mav.setViewName("/allaccinfoForm");
		} catch(Exception e) {
			mav.addObject("err", e.getMessage());
			mav.setViewName("/err");
		}
		return mav;
	}
	
	@PostMapping(value="/makeaccount")
	public ModelAndView makeaccount(@ModelAttribute Account acc) {
		ModelAndView mav=new ModelAndView();
		try {
			Account acc2=accountService.makeAccount(acc);
			mav.addObject("acc", acc2);
			mav.addObject("cpage", "accinfo");
			mav.addObject("vtype", "R");
			mav.setViewName("/makeaccountForm");
		} catch(Exception e) {
			mav.addObject("err", e.getMessage());
			mav.setViewName("/err");
		}
		return mav;
	}
	
	@PostMapping(value="/deposit")
	public ModelAndView deposit(@RequestParam(value="id", required=true)String id,
			@RequestParam(value="money", required=true)int money) {
		ModelAndView mav=new ModelAndView("bankmain");
		try {
			int balance=accountService.deposit(id, money);
			mav.addObject("balance", balance);
			mav.addObject("cpage", "deposit");
			mav.addObject("vtype", "R");
			mav.setViewName("/depositForm");
		} catch(Exception e) {
			mav.addObject("err", e.getMessage());
			mav.setViewName("/err");
		}
		return mav;
	}
	
	@PostMapping(value="/withdraw")
	public ModelAndView withdraw(@RequestParam(value="id", required=true)String id,
			@RequestParam(value="money", required=true)int money) {
		//RequestParam 어노테이션으로 데이터를 받아서 매개변수로 넘기면 데이터 타입을 내부적으로 캐스팅할 수 있다.
		ModelAndView mav=new ModelAndView("bankmain");
		try {
			int balance=accountService.withdraw(id, money);
			mav.addObject("balance", balance);
			mav.addObject("cpage", "withdraw");
			mav.addObject("vtype", "R");
			mav.setViewName("/withdrawForm");
		} catch(Exception e) {
			mav.addObject("err", e.getMessage());
			mav.setViewName("/err");
		}
		return mav;
	}
	
	@ResponseBody
	@PostMapping(value="/accountoverlap")
	public String accountOverlap(@RequestParam(value="id", required=true)String id) {
		boolean overlap=false;
		try {
			overlap=accountService.accOverlap(id);
		} catch(Exception e) {
		}
		return String.valueOf(overlap);
	}
	
	@ResponseBody
	@PostMapping(value="/allaccountinfo_json")
	public void allaccountinfo_json(HttpServletResponse response) {
		try {
			String jsonAccs=accountService.accountInfo_json();
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.write(jsonAccs);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}	
