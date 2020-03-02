package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.Carros;

@Repository
public interface CarrosRepository extends JpaRepository<Carros, Long>{

}
