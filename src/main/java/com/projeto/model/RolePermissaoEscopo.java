package com.projeto.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RolePermissaoEscopo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Role role;
	@ManyToOne(cascade = CascadeType.ALL)
	private Permissao permissao;
	@ManyToOne(cascade = CascadeType.ALL)
	private Escopo escopo;
	
	public RolePermissaoEscopo(Long id, Role role, Permissao permissao, Escopo escopo) {

		this.id = id;
		this.role = role;
		this.permissao = permissao;
		this.escopo = escopo;
	}
	
	public RolePermissaoEscopo() {
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Permissao getPermissao() {
		return permissao;
	}
	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	public Escopo getEscopo() {
		return escopo;
	}
	public void setEscopo(Escopo escopo) {
		this.escopo = escopo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((escopo == null) ? 0 : escopo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((permissao == null) ? 0 : permissao.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		RolePermissaoEscopo other = (RolePermissaoEscopo) obj;
		if (escopo == null) {
			if (other.escopo != null)
				return false;
		} else if (!escopo.equals(other.escopo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (permissao == null) {
			if (other.permissao != null)
				return false;
		} else if (!permissao.equals(other.permissao))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RolePermissaoEscopo [id=" + id + ", role=" + role + ", permissao=" + permissao + ", escopo=" + escopo
				+ "]";
	}
	
	
	

}
