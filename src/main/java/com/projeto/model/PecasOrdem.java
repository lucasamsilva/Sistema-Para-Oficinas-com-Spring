package com.projeto.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PecasOrdem implements Serializable{

	private static final long serialVersionUID = -2713156093390299733L;
	
	@Id
	private Long id;
	@ManyToOne
	private OrdemServico ordemServico;
	private String descricao;
	private Integer quantidade;
	private Double valor;
	
	public PecasOrdem(Long id, OrdemServico ordemId, String descricao, Integer quantidade, Double valor) {

		this.id = id;
		this.ordemServico = ordemId;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public PecasOrdem() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PecasOrdem other = (PecasOrdem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public OrdemServico getordemServico() {
		return ordemServico;
	}
	public void setordemServico(OrdemServico ordemId) {
		this.ordemServico = ordemId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
