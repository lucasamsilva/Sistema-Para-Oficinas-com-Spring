package com.projeto.config;

import org.springframework.security.core.context.SecurityContextHolder;

import com.projeto.model.User;

public class ConfigProjeto {

	public static final String SALVAR = "SALVAR";
	
	public static final String ALTERAR = "ALTERAR";
	
	public static final String EXCLUIR = "EXCLUIR";
	
	public static User pegarUsuario() {
		User us =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return us;
	}

	
}
