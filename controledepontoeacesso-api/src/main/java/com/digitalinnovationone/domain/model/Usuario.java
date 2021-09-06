package com.digitalinnovationone.domain.model;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.digitalinnovationone.domain.model.id.EntidadeBaseLong;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario extends EntidadeBaseLong {

	@Column(nullable = false)
	private String nome;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "categoria_id")
	private CategoriaUsuario categoria;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "nivel_acesso_id")
	private NivelAcesso nivelAcesso;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "jornada_trabalho_id")
	private JornadaTrabalho jornadaTrabalho;
	
	@Column(nullable = false)
	private BigDecimal toleranciaAtraso;
	
	@Column(nullable = false)
	private LocalTime horaInicio;
	
	@Column(nullable = false)
	private LocalTime horaSaida;
	
}
