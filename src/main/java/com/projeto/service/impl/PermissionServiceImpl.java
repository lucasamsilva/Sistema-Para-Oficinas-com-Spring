package com.projeto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.projeto.model.Permission;
import com.projeto.model.User;
import com.projeto.repository.UserRepository;
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

		User usuario = (User) usuarioLogado.getPrincipal();

		List<Permission> lista = this.findRolePermissaoByUsuarioId(usuario.getId());

		for (Permission p : lista) {

			true_permissao = permissao.equals(p.getPermissao().toUpperCase()) ? true : false;
			true_escopo = escopo.equals(p.getEscopo().toUpperCase()) ? true : false;

			if (true_permissao == true && true_escopo == true) {
				toReturn = true;
				break;
			}
		}

		return toReturn;
	}

	@Override
	public List<Permission> findRolePermissaoByUsuarioId(Long id) {

		return userRepository.findRolePermissaoByUsuarioId(id);
	}

}
