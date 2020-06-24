package com.projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projeto.model.Clientes;
import com.projeto.repository.ClienteRepository;
import com.projeto.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository cr;
	
	@Override
	public List<Clientes> findAll() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Clientes save(Clientes entity) {
		// TODO Auto-generated method stub
		return cr.save(entity);
	}

	@Override
	public Clientes update(Clientes entity) {
		// TODO Auto-generated method stub
		return cr.save(entity);
	}

	@Override
	public Clientes getOne(Long id) {
		// TODO Auto-generated method stub
		return cr.getOne(id);
	}

	@Override
	public Optional<Clientes> findById(Long id) {
		return cr.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		cr.deleteById(id);
	}

	@Override
	public Page<Clientes> listaPaginada(Pageable pageable) {
		
		
		return cr.findAll(pageable);

	}

	@Override
	public List<Clientes> buscaPorNome(String nome, Integer page) {

		return cr.buscarPorNome(nome, page);
	}

	
	
}
