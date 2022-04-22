package com.mulcam.bank;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.bank.dto.Account;
import com.mulcam.bank.service.AccountServiceImpl;

@Controller
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	@Autowired
	AccountServiceImpl accountService;

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
	
	@RequestMapping(value="/allaccountinfo", method=RequestMethod.GET)
	public ModelAndView allaccountinfo() {
		ModelAndView modelAndView = new ModelAndView("bankmain");
		try {
			List<Account> accs = accountService.allAccountInfo();
			modelAndView.addObject("accs", accs);
			modelAndView.addObject("cpage", "allaccinfo");
		} catch(Exception e) {
			modelAndView.addObject("err", e.getMessage());
			modelAndView.addObject("cpage", "err");
		}
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="allaccountinfo_json", method=RequestMethod.POST) 
	public void allaccountinfo_json(HttpServletResponse response) {
		try {
			String jsonAccs = accountService.allAccountInfo_json();
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			logger.info(jsonAccs);
			out.write(jsonAccs);			
		} catch(Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	@RequestMapping(value="/accinfo", method=RequestMethod.POST)
	public ModelAndView accinfo(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("bankmain");
		try {
			String id = request.getParameter("id");
			Account acc = accountService.accountInfo(id);
			modelAndView.addObject("acc", acc);
			modelAndView.addObject("cpage", "accinfo");
			modelAndView.addObject("vtype", "R");
		} catch(Exception e) {
			modelAndView.addObject("err", e.getMessage());
			modelAndView.addObject("cpage", "err");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/makeaccount", method=RequestMethod.POST)
	public ModelAndView makeaccount(@ModelAttribute Account acc) {
		ModelAndView modelAndView = new ModelAndView("bankmain");
		try {
			Account racc = accountService.makeAccount(acc);
			modelAndView.addObject("acc", racc);
			modelAndView.addObject("cpage", "accinfo");
			modelAndView.addObject("vtype", "R");
		} catch(Exception e) {
			modelAndView.addObject("err", e.getMessage());
			modelAndView.addObject("cpage", "err");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.POST)
	public ModelAndView deposit(@RequestParam(value="id", required = true) String id,
			@RequestParam(value="money", required = true) int money) {
		ModelAndView modelAndView = new ModelAndView("bankmain");
		try {
			int balance = accountService.deposit(id, money);
			modelAndView.addObject("cpage", "deposit");
			modelAndView.addObject("balance", balance);
			modelAndView.addObject("vtype", "R");
		} catch(Exception e) {
			modelAndView.addObject("cpage", "err");
			modelAndView.addObject("err", e.getMessage());
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/withdraw", method=RequestMethod.POST)
	public ModelAndView withdraw(@RequestParam(value="id", required = true) String id,
			@RequestParam(value="money", required = true) int money) {
		ModelAndView modelAndView = new ModelAndView("bankmain");
		try {
			int balance = accountService.withdraw(id, money);
			modelAndView.addObject("cpage", "withdraw");
			modelAndView.addObject("balance", balance);
			modelAndView.addObject("vtype", "R");
		} catch(Exception e) {
			modelAndView.addObject("cpage", "err");
			modelAndView.addObject("err", e.getMessage());
		}
		return modelAndView;
	}	
	
	@ResponseBody
	@RequestMapping(value="accoverlap", method=RequestMethod.POST)
//	value는 makeaccount.jsp의 url과 같아야함
	public String accoverlap(@RequestParam(value="id", required = true) String id) {
		boolean overlap = false;
		try {
			overlap = accountService.accOverlap(id);
		} catch(Exception e) {
		}
		return String.valueOf(overlap);
	}
	
}
