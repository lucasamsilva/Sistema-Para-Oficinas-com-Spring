package com.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PecasOrdemId implements Serializable{

	private static final long serialVersionUID = -6179566746544316811L;

	@Column(insertable = false, updatable = false, nullable = false)
	private Long PecaId;
	@Column(insertable = false, updatable = false, nullable = false)
	private Long OrdemId;
	
	public PecasOrdemId(Long pecaId, Long ordemId) {
		super();
		PecaId = pecaId;
		OrdemId = ordemId;
	}

	public PecasOrdemId() {
		super();
	}
	
	public Long getPecaId() {
		return PecaId;
	}
	public void setPecaId(Long pecaId) {
		PecaId = pecaId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((OrdemId == null) ? 0 : OrdemId.hashCode());
		result = prime * result + ((PecaId == null) ? 0 : PecaId.hashCode());
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
		PecasOrdemId other = (PecasOrdemId) obj;
		if (OrdemId == null) {
			if (other.OrdemId != null)
				return false;
		} else if (!OrdemId.equals(other.OrdemId))
			return false;
		if (PecaId == null) {
			if (other.PecaId != null)
				return false;
		} else if (!PecaId.equals(other.PecaId))
			return false;
		return true;
	}

	public Long getOrdemId() {
		return OrdemId;
	}
	public void setOrdemId(Long ordemId) {
		OrdemId = ordemId;
	}
	
}
