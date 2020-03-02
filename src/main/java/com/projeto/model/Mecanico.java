package com.projeto.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//CRIAR HASHCODE SE NECESSÁRIO
@Entity
public class Mecanico implements Serializable{

	private static final long serialVersionUID = 9054873852251303778L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private Date admissao;
	private boolean admitido;
	private Long salariobase;
	
	public Mecanico(Long id, String nome, String cpf, Date admissao, boolean admitido, Long salariobase) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.admissao = admissao;
		this.admitido = admitido;
		this.salariobase = salariobase;
	}
	
	public Mecanico() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getAdmissao() {
		return admissao;
	}
	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}
	public boolean isAdmitido() {
		return admitido;
	}
	public void setAdmitido(boolean admitido) {
		this.admitido = admitido;
	}
	public Long getSalariobase() {
		return salariobase;
	}
	public void setSalariobase(Long salariobase) {
		this.salariobase = salariobase;
	}

	@Override
	public String toString() {
		return "Mecanico [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", admissao=" + admissao + ", admitido="
				+ admitido + ", salariobase=" + salariobase + "]";
	}
	
}
