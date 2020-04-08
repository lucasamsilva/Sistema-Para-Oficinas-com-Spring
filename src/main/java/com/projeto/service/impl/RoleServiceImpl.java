package com.projeto.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.Role;
import com.projeto.repository.RoleRepository;
import com.projeto.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository rr;
	
	@Override
	@Transactional
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return rr.findAll();
	}

	@Override
	public Role save(Role entity) {
		// TODO Auto-generated method stub
		return rr.save(entity);
	}

	@Override
	public Role update(Role entity) {
		// TODO Auto-generated method stub
		return rr.save(entity);
	}

	@Override
	public Role getOne(Long id) {
		// TODO Auto-generated method stub
		return rr.getOne(id);
	}

	@Override
	public Role findById(Long id) {
		// TODO Auto-generated method stub
		return rr.findById(id).orElseThrow(()-> new RuntimeException("Usuário não cadastrado!"));
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		rr.deleteById(id);
	}

}
