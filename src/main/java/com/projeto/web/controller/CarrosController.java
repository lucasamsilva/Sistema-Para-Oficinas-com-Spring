package com.projeto.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Carros;
import com.projeto.service.CarrosService;

@Controller
public class CarrosController {
	
	@Autowired
	private CarrosService cs;
	
	@RequestMapping(value = "/home",method = RequestMethod.GET )
	public ModelAndView findAll(Carros carros){
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("carros", carros);
		
		return mv;
	}
	
	@RequestMapping(value = "/salvarcarro",method = RequestMethod.POST)
	public void save(Carros carros) {
		cs.save(carros);
		
	}
	
}
