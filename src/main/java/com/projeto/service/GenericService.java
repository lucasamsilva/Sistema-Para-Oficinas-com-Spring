package com.projeto.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID> {

	public List<T> findAll();
	public T save(T entity);
	public T update(T entity);
	public T getOne(ID id);
	Optional<T> findById(ID id);
	public void deleteById(ID id);
	
}
