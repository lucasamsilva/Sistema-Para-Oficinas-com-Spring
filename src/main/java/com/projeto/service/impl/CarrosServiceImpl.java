package com.projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Carros> findAll() {

		return cr.findAll();
	}

	@Override
	public Carros save(Carros entity) {

		return cr.save(entity);
	}

	@Override
	public Carros update(Carros entity) {

		return cr.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Carros getOne(Long id) {

		return cr.getOne(id);
	}

	@Override
	public void deleteById(Long id) {

		cr.deleteById(id);
	}

	@Override
	public Optional<Carros> findById(Long id) {

		return cr.findById(id);
	}

	


}
