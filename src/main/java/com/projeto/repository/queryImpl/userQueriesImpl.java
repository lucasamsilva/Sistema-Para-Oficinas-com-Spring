package com.projeto.repository.queryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.model.Permission;
import com.projeto.repository.query.userQueries;

public class userQueriesImpl implements userQueries{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Permission> findRolePermissaoByUsuarioId(Long id) {
		
		
		
//		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u" 
//		+ " LEFT JOIN FETCH u.roles r" 
//		+ " LEFT JOIN r.rolePermissao rp"
//		+ " LEFT JOIN rp.permissao"
//		+ " LEFT JOIN rp.escopo"deleteQuery
//		+ " WHERE u.id = :id", User.class).setParameter("id", id);
		
		List<Permission> lista = new ArrayList<>();
		
		System.out.println(id);
		
		Query query = entityManager.createNativeQuery("select "
				+ " 	Role.nome as RoleNome, "
				+ " 	Permissao.nome as PermissaoNome, "
				+ "		Escopo.nome as EscopoNome" 
        		+ " from "
        		+ " 	User "
        		+ " inner join "
        		+ "		TAB_USUARIO_ROLE on TAB_USUARIO_ROLE.usuario_id = User.id "
        		+ " inner join "
        		+ "		Role on Role.id = TAB_USUARIO_ROLE.role_id"
        		+ " inner join "
        		+ "		RolePermissao on RolePermissao.roleId = Role.id "
        		+ " inner join "
        		+ " 	Permissao on RolePermissao.permissaoId = Permissao.id "
        		+ " inner join "
        		+ " 	Escopo on RolePermissao.escopoId = Escopo.id"
        		+ " where "
        		+ " 	User.id = :id ").setParameter("id", id);
	  	
	
		@SuppressWarnings("unchecked")
		List<Object[]> mylista = query.getResultList();
		
		for (int i = 0 ; i < mylista.size(); i++) {
			Permission permission = new Permission();
			permission.setRole(mylista.get(i)[0].toString());
			permission.setPermissao(mylista.get(i)[1].toString());
			permission.setEscopo(mylista.get(i)[2].toString());
			lista.add(permission);
		}
		
	
		return lista;
		
	}

}
