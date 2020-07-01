package com.projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.Permissao;
import com.projeto.repository.PermissaoRepository;
import com.projeto.service.PermissaoService;

@Service
public class PermissaoServiceImpl implements PermissaoService{

	@Autowired
	private PermissaoRepository pr;
	
	@Override
	public List<Permissao> findAll() {

		return pr.findAll();
	}

	@Override
	public Permissao save(Permissao entity) {

		return pr.save(entity);
	}

	@Override
	public Permissao update(Permissao entity) {

		return pr.save(entity);
	}

	@Override
	public Permissao getOne(Long id) {

		return pr.getOne(id);
	}

	@Override
	public Optional<Permissao> findById(Long id) {

		return pr.findById(id);
	}

	@Override
	public void deleteById(Long id) {

		pr.deleteById(id);
		
	}

}
