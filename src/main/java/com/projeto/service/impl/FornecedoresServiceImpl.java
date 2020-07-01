package com.projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.projeto.model.Fornecedores;
import com.projeto.repository.FornecedoresRepository;
import com.projeto.service.FornecedoresService;

@Service
public class FornecedoresServiceImpl implements FornecedoresService{

	@Autowired
	private FornecedoresRepository fr;
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('LEITURA','FORNECEDORES')")
	public List<Fornecedores> findAll() {

		return fr.findAll();
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('ESCRITA','FORNECEDORES')")
	public Fornecedores save(Fornecedores entity) {

		return fr.save(entity);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('MODIFICACAO','FORNECEDORES')")
	public Fornecedores update(Fornecedores entity) {

		return fr.save(entity);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('MODIFICACAO','FORNECEDORES')")
	public Fornecedores getOne(Long id) {

		return fr.getOne(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('MODIFICACAO','FORNECEDORES')")
	public Optional<Fornecedores> findById(Long id) {

		return fr.findById(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('EXCLUSAO','FORNECEDORES')")
	public void deleteById(Long id) {

		fr.deleteById(id);
	}

}
