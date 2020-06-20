package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.Clientes;
import com.projeto.repository.query.clientesQueries;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long>, clientesQueries{

}
