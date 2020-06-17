package com.projeto.repository.queryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.model.Mecanico;
import com.projeto.repository.query.mecanicoQueries;

public class mecanicoQueriesImpl implements mecanicoQueries{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Mecanico> mecanicosAtivos() {
		
		TypedQuery<Mecanico> query = entityManager.createQuery("SELECT m FROM Mecanico m where m.admitido = true", Mecanico.class);
		
		return query.getResultList();
	}

	@Override
	public List<Mecanico> mecanicosDemitidos() {
		
		TypedQuery<Mecanico> query = entityManager.createQuery("SELECT m FROM Mecanico m where m.admitido = false", Mecanico.class);
		
		return query.getResultList();
	}

	
}
