package com.projeto.service.impl;

import java.util.List;

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
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Permissao save(Permissao entity) {
		// TODO Auto-generated method stub
		return pr.save(entity);
	}

	@Override
	public Permissao update(Permissao entity) {
		// TODO Auto-generated method stub
		return pr.save(entity);
	}

	@Override
	public Permissao getOne(Long id) {
		// TODO Auto-generated method stub
		return pr.getOne(id);
	}

	@Override
	public Permissao findById(Long id) {
		// TODO Auto-generated method stub
		return pr.getOne(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
		
	}

}
