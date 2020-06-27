package com.projeto.service;

import java.util.List;

import com.projeto.model.OrdemServico;

public interface OrdemServicoService extends GenericService<OrdemServico, Long>{
	
	void adicionaPeca(OrdemServico ordemServico);
	void retiraPeca(OrdemServico ordemServico, Integer indice);
	List<OrdemServico> listaAtivas();

}
