package com.projeto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GeneralController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(){
		return "redirect:/";
	}
	
	@RequestMapping("/header.html")
	public String header() {
		return "/statichtml/header";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
}
