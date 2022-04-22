package com.mulcam.bank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		model.addAttribute("cpage", "bankmain2");
		return "bankmain";
	}

	
	@RequestMapping(value = "/accmenu", method = RequestMethod.GET)
	public String accmenu(HttpServletRequest request, Model model) {
		String cpage = request.getParameter("cpage");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id==null || id.equals("")) {
			cpage="login";
		}
		model.addAttribute("cpage", cpage);
		return "bankmain";
	}
	
//	@GetMapping(value="/accmenu" )
//	public String accmanu(@RequestParam(value="cpage", required=false) String cpage, Model model) {
//		model.addAttribute("cpage", cpage);
//		return "bankmain";
//
//	}
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
	public ModelAndView allaccountinfo(Model model,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("bankmain");
		HttpSession session =request.getSession();
		String name = (String) session.getAttribute("name");
		try {
			List<Account> accs = accountService.allAccountInfo();
			int cnt = accs.size();
			mav.addObject("accs", accs);
			model.addAttribute("name",name);
			model.addAttribute("count",cnt);
			mav.addObject("cpage", "allaccinfo");
			
		} catch(Exception e) {
			mav.addObject("err", e.getMessage());
			mav.addObject("cpage", "err");
		}
		return mav;
	}
	@PostMapping("/makeaccount")
	public ModelAndView makeaccount(@ModelAttribute Account acc,
			HttpServletRequest request
		) {
		ModelAndView mav = new ModelAndView("bankmain");
		HttpSession session =request.getSession();
		String name3 = (String) session.getAttribute("name");
		mav.addObject("name1",name3);
		try {
			Account qacc = accountService.makeAccount(acc);
			mav.addObject("acc", qacc);
			mav.addObject("cpage", "bankmain2");
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
			Account acc = accountService.accountInfo(id);
			int balance = accountService.deposit(id, money);
			mav.addObject("cpage", "deposit");
			mav.addObject("acc", acc);
			mav.addObject("deposit", money);
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
			Account acc = accountService.accountInfo(id);
			int balance = accountService.withdraw(id, money);
			mav.addObject("cpage", "withdraw");
			mav.addObject("acc", acc);
			mav.addObject("withdraw", money);
			mav.addObject("balance", balance);
			mav.addObject("vtype", "R");
		} catch(Exception e) {
			mav.addObject("cpage", "err");
			mav.addObject("err", e.getMessage());
		}
		return mav;
	}
//	@ResponseBody
//	@PostMapping("/allaccountinfo_json")
//	public void allaccountinfo_json(HttpServletResponse response) {
//		try {
//			String jsonAccs=accountService.allAccountInfo_json();
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out=response.getWriter();
//			out.write(jsonAccs);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	@GetMapping("/center")
	public ModelAndView center() {
		ModelAndView mav = new ModelAndView("bankmain");
		try {
		mav.addObject("cpage","center");
		}catch(Exception e) {
			mav.addObject("cpage","err");
			mav.addObject("err",e.getMessage());
		}
		return mav;
	}
	@GetMapping("/history")
	public ModelAndView history() {
		ModelAndView mav = new ModelAndView("bankmain");
		try {
		mav.addObject("cpage","history");
		}catch(Exception e) {
			mav.addObject("cpage","err");
			mav.addObject("err",e.getMessage());
		}
		return mav;
	}
	@PostMapping("/transfer")
	public ModelAndView transfer(@RequestParam(value="id1", required = true) String id1,
			@RequestParam(value="money", required = true) int money,
			@RequestParam(value="id2", required = true) String id2,
			@RequestParam(value="bank", required = true) String bank,
			@RequestParam(value="password", required = true) String password,
			HttpServletRequest request
			) {
		ModelAndView mav = new ModelAndView("bankmain");
		HttpSession session =request.getSession();
		String name = (String) session.getAttribute("name");
		try {
			Account acc = accountService.accountInfo(id1);
			Account acc2 = accountService.accountInfo(id2);
			int balance = accountService.transfer(id1,id2, money, bank, password);
			mav.addObject("cpage", "transfer");
			mav.addObject("acc", acc);
			mav.addObject("id1", id1);
			mav.addObject("name1", name);
			mav.addObject("money", money);
			mav.addObject("balance", balance);
			mav.addObject("bank", bank);
			mav.addObject("id2", id2);
			mav.addObject("name2", acc2.getName1());
			mav.addObject("vtype", "R");
			if(!bank.equals("멀캠")) {
			mav.addObject("tax", 500);
			}else {
			mav.addObject("tax", 0);
			}
		} catch(Exception e) {
			mav.addObject("cpage", "err");
			mav.addObject("err", e.getMessage());
		}
		return mav;
	}

}
