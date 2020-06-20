package com.projeto.repository.query;

import java.util.List;

import com.projeto.model.Clientes;

public interface clientesQueries {

	List<Clientes> buscarPorNome(String nome, Integer page);
	
}
