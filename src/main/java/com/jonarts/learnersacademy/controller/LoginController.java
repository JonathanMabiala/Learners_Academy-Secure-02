package com.jonarts.learnersacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/show_login_page")
	public String showMyLoginPage() {
		
		return "login-page";
	}

}
