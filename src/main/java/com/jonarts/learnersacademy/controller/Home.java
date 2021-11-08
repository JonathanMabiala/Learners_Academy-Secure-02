package com.jonarts.learnersacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
	
	@RequestMapping("/")
	public String showMyLoginPage() {
		
		return "home-page";
	}

}
