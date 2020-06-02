package com.projeto.repository.query;

import com.projeto.model.User;

public interface userQueries {

	User findRolePermissaoByUsuarioId(Long id);
	
}
