package com.projeto.service;

import org.springframework.security.core.Authentication;

import com.projeto.model.User;

public interface PermissionService {

	boolean hasPermission(Authentication usuarioLogado, Object permissao, Object escopo);
	
	User findRolePermissaoByUsuarioId(Long id);
	
}
