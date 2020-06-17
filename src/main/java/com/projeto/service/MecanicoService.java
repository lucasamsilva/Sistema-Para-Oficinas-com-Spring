package com.projeto.service;

import java.util.List;

import com.projeto.model.Mecanico;

public interface MecanicoService extends GenericService<Mecanico, Long> {

	List<Mecanico> mecanicosAtivos();
	List<Mecanico> mecanicosDemitidos();
	
	
}
