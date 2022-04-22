package com.mulcam.bank;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.bank.dao.AccountDAO;
import com.mulcam.bank.dto.Account;
import com.mulcam.bank.service.AccountServiceImpl;

@Controller
public class AccountController {
	@Autowired
	AccountServiceImpl accountService;
	
//	public void setAccountDAO(AccountDAO accountDAO) {
//		this.accountDAO = accountDAO;
//	}

	@RequestMapping(value = "/accmenu", method = RequestMethod.GET)
		public String accmenu(HttpServletRequest request, Model model) {
		String cpage=request.getParameter("cpage");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id==null || id.equals("")) {
			cpage="login";
		}
			model.addAttribute("cpage",cpage);
			return "bankmain";
		}
	
	@RequestMapping(value = "/allaccountinfo", method = RequestMethod.GET)
	public ModelAndView allaccountinfo() {
		ModelAndView modelAndView = new ModelAndView("bankmain");
		try {
			List<Account> accs = accountService.allAccountInfo();
			modelAndView.addObject("accs",accs);
			modelAndView.addObject("cpage","allaccinfo");
		}catch(Exception e) {
			modelAndView.addObject("err",e.getMessage());
			modelAndView.addObject("cpage","err");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/accinfo", method = RequestMethod.POST)
	public ModelAndView accinfo(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("bankmain");
		try {
			String id = request.getParameter("id");
			Account acc = accountService.accountInfo(id);
			modelAndView.addObject("acc",acc);
			modelAndView.addObject("cpage","accinfo");
			modelAndView.addObject("vtype","R");
		}catch(Exception e){
			modelAndView.addObject("err", e.getMessage());
			modelAndView.addObject("cpage","err");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/makeaccount", method = RequestMethod.POST)
	public ModelAndView makeaccount(@ModelAttribute Account acc) {
		ModelAndView modelAndView = new ModelAndView("bankmain");
		try{
//			String id = request.getParameter("id");
//			String name = request.getParameter("name");
//			int balance = Integer.parseInt(request.getParameter("balance"));
//			String type = request.getParameter("type");
//			String grade = request.getParameter("grade");
//			Account acc = new Account(id,name,balance,type,grade);
			Account racc = accountService.makeAccount(acc);
			modelAndView.addObject("acc",racc);
			modelAndView.addObject("cpage","accinfo");
			modelAndView.addObject("vtype","R");
		}catch(Exception e){
			modelAndView.addObject("err", e.getMessage());
			modelAndView.addObject("cpage","err");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public ModelAndView deposit(@RequestParam(value="id", required = true) String id,
			@RequestParam(value="money", required = true) int money) {
		ModelAndView modelAndView = new ModelAndView("bankmain");
		try {
			int balance = accountService.deposit(id, money);
			modelAndView.addObject("cpage","deposit");
			modelAndView.addObject("balance",balance);
			modelAndView.addObject("vtype","R");
		}catch(Exception e){
			modelAndView.addObject("err", e.getMessage());
			modelAndView.addObject("cpage","err");
	}
		return modelAndView;
	}	
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public ModelAndView withdraw(@RequestParam(value="id", required = true) String id,
			@RequestParam(value="money", required = true) int money) {
		ModelAndView modelAndView = new ModelAndView("bankmain");
		try {
			int balance = accountService.withdraw(id, money);
			modelAndView.addObject("cpage","withdraw");
			modelAndView.addObject("balance",balance);
			modelAndView.addObject("vtype","R");
		}catch(Exception e){
			modelAndView.addObject("err", e.getMessage());
			modelAndView.addObject("cpage","err");
	}
		return modelAndView;
	}	
	
	@ResponseBody
	@RequestMapping(value = "/accountoverlap", method = RequestMethod.POST)
	public String accoverlap(@RequestParam(value="id", required = true) String id) {
		boolean overlap = false;
		try {
			overlap = accountService.accOverlap(id);
		}catch(Exception e) {
		}
		return String.valueOf(overlap);
	}
	
	
	//	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
//	public String deposit(HttpServletRequest request, Model model) {
//	HttpSession session = request.getSession();
//	String id = (String)session.getAttribute("id");
//	String cpage = "deposit";
//	if(id==null || id.equals("")) {
//		cpage="login";
//	}
//		model.addAttribute("cpage",cpage);
//		return "bankmain";
//	}
	
//	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
//	public String withdraw(HttpServletRequest request, Model model) {
//	HttpSession session = request.getSession();
//	String id = (String)session.getAttribute("id");
//	String cpage = "withdraw";
//	if(id==null || id.equals("")) {
//		cpage="login";
//	}
//		model.addAttribute("cpage",cpage);
//		return "bankmain";
//	}
//	
//	@RequestMapping(value = "/accinfo", method = RequestMethod.GET)
//	public String accinfo(HttpServletRequest request, Model model) {
//	HttpSession session = request.getSession();
//	String id = (String)session.getAttribute("id");
//	String cpage = "accinfo";
//	if(id==null || id.equals("")) {
//		cpage="login";
//	}
//		model.addAttribute("cpage",cpage);
//		return "bankmain";
//	}
	

}
