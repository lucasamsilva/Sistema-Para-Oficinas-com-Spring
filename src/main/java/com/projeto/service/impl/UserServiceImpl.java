package com.projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.User;
import com.projeto.repository.UserRepository;
import com.projeto.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository ur;
	
	@Override
	@Transactional(readOnly = true)
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('LEITURA','ADMINISTRACAO')")
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('ESCRITA','ADMINISTRACAO')")
	public User save(User entity) {
		// TODO Auto-generated method stub
		return ur.save(entity);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('ESCRITA','ADMINISTRACAO')")
	public User update(User entity) {
		// TODO Auto-generated method stub
		return ur.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('ESCRITA','ADMINISTRACAO')")
	public User getOne(Long id) {
		// TODO Auto-generated method stub
		return ur.getOne(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('EXCLUSAO','ADMINISTRACAO')")
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		ur.deleteById(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('ESCRITA','ADMINISTRACAO')")
	public Optional<User> findById(Long id) {
		return ur.findById(id);
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		User user = ur.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return user;
	}

}
