package com.mulcam.bank.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	@GetMapping(value = "/")
	public String login() {
		return "login";
	}

	@ResponseBody
	@RequestMapping("/login")
	public String login(@RequestParam Map<String, String> info) {
		String id = info.get("id");
		String password = info.get("password");
		String id2 = "abcd";
		String password2 = "1234";
		String login = null;
		try {
			if (id.equals(id2) && password.equals(password2)) {
				login = "true";
			} else {
				login = "false";
			}
		} catch (Exception e) {
		}
		return login;
	}
}
