package com.projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.projeto.model.Clientes;
import com.projeto.repository.ClienteRepository;
import com.projeto.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository cr;
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('LEITURA','CLIENTES')")
	public List<Clientes> findAll() {

		return cr.findAll();
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('ESCRITA','CLIENTES')")
	public Clientes save(Clientes entity) {

		return cr.save(entity);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('MODIFICACAO','CLIENTES')")
	public Clientes update(Clientes entity) {

		return cr.save(entity);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('MODIFICACAO','CLIENTES')")
	public Clientes getOne(Long id) {
		// TODO Auto-generated method stub
		return cr.getOne(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('MODIFICACAO','CLIENTES')")
	public Optional<Clientes> findById(Long id) {
		return cr.findById(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('EXCLUSAO','CLIENTES')")
	public void deleteById(Long id) {
		cr.deleteById(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('LEITURA','CLIENTES')")
	public Page<Clientes> listaPaginada(Pageable pageable) {
		
		
		return cr.findAll(pageable);

	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('LEITURA','CLIENTES')")
	public List<Clientes> buscaPorNome(String nome, Integer page) {

		return cr.buscarPorNome(nome, page);
	}

	
	
}
