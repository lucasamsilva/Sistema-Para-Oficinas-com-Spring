package com.projeto.repository.queryImpl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.model.User;
import com.projeto.repository.query.userQueries;

public class userQueriesImpl implements userQueries{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public User findRolePermissaoByUsuarioId(Long id) {
		
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM Usuario u" 
		+ "LEFT JOIN FETCH u.roles r" 
		+ "LEFT JOIN r.rolePermissao rp"
		+ "LEFT JOIN rp.permissao_id"
		+ "LEFT JOIN ro.escopo_id"
		+ "WHERE u.id = :id", User.class).setParameter("id", id);
		
		return query.getSingleResult();
	}

}
