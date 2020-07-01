package com.projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('LEITURA','SERVICOS')")
	public List<OrdemServico> findAll() {
		
		return ors.findAll();
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('ESCRITA','SERVICOS')")
	public OrdemServico save(OrdemServico entity) {

		return ors.save(entity);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('MODIFICACAO','SERVICOS')")
	public OrdemServico update(OrdemServico entity) {
		
		return ors.save(entity);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('MODIFICACAO','SERVICOS')")
	public OrdemServico getOne(Long id) {
		
		return ors.getOne(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('MODIFICACAO','SERVICOS')")
	public Optional<OrdemServico> findById(Long id) {

		return ors.findById(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('EXCLUSAO','SERVICOS')")
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
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('LEITURA','SERVICOS')")
	public List<OrdemServico> listaAtivas() {
		
		return ors.buscaOrdens("false");
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('LEITURA','SERVICOS')")
	public List<OrdemServico> listaConcluidas() {
		
		return ors.buscaOrdens("true");
	}

}
