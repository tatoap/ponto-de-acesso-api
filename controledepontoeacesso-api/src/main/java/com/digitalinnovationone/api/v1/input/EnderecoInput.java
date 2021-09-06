package com.digitalinnovationone.api.v1.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoInput {

	@Size(max = 80)
	@NotBlank
	private String logradouro;
	
	@Size(max = 80)
	private String complemento;
	
	@Size(max = 12)
	@NotBlank
	private String numero;
	
	@Size(max = 9)
	@NotBlank
	private String cep;
	
	@Size(max = 60)
	@NotBlank
	private String bairro;
	
	@Valid
	@NotNull
	private CidadeIdInput cidade;
	
}
