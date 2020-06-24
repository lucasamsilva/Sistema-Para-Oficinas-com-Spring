package com.projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.Escopo;
import com.projeto.repository.EscopoRepository;
import com.projeto.service.EscopoService;

@Service
public class EscopoServiceImpl implements EscopoService{

	@Autowired
	private EscopoRepository er;
	
	@Override
	public List<Escopo> findAll() {

		return er.findAll();
	}

	@Override
	public Escopo save(Escopo entity) {

		return er.save(entity);
	}

	@Override
	public Escopo update(Escopo entity) {

		return er.save(entity);
	}

	@Override
	public Escopo getOne(Long id) {
		// TODO Auto-generated method stub
		return er.getOne(id);
	}

	@Override
	public Optional<Escopo> findById(Long id) {

		return er.findById(id);
	}

	@Override
	public void deleteById(Long id) {

		er.deleteById(id);
	}

}
