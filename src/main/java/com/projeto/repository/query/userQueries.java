package com.projeto.repository.query;

import java.util.List;

import com.projeto.model.Permission;

public interface userQueries {

	List<Permission> findRolePermissaoByUsuarioId(Long id);
	
}
