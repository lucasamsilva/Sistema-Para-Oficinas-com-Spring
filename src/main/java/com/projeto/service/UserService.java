package com.projeto.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.projeto.model.User;

public interface UserService extends GenericService<User, Long>, UserDetailsService{

	
}
