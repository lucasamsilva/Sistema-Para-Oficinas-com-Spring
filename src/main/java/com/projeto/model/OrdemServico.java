package com.projeto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class OrdemServico implements Serializable{

	private static final long serialVersionUID = 5661396477312753995L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	private Mecanico mecanico;
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	private Clientes cliente;
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	private Carros carro;
	@Valid
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ordem_id")
	private List<PecasOrdem> pecas = new ArrayList<>();
	@NotNull
	@NotEmpty
	@NotBlank
	private String servico;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date entrada;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date saida;
	private boolean concluido;
	@NotNull
	private Double maodeobra;
	private Double custopecas;
	private Double custototal;
	private String observacao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Mecanico getMecanico() {
		return mecanico;
	}
	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public Carros getCarro() {
		return carro;
	}
	public void setCarro(Carros carro) {
		this.carro = carro;
	}
	public List<PecasOrdem> getPecas() {
		return pecas;
	}
	public void setPecas(List<PecasOrdem> pecas) {
		this.pecas = pecas;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getSaida() {
		return saida;
	}
	public void setSaida(Date saida) {
		this.saida = saida;
	}
	public boolean isConcluido() {
		return concluido;
	}
	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
	public Double getMaodeobra() {
		return maodeobra;
	}
	public void setMaodeobra(Double maodeobra) {
		this.maodeobra = maodeobra;
	}
	public Double getCustopecas() {
		return custopecas;
	}
	public void setCustopecas(Double custopecas) {
		this.custopecas = custopecas;
	}
	public Double getCustototal() {
		return custototal;
	}
	public void setCustototal(Double custototal) {
		this.custototal = custototal;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public OrdemServico(Long id, Mecanico mecanico, Clientes cliente, Carros carro, List<PecasOrdem> pecas,
			String servico, Date entrada, Date saida, boolean concluido, Double maodeobra, Double custopecas,
			Double custototal , String observacao) {
		super();
		this.id = id;
		this.mecanico = mecanico;
		this.cliente = cliente;
		this.carro = carro;
		this.pecas = pecas;
		this.servico = servico;
		this.entrada = entrada;
		this.saida = saida;
		this.concluido = concluido;
		this.maodeobra = maodeobra;
		this.custopecas = custopecas;
		this.custototal = custototal;
		this.observacao = observacao;
	}
	
	public OrdemServico() {
		super();
	}
	
	@Override
	public String toString() {
		return "OrdemServico [id=" + id + ", mecanico=" + mecanico + ", cliente=" + cliente + ", carro=" + carro
				+ ", pecas=" + pecas + ", servico=" + servico + ", entrada=" + entrada + ", saida=" + saida
				+ ", concluido=" + concluido + ", maodeobra=" + maodeobra + ", custopecas=" + custopecas
				+ ", custototal=" + custototal + ", observacao=" + observacao + "]";
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
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
