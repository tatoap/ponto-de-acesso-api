package com.digitalinnovationone.api.v1.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NivelAcessoInput {

	@Size(max = 50)
	@NotBlank
	private String descricao;
	
}
