package com.projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.Fornecedores;
import com.projeto.repository.FornecedoresRepository;
import com.projeto.service.FornecedoresService;

@Service
public class FornecedoresServiceImpl implements FornecedoresService{

	@Autowired
	private FornecedoresRepository fr;
	
	@Override
	public List<Fornecedores> findAll() {

		return fr.findAll();
	}

	@Override
	public Fornecedores save(Fornecedores entity) {

		return fr.save(entity);
	}

	@Override
	public Fornecedores update(Fornecedores entity) {

		return fr.save(entity);
	}

	@Override
	public Fornecedores getOne(Long id) {

		return fr.getOne(id);
	}

	@Override
	public Optional<Fornecedores> findById(Long id) {

		return fr.findById(id);
	}

	@Override
	public void deleteById(Long id) {

		fr.deleteById(id);
	}

}
