package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.Fornecedores;

@Repository
public interface FornecedoresRepository extends JpaRepository<Fornecedores, Long>{

}
