package com.projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.Mecanico;
import com.projeto.repository.MecanicoRepository;
import com.projeto.service.MecanicoService;

@Service
public class MecanicoServiceImpl implements MecanicoService{

	@Autowired
	private MecanicoRepository mr;
	
	@Override
	public List<Mecanico> findAll() {
		
		return mr.findAll();
	}

	@Override
	public Mecanico save(Mecanico entity) {
		
		return mr.save(entity);
	}

	@Override
	public Mecanico update(Mecanico entity) {
		
		return mr.save(entity);
	}

	@Override
	public Mecanico getOne(Long id) {
		
		return mr.getOne(id);
	}

	@Override
	public Optional<Mecanico> findById(Long id) {
		
		return mr.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		
		mr.deleteById(id);
	}
	
	public List<Mecanico> mecanicosAtivos() {
		
		return mr.mecanicosAtivos();
		
	}

	@Override
	public List<Mecanico> mecanicosDemitidos() {
		
		return mr.mecanicosDemitidos();
	
	}

}
