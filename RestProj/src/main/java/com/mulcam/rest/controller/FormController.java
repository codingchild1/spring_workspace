package com.mulcam.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {
	@GetMapping("/objjson")
	public String objjson() {
		return "objjson";
	}
	@GetMapping("/objmap")
	public String objmap() {
		return "objmap";
	}
	
	@GetMapping("/JSONTest2")
	public String JSONTest2() {
		return "JSONTest2";
	}
	
}
