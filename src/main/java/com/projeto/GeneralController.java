package com.projeto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GeneralController {
	
	@RequestMapping("/")
	public String index() {
		return "/general/index";
	}
	
    @GetMapping("/login-error")
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String errorMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session
                    .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                errorMessage = ex.getMessage();
            }
        }
        errorMessage = "Usuário e/ou senha incorretos";
        model.addAttribute("errorMessage", errorMessage);
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
		return "/general/home";
	}
}
