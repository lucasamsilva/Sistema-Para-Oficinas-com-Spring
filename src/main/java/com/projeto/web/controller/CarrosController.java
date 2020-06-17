package com.projeto.web.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Carros;
import com.projeto.service.CarrosService;

@Controller
@RequestMapping(value = "/carros")
public class CarrosController {
	
	@Autowired
	private CarrosService cs;
	
	
	@RequestMapping(value = "/salvarcarro",method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Carros carros) {
		try {
			cs.save(carros);			
		} catch (Exception e) {
			if(e.getClass() == PersistenceException.class || e.getClass() == DataIntegrityViolationException.class) {
				return new ModelAndView("redirect:/carros/lista?erro");
			}
			return new ModelAndView("redirect:/carros/lista");
		}
		return new ModelAndView("redirect:/carros/lista");
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ModelAndView deletar(@PathVariable Long id) {
		cs.deleteById(id);
		return listar(null);
	}
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET )
	private ModelAndView listar(@RequestParam(required = false) Optional<String> erro) {
		Carros carros = new Carros();
		ModelAndView mv = new ModelAndView("/carros/listaCarros");
		List<Carros> listaCarros = cs.findAll();
		mv.addObject("carro", carros);
		mv.addObject("carros", listaCarros);
		
		return mv;
	}
	
}
