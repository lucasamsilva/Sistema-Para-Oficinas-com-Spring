package com.projeto.service;

import com.projeto.model.Role;

public interface RoleService extends GenericService<Role, Long>{

	void saveUsuarioRoleAuditoria(Role role, String operacao);
	
}
