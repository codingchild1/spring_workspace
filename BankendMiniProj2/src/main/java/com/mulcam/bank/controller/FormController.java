package com.mulcam.bank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping(value="/")
	public String bankmain(@RequestParam(value="cpage", required=false, defaultValue = "") String cpage,  Model model) {
		String id = (String)session.getAttribute("id");
		if(id==null || id.equals("")) {
			cpage="login";
		}
		model.addAttribute("cpage", cpage);
		return "bankmain";
	}
	
	@GetMapping(value="/accmenu")
	public String accmenu(@RequestParam(value="cpage", required=false) String cpage, Model model) {
		model.addAttribute("cpage", cpage);
		return "bankmain";
	}
	
	@GetMapping(value="/memmenu")
	public String memmenu(@RequestParam(value="cpage", required=false) String cpage, Model model) {
		model.addAttribute("cpage", cpage);
		return "bankmain";
	}
	
}
