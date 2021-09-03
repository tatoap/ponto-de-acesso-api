package com.digitalinnovationone.api.v1.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NivelAcessoInput {

	@NotBlank
	private String descricao;
	
}
