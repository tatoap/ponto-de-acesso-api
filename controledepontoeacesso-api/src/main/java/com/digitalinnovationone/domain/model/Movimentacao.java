package com.digitalinnovationone.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movimentacao")
public class Movimentacao {
	
	@EmbeddedId
	private MovimentacaoId id;
	
	@Column(nullable = false)
	private LocalDateTime dataEntrada;
	
	private LocalDateTime dataSaida;
	
	private BigDecimal periodoPermanencia;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "ocorrencia_id")
	private Ocorrencia ocorrencia;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "data_id")
	private Calendario data;
	
	@Getter
	@Setter
	@Embeddable
	@EqualsAndHashCode(onlyExplicitlyIncluded = true)
	public class MovimentacaoId implements Serializable {
		
		private static final long serialVersionUID = 1L;

		@EqualsAndHashCode.Include
		private Long id;
		
		@EqualsAndHashCode.Include
		@Column(name = "usuario_id")
		private Long usuarioId;
		
	}

}
