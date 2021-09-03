package com.digitalinnovationone.api.v1.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NivelAcessoIdInput {

	@NotNull
	private Long id;
	
}
