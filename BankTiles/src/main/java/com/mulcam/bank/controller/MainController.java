package com.mulcam.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("cpage", "login");
		//cpage는 더이상 화면을 뿌려주기 위한 attribute가 아니라
		//단순히 javascript에서 활용하기 위한 변수이다.
		return "main";
	}
}
