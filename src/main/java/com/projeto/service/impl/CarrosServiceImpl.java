package com.projeto.service.impl;

import java.util.List;

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
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Carros save(Carros entity) {
		// TODO Auto-generated method stub
		return cr.save(entity);
	}

	@Override
	public Carros update(Carros entity) {
		// TODO Auto-generated method stub
		return cr.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Carros getOne(Long id) {
		// TODO Auto-generated method stub
		return cr.getOne(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		cr.deleteById(id);
	}

	@Override
	public Carros findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
