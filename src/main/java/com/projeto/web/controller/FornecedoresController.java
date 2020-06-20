package com.projeto.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Fornecedores;
import com.projeto.service.FornecedoresService;

@Controller
@RequestMapping(value = "/fornecedores")
public class FornecedoresController {

	@Autowired
	private FornecedoresService fs;
	
	@GetMapping(value = "")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/fornecedores/listaFornecedores");
		List<Fornecedores> fornecedores = fs.findAll();
		mv.addObject("fornecedores", fornecedores);
		
		
		return mv;
		
	}
	
	@GetMapping(value = "/novo")
	public ModelAndView novo(Fornecedores fornecedor) {
		ModelAndView mv = new ModelAndView("/fornecedores/novoFornecedor");
		
		return mv;
		
	}
	
	@PostMapping(value = "/novo")
	public ModelAndView salvarNovo(@Valid Fornecedores fornecedor, BindingResult result) {
		
		if(result.hasErrors()) {
			return novo(fornecedor);
		}
		
		fs.save(fornecedor);
		return new ModelAndView("redirect:/fornecedores");
	}
	
}
