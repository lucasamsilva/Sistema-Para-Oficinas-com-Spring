package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.model.auditoria.UsuarioRoleAuditoria;

public interface UsuarioRoleAuditoriaRepository extends JpaRepository<UsuarioRoleAuditoria, Long>{

}
