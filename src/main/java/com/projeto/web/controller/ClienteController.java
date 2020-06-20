package com.projeto.web.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Clientes;
import com.projeto.service.ClienteService;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService cs;
	
	@GetMapping(value = "")
	public ModelAndView listar(@RequestParam("page") Optional<Integer> page, @RequestParam("nome") Optional<String> nome) {
		
		ModelAndView mv = new ModelAndView("/clientes/listaClientes");
		
		if(!nome.isPresent()) {
			PageRequest pageable = PageRequest.of(page.orElse(1) - 1, 10);
			Page<Clientes>  paginaClientes =  cs.listaPaginada(pageable);
			int totalPages = paginaClientes.getTotalPages();
			
	        if(totalPages > 0) {
	            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
	            mv.addObject("pageNumbers", pageNumbers);
	        }
	        
	        mv.addObject("clientes", paginaClientes.getContent());

			return mv;	
		} else {
			
			List<Clientes> clientes = cs.buscaPorNome(nome.orElse(""),page.orElse(1));
			
			int totalPages = (int) Math.ceil(clientes.size()/10);
			
	        if(totalPages > 0) {
	            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
	            mv.addObject("pageNumbers", pageNumbers);
	        }
			
	        mv.addObject("clientes", clientes);
	        
			return mv;
		}
		
	}
	
	@GetMapping(value = "/alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id) {
		
		Clientes cliente = cs.getOne(id);
		ModelAndView mv = new ModelAndView("/clientes/alterarCliente");
		
		mv.addObject("cliente", cliente);
		
		
		return mv;
		
	}
	
	@PostMapping(value = "/alterar")
	public ModelAndView alterar(@Valid Clientes cliente, BindingResult result) {
		
		if (result.hasErrors()) {
			return alterar(cliente.getId());
		} else {
				cs.save(cliente);
				return new ModelAndView("redirect:/clientes");
		}
		
	}
	
	@GetMapping(value = "/novo")
	private ModelAndView cadastro(Clientes cliente) {
		ModelAndView mv = new ModelAndView("/clientes/novoCliente");
		
		return mv;
	}
	
	@PostMapping(value = "/novo")
	public ModelAndView novo(@Valid Clientes cliente, BindingResult result) {
		
		if (result.hasErrors()) {
			return cadastro(cliente);
		} else {
				cs.save(cliente);
				return new ModelAndView("redirect:/clientes");
		}
		
	}
}
