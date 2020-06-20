package com.projeto.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;


@Entity
public class Clientes implements Serializable{

	private static final long serialVersionUID = 2861647673923860583L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank
	@NotEmpty
	private String nome;
	@NotNull
	@NotBlank
	@NotEmpty
	private String endereco;
	@NotNull
	@NotBlank
	@NotEmpty
	private String telefone;
	@CPF
	@NotNull
	@NotEmpty
	@NotBlank
	private String cpf;
	@NotNull
	@NotBlank
	private String rg;
	
	public Clientes(Long id, String nome, String endereco, String telefone, String cpf, String rg) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
		this.rg = rg;
	}

	public Clientes() {

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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", cpf="
				+ cpf + ", rg=" + rg + "]";
	}
	
}
