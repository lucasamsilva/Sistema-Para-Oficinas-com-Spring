package com.projeto.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projeto.model.Clientes;

public interface ClienteService extends GenericService<Clientes, Long>{

	public Page<Clientes> listaPaginada(Pageable pageable);
	
	public List<Clientes> buscaPorNome(String nome, Integer page);
}
