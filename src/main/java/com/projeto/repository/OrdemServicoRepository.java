package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.OrdemServico;
import com.projeto.repository.query.OrdemServicoQueries;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>, OrdemServicoQueries{

}
