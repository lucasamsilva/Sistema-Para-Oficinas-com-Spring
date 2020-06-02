package com.projeto.security;

import org.springframework.security.core.userdetails.User;

public class UserSistema extends User {

	private static final long serialVersionUID = 1973602208662020180L;
	
	private com.projeto.model.User usuario;
	
	public UserSistema(com.projeto.model.User usuario) {
		super(usuario.getUsername(),
		    	  usuario.getPassword(), 
		    	  usuario.isEnabled(), 
		    	  usuario.isAccountNonExpired(),
		    	  usuario.isAccountNonLocked(),
		    	  usuario.isCredentialsNonExpired(),
		    	  usuario.getAuthorities());
		
		this.usuario = usuario;

	}
	
	public com.projeto.model.User getUsuario() {
		return usuario;
	}
	
}
