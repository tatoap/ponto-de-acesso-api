package com.digitalinnovationone.api.v1.model;

import java.math.BigDecimal;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioModel {

	private Long id;
	
	private String nome;
	
	private CategoriaUsuarioModel categoria;
	
	private EmpresaModel empresa;
	
	private NivelAcessoModel nivelAcesso;
	
	private JornadaTrabalhoModel jornadaTrabalho;
	
	private BigDecimal toleranciaAtraso;
	
	private LocalTime horaInicio;
	
	private LocalTime horaSaida;
	
}
