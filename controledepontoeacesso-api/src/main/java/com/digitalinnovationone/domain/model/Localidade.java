package com.digitalinnovationone.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "localidade")
public class Localidade {
	
	@EmbeddedId
	private LocalidadeId id;
	
	@MapsId("nivelAcessoId")
	@ManyToOne(optional = false)
	@JoinColumn(name = "nivel_acesso_id")
	private NivelAcesso nivelAcesso;
	
	@Column(nullable = false)
	private String descricao;
	
	@Getter
	@Setter
	@Embeddable
	@EqualsAndHashCode(onlyExplicitlyIncluded = true)
	public class LocalidadeId implements Serializable {
		
		private static final long serialVersionUID = 1L;

		@EqualsAndHashCode.Include
		private Long id;
		
		@EqualsAndHashCode.Include
		@Column(name = "nivel_acesso_id")
		private Long nivelAcessoId;
		
	}

}
