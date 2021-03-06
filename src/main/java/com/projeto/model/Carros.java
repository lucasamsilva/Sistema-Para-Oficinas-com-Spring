package com.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
public class Carros implements Serializable{

	private static final long serialVersionUID = 8500593176754358487L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank(message = "Preencha o campo montadora")
	private String montadora;
	@NotNull
	@NotBlank(message = "Preencha o campo modelo")
	private String modelo;
	@NotNull
	@NotBlank(message = "Preencha o campo placa")
	@Column(unique = true)
	private String placa;
	
	public Carros(Long id, String montadora, String modelo, String placa) {
		this.id = id;
		this.montadora = montadora;
		this.modelo = modelo;
		this.placa = placa;
	}

	public Carros() {

	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMontadora() {
		return montadora;
	}
	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	
}
