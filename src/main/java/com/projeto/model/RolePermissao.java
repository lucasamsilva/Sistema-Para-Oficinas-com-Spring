package com.projeto.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RolePermissao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private RolePermissaoId id;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="roleId", insertable = false, updatable = false, nullable = false)
	private Role role;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="permissaoId", insertable = false, updatable = false, nullable = false)
	private Permissao permissao;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="escopoId", insertable = false, updatable = false, nullable = false)
	private Escopo escopo;
	
	public RolePermissao() {
	}
	
	public RolePermissao(RolePermissaoId id, Role role, Permissao permissao, Escopo escopo) {
		this.id = id;
		this.role = role;
		this.permissao = permissao;
		this.escopo = escopo;
	}
	
	public RolePermissaoId getId() {
		return id;
	}
	public void setId(RolePermissaoId id) {
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
		RolePermissao other = (RolePermissao) obj;
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
		return "RolePermissao [id=" + id + ", role=" + role + ", permissao=" + permissao + ", escopo=" + escopo + "]";
	}
	
	

}
