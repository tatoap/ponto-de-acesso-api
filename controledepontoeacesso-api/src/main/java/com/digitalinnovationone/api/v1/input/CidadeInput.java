package com.digitalinnovationone.api.v1.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeInput {

	@Size(max = 40)
	@NotBlank
	private String nome;

	@Valid
	@NotNull
	private EstadoIdInput estado;
}
