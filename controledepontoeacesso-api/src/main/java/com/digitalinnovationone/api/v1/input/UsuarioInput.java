package com.digitalinnovationone.api.v1.input;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {

	@Size(max = 50)
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
	@PositiveOrZero
	private BigDecimal toleranciaAtraso;
	
	@NotNull
	private LocalTime horaInicio;
	
	@NotNull
	private LocalTime horaSaida;
	
}
