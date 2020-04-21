package com.projeto.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.RolePermissao;
import com.projeto.model.RolePermissaoId;
import com.projeto.repository.RolePermissaoRepository;
import com.projeto.service.RolePermissaoService;

@Service
@Transactional
public class RolePermissaoServiceImpl implements RolePermissaoService {

	@Autowired
	private RolePermissaoRepository rpr;
	
	@Override
	public List<RolePermissao> findAll() {
		return rpr.findAll();
	}

	@Override
	public RolePermissao save(RolePermissao entity) {
		return rpr.save(entity);
	}

	@Override
	public RolePermissao update(RolePermissao entity) {
		return rpr.save(entity);
	}

	@Override
	public RolePermissao getOne(RolePermissaoId id) {
		return rpr.getOne(id);
	}

	@Override
	public RolePermissao findById(RolePermissaoId id) {
		return rpr.getOne(id);
	}

	@Override
	public void deleteById(RolePermissaoId id) {
		rpr.deleteById(id);		
	}

}
