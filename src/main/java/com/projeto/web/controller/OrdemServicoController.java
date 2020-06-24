package com.projeto.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.OrdemServico;
import com.projeto.service.OrdemServicoService;

@Controller
@RequestMapping(value = "/ordens")
public class OrdemServicoController {

	@Autowired
	OrdemServicoService oss;
	
	@GetMapping(value = "/nova")
	public ModelAndView novaOrdem(OrdemServico ordemServico) {
		
		return new ModelAndView("/ordens/novaOrdem");
	}
	
	@PostMapping(value = "/adicionapeca")
	public String addPeca(OrdemServico ordemServico) {
		
		oss.adicionaPeca(ordemServico);
		
	}
	
	
}
