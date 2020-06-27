package com.projeto.repository.queryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.model.OrdemServico;
import com.projeto.repository.query.OrdemServicoQueries;

public class OrdemServicoQueriesImpl implements OrdemServicoQueries{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<OrdemServico> ordensAbertas() {
		
		TypedQuery<OrdemServico> query = 
				entityManager.createQuery("SELECT o FROM OrdemServico o where o.concluido = false", OrdemServico.class);
		
		
		return query.getResultList();
	}

}
