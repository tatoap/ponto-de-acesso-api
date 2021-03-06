package com.digitalinnovationone.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "banco_horas")
public class BancoHoras {

	@EmbeddedId
	private BancoHorasId id;
	
	@Column(nullable = false)
	private LocalDateTime dataTrabalhada;
	
	@Column(nullable = false)
	private BigDecimal quantidadeHorasTrabalhadas;
	
	@Column(nullable = false)
	private BigDecimal saldoHorasTrabalhadas;
	
	@Getter
	@Setter
	@Embeddable
	@EqualsAndHashCode(onlyExplicitlyIncluded = true)
	public class BancoHorasId implements Serializable {
		
		private static final long serialVersionUID = 1L;

		@EqualsAndHashCode.Include
		private Long id;
	
		@EqualsAndHashCode.Include
		@Column(name = "movimentacao_id")
		private Long movimentacaoId;
		
		@EqualsAndHashCode.Include
		@Column(name = "usuario_id")
		private Long usuarioId;
		
	}

}
