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
	
	@GetMapping(value="/")
	public String bankmain(Model model) {
		model.addAttribute("cpage", "login");
		return "bankmain";
	}
	
	@GetMapping(value="/accmenu" )
	public String accmanu(@RequestParam(value="cpage", required=false) String cpage, Model model) {
		model.addAttribute("cpage", cpage);
		return "bankmain";
	
	}
	@PostMapping("/accinfo")
	public ModelAndView accinfo(@RequestParam(value="id", required=true) String id) {
		ModelAndView mav = new ModelAndView("bankmain");
		try {
		Account acc = accountService.accountInfo(id);
		mav.addObject("cpage","accinfo");
		mav.addObject("vtype","R");
		mav.addObject("acc",acc);
		}catch(Exception e) {
			mav.addObject("cpage","err");
			mav.addObject("err",e.getMessage());
		}
		return mav;
	}
	
	@GetMapping("/allaccountinfo")
	public ModelAndView allaccountinfo() {
		ModelAndView mav = new ModelAndView("bankmain");
		try {
			List<Account> accs = accountService.allAccountInfo();
			mav.addObject("accs", accs);
			mav.addObject("cpage", "allaccinfo");
		} catch(Exception e) {
			mav.addObject("err", e.getMessage());
			mav.addObject("cpage", "err");
		}
		return mav;
	}
	@PostMapping("/makeaccount")
	public ModelAndView makeaccount(@ModelAttribute Account acc) {
		ModelAndView mav = new ModelAndView("bankmain");
		try {
			Account qacc = accountService.makeAccount(acc);
			mav.addObject("acc", qacc);
			mav.addObject("cpage", "accinfo");
			mav.addObject("vtype", "R");
		} catch(Exception e) {
			mav.addObject("err", e.getMessage());
			mav.addObject("cpage", "err");
		}
		return mav;
	}
	
	@ResponseBody
	@PostMapping("/accoverlap")
	public String accoverlap(@RequestParam(value="id", required = true) String id) {
		boolean overlap = false;
		try {
			overlap = accountService.accOverlap(id);
		} catch(Exception e) {
		}
		return String.valueOf(overlap);
	}
	
	@PostMapping("/deposit")
	public ModelAndView deposit(@RequestParam(value="id", required = true) String id,
			@RequestParam(value="money", required = true) int money) {
		ModelAndView mav = new ModelAndView("bankmain");
		try {
			int balance = accountService.deposit(id, money);
			mav.addObject("cpage", "deposit");
			mav.addObject("balance", balance);
			mav.addObject("vtype", "R");
		} catch(Exception e) {
			mav.addObject("cpage", "err");
			mav.addObject("err", e.getMessage());
		}
		return mav;
	}
	
	@PostMapping("/withdraw")
	public ModelAndView withdraw(@RequestParam(value="id", required = true) String id,
			@RequestParam(value="money", required = true) int money) {
		ModelAndView mav = new ModelAndView("bankmain");
		try {
			int balance = accountService.withdraw(id, money);
			mav.addObject("cpage", "withdraw");
			mav.addObject("balance", balance);
			mav.addObject("vtype", "R");
		} catch(Exception e) {
			mav.addObject("cpage", "err");
			mav.addObject("err", e.getMessage());
		}
		return mav;
	}
	@ResponseBody
	@PostMapping("/allaccountinfo_json")
	public void allaccountinfo_json(HttpServletResponse response) {
		try {
			String jsonAccs=accountService.allAccountInfo_json();
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.write(jsonAccs);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
