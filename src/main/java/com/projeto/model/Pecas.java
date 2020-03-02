package com.projeto.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pecas implements Serializable{

	private static final long serialVersionUID = 8690424995504588632L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Fornecedores fornecedor;
	private Long valor;
	private String descricao;
	private String obervacao;
	
	public Pecas(Long id, Fornecedores fornecedor, Long valor, String descricao, String obervacao) {
		this.id = id;
		this.fornecedor = fornecedor;
		this.valor = valor;
		this.descricao = descricao;
		this.obervacao = obervacao;
	}
	
	public Pecas() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Fornecedores getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedores fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Long getValor() {
		return valor;
	}
	public void setValor(Long valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getObervacao() {
		return obervacao;
	}
	public void setObervacao(String obervacao) {
		this.obervacao = obervacao;
	}

	@Override
	public String toString() {
		return "Pecas [id=" + id + ", fornecedor=" + fornecedor + ", valor=" + valor + ", descricao=" + descricao
				+ ", obervacao=" + obervacao + "]";
	}
	
}
