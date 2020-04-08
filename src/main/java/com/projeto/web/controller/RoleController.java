package com.projeto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Role;
import com.projeto.service.RoleService;

@Controller
@RequestMapping(value = "/admin")
public class RoleController {

	@Autowired
	private RoleService rs;
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET )
	private ModelAndView getRoles(Role role) {
		ModelAndView mv = new ModelAndView("/roles/listaRoles");
		List<Role> listaRoles = rs.findAll();
		mv.addObject("roles", listaRoles);
		
		return mv;
	}
	
	@RequestMapping(value = "/roles/nova",method = RequestMethod.POST)
	public String save(Role role) {
		String nome = role.getNome().toUpperCase();
		role.setNome(nome); 
		rs.save(role);
		return "redirect:/admin/roles";
	}
	
}
