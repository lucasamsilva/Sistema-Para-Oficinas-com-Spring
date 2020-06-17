package com.projeto.web.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Mecanico;
import com.projeto.service.MecanicoService;

@Controller
@RequestMapping(value = "/mecanicos")
public class MecanicoController {

	@Autowired
	private MecanicoService ms;
	
	@GetMapping(value = "")
	private ModelAndView listar() {
		
		ModelAndView mv = new ModelAndView("/mecanicos/listaMecanicos");
		List<Mecanico> mecanicos = ms.mecanicosAtivos();
		mv.addObject("mecanicos", mecanicos);
		
		return mv;
	}

	@GetMapping(value = "/demitidos")
	private ModelAndView listarDemitidos() {
		
		ModelAndView mv = new ModelAndView("/mecanicos/listaMecanicoDemitido");
		List<Mecanico> mecanicos = ms.mecanicosDemitidos();
		mv.addObject("mecanicos", mecanicos);
		
		return mv;
	}
	
	private ModelAndView novo(Mecanico mecanico, Exception erro) {
		ModelAndView mv = new ModelAndView("/mecanicos/novoMecanico");
		mv.addObject("erro", "Erro ao salvar, verifique se não existem CPF's duplicados, persistindo o erro entre em contato com o administrador.");
				
		return mv;
	}
	
	@GetMapping(value = "/novo")
	private ModelAndView novo(Mecanico mecanico) {
		ModelAndView mv = new ModelAndView("/mecanicos/novoMecanico");
				
		return mv;
	}
	
	@PostMapping(value = "/novo")
	private ModelAndView salvarNovo(@Valid Mecanico mecanico, BindingResult result) {
		if (result.hasErrors()) {
			return novo(mecanico);
		} else {
			mecanico.setAdmissao(new Date());
			mecanico.setAdmitido(Boolean.TRUE);
			try {
				ms.save(mecanico);
				return new ModelAndView("redirect:/mecanicos");		
			} catch (Exception e) {
				return novo(mecanico, e);
			}
		}
	}
	
	@GetMapping(value = "/alterar/{id}")
	private ModelAndView alterar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("/mecanicos/alteraMecanico");
		Mecanico mecanico = ms.getOne(id);
		mv.addObject("mecanico", mecanico);
		
		return mv;
	}
	
	private ModelAndView alterar(Mecanico mecanico, Exception erro) {
		ModelAndView mv = new ModelAndView("/mecanicos/alteraMecanico");
		mv.addObject("erro", "Erro ao salvar, verifique se não existem CPF's duplicados, persistindo o erro entre em contato com o administrador.");
				
		return mv;
	}
	
	@PostMapping(value = "/alterar")
	private ModelAndView salvarAlteracao(@Valid Mecanico mecanico, BindingResult result) {
		if (result.hasErrors()) {
			return alterar(mecanico.getId());
		} else {
			mecanico.setAdmissao(new Date());
			mecanico.setAdmitido(Boolean.TRUE);
			try {
				ms.save(mecanico);
				return new ModelAndView("redirect:/mecanicos");		
			} catch (Exception e) {
				return alterar(mecanico, e);
			}
		}
	}
	
	@GetMapping(value = "/deletar/{id}")
	private ModelAndView deletar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("/mecanicos/deletaMecanico");
		Mecanico mecanico = ms.getOne(id);
		mv.addObject("mecanico", mecanico);
		
		return mv;
	}
	
	@PostMapping(value = "/deletar")
	private String deleta(Mecanico mecanico) {
		Mecanico admissao = ms.getOne(mecanico.getId());
		mecanico.setAdmissao(admissao.getAdmissao());
		mecanico.setAdmitido(Boolean.FALSE);
		ms.save(mecanico);
		
		return "redirect:/mecanicos";
	}
	
	@GetMapping(value = "/readmitir/{id}")
	private ModelAndView readmitir(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("/mecanicos/readmiteMecanico");
		Mecanico mecanico = ms.getOne(id);
		mv.addObject("mecanico", mecanico);
		
		return mv;
	}
	
	@PostMapping(value = "/readmitir")
	private String readmite(Mecanico mecanico) {
		mecanico.setAdmissao(new Date());
		mecanico.setAdmitido(Boolean.TRUE);
		ms.save(mecanico);
		
		return "redirect:/mecanicos";
	}
	
}
