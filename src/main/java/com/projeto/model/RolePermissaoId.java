package com.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RolePermissaoId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(insertable = false, updatable = false, nullable = false)
	private Long roleId;
	@Column(insertable = false, updatable = false, nullable = false)
	private Long permissaoId;
	@Column(insertable = false, updatable = false, nullable = false)
	private Long escopoId;
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getPermissaoId() {
		return permissaoId;
	}
	public void setPermissaoId(Long permissaoId) {
		this.permissaoId = permissaoId;
	}
	public Long getEscopoId() {
		return escopoId;
	}
	public void setEscopoId(Long escopoId) {
		this.escopoId = escopoId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((escopoId == null) ? 0 : escopoId.hashCode());
		result = prime * result + ((permissaoId == null) ? 0 : permissaoId.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
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
		RolePermissaoId other = (RolePermissaoId) obj;
		if (escopoId == null) {
			if (other.escopoId != null)
				return false;
		} else if (!escopoId.equals(other.escopoId))
			return false;
		if (permissaoId == null) {
			if (other.permissaoId != null)
				return false;
		} else if (!permissaoId.equals(other.permissaoId))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}
	
	public RolePermissaoId() {
	}
	
	public RolePermissaoId(Long roleId, Long permissaoId, Long escopoId) {
		this.roleId = roleId;
		this.permissaoId = permissaoId;
		this.escopoId = escopoId;
	}
	
	
	
}
