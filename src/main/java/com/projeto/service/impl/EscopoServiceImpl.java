package com.projeto.service.impl;

import java.util.List;

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
		// TODO Auto-generated method stub
		return er.findAll();
	}

	@Override
	public Escopo save(Escopo entity) {
		// TODO Auto-generated method stub
		return er.save(entity);
	}

	@Override
	public Escopo update(Escopo entity) {
		// TODO Auto-generated method stub
		return er.save(entity);
	}

	@Override
	public Escopo getOne(Long id) {
		// TODO Auto-generated method stub
		return er.getOne(id);
	}

	@Override
	public Escopo findById(Long id) {
		// TODO Auto-generated method stub
		return er.getOne(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		er.deleteById(id);
	}

}
