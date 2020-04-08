package com.projeto.web.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Role;
import com.projeto.model.User;
import com.projeto.service.RoleService;
import com.projeto.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService ur;
	
	@Autowired
	private RoleService rs;
	
	@RequestMapping(value = "/user/list",method = RequestMethod.GET )
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("user/userList");
		
		List<User> listUsers = ur.findAll();
		mv.addObject("listUsers", listUsers);
		
		return mv;
	}
	
	@GetMapping("/user/new")
	public ModelAndView insert(User user) {
		ModelAndView mv = new ModelAndView("/user/user");
		mv.addObject("user", user);
		
		return mv;
	}
	
	@GetMapping("/user/{id}")
	public ModelAndView userChange(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("/user/user");
		User user = ur.getOne(id);
		mv.addObject("user", user);
		
		return mv;
	}
	

	@RequestMapping(value="/user/delete/{id}", method = RequestMethod.DELETE)
	public ModelAndView userDeleteid(@PathVariable Long id) {
		ur.deleteById(id);
		
		return findAll();
	}
	
	@RequestMapping(value = "/user/save",method = RequestMethod.POST )
	public ModelAndView Save(@Valid User user,BindingResult result){
		System.out.println("cheguei aqui");
		if(result.hasErrors()) {
			System.out.println("Erro");
			return insert(user);
		}
		
		
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		ur.save(user);
		System.out.println(user.getPassword());
		return new ModelAndView("redirect:/user/list");
	}
	
	@RequestMapping(value = "/user/modify",method = RequestMethod.POST )
	public ModelAndView Modify(@Valid User user, BindingResult result){
		if(result.hasErrors()) {
			return insert(user);
		}
		else {
		ur.save(user);
		return insert(user);
	}
}
	@ModelAttribute("roles")
	public List<Role> listaRoles(){
		return rs.findAll();
	}
	
}
