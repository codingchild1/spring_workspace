package com.mulcam.bank.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
//	@ResponseBody
//	@RequestMapping("/login")
//	public boolean login(@RequestParam Map<String,String> info) {
//		try {
//			String id=info.get("id");
//			String password=info.get("password");
//			if(id.equals("abcd") && password.equals("1234")) {
//				return true;
//			}
//		} catch(Exception e) {
//		}
//		return false;
//	}
	@GetMapping(value="/login")
	public String login() {
		return "login";
	}
}
