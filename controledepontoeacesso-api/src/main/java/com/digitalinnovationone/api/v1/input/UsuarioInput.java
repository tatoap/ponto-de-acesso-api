package com.digitalinnovationone.api.v1.input;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {

	@NotBlank
	private String nome;
	
	@Valid
	@NotNull
	private CategoriaUsuarioIdInput categoria;
	
	@Valid
	@NotNull
	private EmpresaIdInput empresa;
	
	@Valid
	@NotNull
	private NivelAcessoIdInput nivelAcesso;
	
	@Valid
	@NotNull
	private JornadaTrabalhoIdInput jornadaTrabalho;
	
	@NotNull
	private BigDecimal toleranciaAtraso;
	
	@NotNull
	private LocalTime horaInicio;
	
	@NotNull
	private LocalTime horaSaida;
	
}