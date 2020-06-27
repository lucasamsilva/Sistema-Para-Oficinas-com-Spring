package com.projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.OrdemServico;
import com.projeto.model.PecasOrdem;
import com.projeto.repository.OrdemServicoRepository;
import com.projeto.service.OrdemServicoService;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService{

	@Autowired
	OrdemServicoRepository ors;
	
	@Override
	public List<OrdemServico> findAll() {
		
		return ors.findAll();
	}

	@Override
	public OrdemServico save(OrdemServico entity) {

		return ors.save(entity);
	}

	@Override
	public OrdemServico update(OrdemServico entity) {
		
		return ors.save(entity);
	}

	@Override
	public OrdemServico getOne(Long id) {
		
		return ors.getOne(id);
	}

	@Override
	public Optional<OrdemServico> findById(Long id) {

		return ors.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		ors.deleteById(id);
		
	}

	@Override
	public void adicionaPeca(OrdemServico ordemServico) {
		ordemServico.getPecas().add(new PecasOrdem());
		
	}

	@Override
	public void retiraPeca(OrdemServico ordemServico, Integer indice) {
		ordemServico.getPecas().remove(indice.intValue());
		
	}

	@Override
	public List<OrdemServico> listaAtivas() {
		
		return ors.ordensAbertas();
	}

}
