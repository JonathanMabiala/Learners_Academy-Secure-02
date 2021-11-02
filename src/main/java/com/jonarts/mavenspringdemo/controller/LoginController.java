package com.jonarts.mavenspringdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/")
	public String login(Model theModel) {
		
		return "login_page";
	}

}
