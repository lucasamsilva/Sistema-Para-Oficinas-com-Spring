package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.Mecanico;
import com.projeto.repository.query.mecanicoQueries;

@Repository
public interface MecanicoRepository extends JpaRepository<Mecanico, Long>, mecanicoQueries{

}
