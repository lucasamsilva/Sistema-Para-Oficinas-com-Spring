package com.projeto.repository.query;

import java.util.List;

import com.projeto.model.Mecanico;

public interface mecanicoQueries {

	List<Mecanico> mecanicosAtivos();
	List<Mecanico> mecanicosDemitidos();
}
