package com.projeto.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.config.ConfigProjeto;
import com.projeto.model.Role;
import com.projeto.model.User;
import com.projeto.model.auditoria.Auditoria;
import com.projeto.model.auditoria.UsuarioRoleAuditoria;
import com.projeto.repository.RoleRepository;
import com.projeto.repository.UsuarioRoleAuditoriaRepository;
import com.projeto.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository rr;
	
	@Autowired
	private UsuarioRoleAuditoriaRepository urar;
	
	@Override
	@Transactional
	public List<Role> findAll() {
		return rr.findAll();
	}

	@Override
	public Role save(Role entity) {
		Role role = rr.save(entity);
		saveUsuarioRoleAuditoria(entity, ConfigProjeto.SALVAR);
		return role;
	}

	@Override
	public Role update(Role entity) {
		return rr.save(entity);
	}

	@Override
	public Role getOne(Long id) {
		return rr.getOne(id);
	}

	@Override
	public Optional<Role> findById(Long id) {
		return rr.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		rr.deleteById(id);
	}

	@Override
	public void saveUsuarioRoleAuditoria(Role role, String operacao) {
		User user = ConfigProjeto.pegarUsuario();
		UsuarioRoleAuditoria ura = new UsuarioRoleAuditoria();
		Auditoria aud = new Auditoria();
		
		aud.setDataOperacao(new Date());
		aud.setTipoOperacao(operacao);
		aud.setUser(user);
		
		ura.setAuditoria(aud);
		ura.setRole(role);
		urar.save(ura);

	}

}
