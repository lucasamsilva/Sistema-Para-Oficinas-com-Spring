package com.projeto.repository.queryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.model.Clientes;
import com.projeto.repository.query.clientesQueries;

public class clientesQueriesImpl implements clientesQueries{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Clientes> buscarPorNome(String nome, Integer page) {
		
		page = page - 1;
		
		TypedQuery<Clientes> query = entityManager.createQuery("SELECT c FROM Clientes c where c.nome LIKE '%" + nome 
				+ "%' ORDER BY c.nome", Clientes.class);
		
		return query.setFirstResult(0).setMaxResults(10).getResultList();
	}

}
