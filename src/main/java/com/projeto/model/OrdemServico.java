package com.projeto.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrdemServico implements Serializable{

	private static final long serialVersionUID = 5661396477312753995L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Mecanico mecanico;
	@ManyToOne(cascade = CascadeType.ALL)
	private Clientes cliente;
	@ManyToOne(cascade = CascadeType.ALL)
	private Carros carro;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ordemservico")
	private List<PecasOrdem> pecas;
	private String servico;
	private Date entrada;
	private Date saida;
	private boolean concluido;
	private Long maodeobra;
	private Long custopecas;
	private Long custototal;
	private String diretorio;
	private String observacao;
	
	public OrdemServico(Long id, Mecanico mecanico, Clientes cliente, Carros carro, String servico, Date entrada,
			Date saida, boolean concluido, Long maodeobra, Long custopecas, Long custototal, String diretorio,
			String observacao) {
		this.id = id;
		this.mecanico = mecanico;
		this.cliente = cliente;
		this.carro = carro;
		this.servico = servico;
		this.entrada = entrada;
		this.saida = saida;
		this.concluido = concluido;
		this.maodeobra = maodeobra;
		this.custopecas = custopecas;
		this.custototal = custototal;
		this.diretorio = diretorio;
		this.observacao = observacao;
	}
	
	public OrdemServico() {

	}
	
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
	public Long getMaodeobra() {
		return maodeobra;
	}
	public void setMaodeobra(Long maodeobra) {
		this.maodeobra = maodeobra;
	}
	public Long getCustopecas() {
		return custopecas;
	}
	public void setCustopecas(Long custopecas) {
		this.custopecas = custopecas;
	}
	public Long getCustototal() {
		return custototal;
	}
	public void setCustototal(Long custototal) {
		this.custototal = custototal;
	}
	public String getDiretorio() {
		return diretorio;
	}
	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "OrdemServico [id=" + id + ", mecanico=" + mecanico + ", cliente=" + cliente + ", carro=" + carro
				+ ", servico=" + servico + ", entrada=" + entrada + ", saida=" + saida + ", concluido=" + concluido
				+ ", maodeobra=" + maodeobra + ", custopecas=" + custopecas + ", custototal=" + custototal
				+ ", diretorio=" + diretorio + ", observacao=" + observacao + "]";
	}
	
}
