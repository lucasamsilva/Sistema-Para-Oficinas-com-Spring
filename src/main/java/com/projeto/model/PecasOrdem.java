package com.projeto.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PecasOrdem implements Serializable{

	private static final long serialVersionUID = -2713156093390299733L;
	
	@EmbeddedId
	private PecasOrdemId id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PecaId", insertable = false, updatable = false, nullable = false)
	private Pecas peca;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="OrdemId", insertable = false, updatable = false, nullable = false)
	private OrdemServico ordemservico;
	private Integer quantidade;
	
	
	public PecasOrdem(Pecas peca, OrdemServico ordemservico, Integer quantidade) {
		this.peca = peca;
		this.ordemservico = ordemservico;
		this.quantidade = quantidade;
	}
	
	public PecasOrdem() {

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
