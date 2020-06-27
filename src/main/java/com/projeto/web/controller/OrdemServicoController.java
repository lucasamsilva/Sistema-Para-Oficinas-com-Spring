package com.projeto.web.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Carros;
import com.projeto.model.Clientes;
import com.projeto.model.Fornecedores;
import com.projeto.model.Mecanico;
import com.projeto.model.OrdemServico;
import com.projeto.model.PecasOrdem;
import com.projeto.service.CarrosService;
import com.projeto.service.ClienteService;
import com.projeto.service.FornecedoresService;
import com.projeto.service.MecanicoService;
import com.projeto.service.OrdemServicoService;

@Controller
@RequestMapping(value = "/ordens")
public class OrdemServicoController {

	@Autowired
	OrdemServicoService oss;
	
	@Autowired
	MecanicoService ms;

	@Autowired
	ClienteService cs;
	
	@Autowired
	CarrosService carroService;
	
	@Autowired
	FornecedoresService fs;
	
	@GetMapping(value = "/nova")
	public ModelAndView novaOrdem(OrdemServico ordemServico) {
		ModelAndView mv = new ModelAndView("/ordens/novaOrdem");
		mv.addObject("ordemServico", ordemServico);
		return mv;
	}

	@PostMapping(value = "/adicionaPeca")
	public String addPeca(OrdemServico ordemServico) {
		
		
		oss.adicionaPeca(ordemServico);	

		return "/ordens/novaOrdem :: tabelapecas";
	}

	@PostMapping(value = "/removePeca")
	public String rmPeca(OrdemServico ordemServico, @RequestParam("removePeca") Integer indice) {

		oss.retiraPeca(ordemServico, indice);
		
		return "/ordens/novaOrdem :: tabelapecas";
	}
	
	@PostMapping(value = "/nova") 
	public ModelAndView salvarOrdem(@Valid OrdemServico ordemServico, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return novaOrdem(ordemServico);
		}
		
		ordemServico.setEntrada(new Date());
		ordemServico.setConcluido(Boolean.FALSE);
		List<PecasOrdem> pecas = ordemServico.getPecas();
		Double valorTotal = 0.0;
		Double valorPecas = 0.0;
		for (PecasOrdem po : pecas) {
			valorPecas += (po.getQuantidade() * po.getValor());
		}
		valorTotal = ordemServico.getMaodeobra() + valorPecas;
		ordemServico.setCustopecas(valorPecas);
		ordemServico.setCustototal(valorTotal);
		oss.save(ordemServico);
		
		return new ModelAndView("redirect:/ordens");
		
	}
	
	@GetMapping(value = "/alterar/{id}")
	private ModelAndView alterar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("/ordens/alterarOrdem");
		OrdemServico ordemServico = oss.getOne(id);
		mv.addObject("ordemServico", ordemServico);
		
		return mv;
	}
	
	@GetMapping(value = "/concluir/{id}")
	private ModelAndView mostraConcluir(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("/ordens/concluirOrdem");
		OrdemServico ordemServico = oss.getOne(id);
		mv.addObject("ordemServico", ordemServico);
		
		return mv;
	}
	
	@PostMapping(value="/concluir")
	private String concluir(OrdemServico ordemServico) {
		
		ordemServico.setConcluido(Boolean.TRUE);
		ordemServico.setSaida(new Date());
		oss.save(ordemServico);
		
		return "redirect:/ordens";
	}
	
	@GetMapping(value = "")
	private ModelAndView listarOrdens() {
		ModelAndView mv = new ModelAndView("/ordens/listaOrdens");
		List<OrdemServico> ordensServico = oss.listaAtivas();
		mv.addObject("ordens", ordensServico);
		
		return mv;
	}
	
	@ModelAttribute("mecanicos")
	public List<Mecanico> listaMecanicos() {
		
		return ms.findAll();
		
	}

	@ModelAttribute("clientes")
	public List<Clientes> listaCliente() {
		
		return cs.findAll();
		
	}
	
	@ModelAttribute("carros")
	public List<Carros> listaCarros() {
		
		return carroService.findAll();
		
	}
	
	@ModelAttribute("fornecedores")
	public List<Fornecedores> listaFornecedor() {
		
		return fs.findAll();
		
	}
	
}
