package com.projeto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.projeto.model.Role;
import com.projeto.model.RolePermissao;
import com.projeto.model.User;
import com.projeto.repository.UserRepository;
import com.projeto.security.UserSistema;
import com.projeto.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean hasPermission(Authentication usuarioLogado, Object permissao, Object escopo) {

		boolean toReturn = false;
		boolean true_permissao = false;
		boolean true_escopo = false;

		UserSistema userSistema = (UserSistema) usuarioLogado.getPrincipal();

		User user = this.findRolePermissaoByUsuarioId(userSistema.getUsuario().getId());

		for (Role role : user.getRoles()) {
			for (RolePermissao rolePermissao : role.getRolePermissao()) {

				true_permissao = permissao.equals(rolePermissao.getPermissao().getNome().toUpperCase()) ? true : false;
				true_escopo = escopo.equals(rolePermissao.getEscopo().getNome().toUpperCase()) ? true : false;

				if (true_permissao && true_escopo) {
					toReturn = true;
					break;
				}
			}
			if (toReturn == true) {
				break;
			}
		}

		return toReturn;
	}

	@Override
	public User findRolePermissaoByUsuarioId(Long id) {
		
		return userRepository.findRolePermissaoByUsuarioId(id);
	}

}
