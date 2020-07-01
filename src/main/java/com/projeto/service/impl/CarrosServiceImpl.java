package com.projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Carros;
import com.projeto.repository.CarrosRepository;
import com.projeto.service.CarrosService;

@Service
@Transactional
public class CarrosServiceImpl implements CarrosService{

	@Autowired
	private CarrosRepository cr;
	
	@Override
	@Transactional(readOnly = true)
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('LEITURA','CARROS')")
	public List<Carros> findAll() {

		return cr.findAll();
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('ESCRITA','CARROS')")
	public Carros save(Carros entity) {

		return cr.save(entity);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('MODIFICACAO','CARROS')")
	public Carros update(Carros entity) {

		return cr.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('MODIFICACAO','CARROS')")
	public Carros getOne(Long id) {

		return cr.getOne(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('EXCLUSAO','CARROS')")
	public void deleteById(Long id) {

		cr.deleteById(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('MODIFICACAO','CARROS')")
	public Optional<Carros> findById(Long id) {

		return cr.findById(id);
	}

	


}
