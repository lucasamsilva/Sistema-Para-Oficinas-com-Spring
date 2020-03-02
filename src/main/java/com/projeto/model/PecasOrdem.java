package com.projeto.model;

import java.io.Serializable;import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PecasOrdem implements Serializable{

	private static final long serialVersionUID = -2713156093390299733L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Pecas peca;
	@ManyToOne(cascade = CascadeType.ALL)
	private OrdemServico ordemservico;
	private Integer quantidade;
	
	
	public PecasOrdem(Long id, Pecas peca, OrdemServico ordemservico, Integer quantidade) {
		this.id = id;
		this.peca = peca;
		this.ordemservico = ordemservico;
		this.quantidade = quantidade;
	}
	
	public PecasOrdem() {

	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Pecas getPeca() {
		return peca;
	}
	public void setPeca(Pecas peca) {
		this.peca = peca;
	}
	public OrdemServico getOrdemservico() {
		return ordemservico;
	}
	public void setOrdemservico(OrdemServico ordemservico) {
		this.ordemservico = ordemservico;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
}
