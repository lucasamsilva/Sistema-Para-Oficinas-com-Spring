package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.User;
import com.projeto.repository.query.userQueries;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, userQueries{

	User findByEmail(String email);
	
	
}
