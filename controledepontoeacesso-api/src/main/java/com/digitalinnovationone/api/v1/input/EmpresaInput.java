package com.digitalinnovationone.api.v1.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaInput {

	@Size(max = 30)
	@NotBlank
	private String descricao;
	
	@CNPJ
	@Size(max = 18)
	@NotBlank
	private String cnpj;
	
	@Size(max = 12)
	@NotBlank
	private String telefone;
	
	@Valid
	@NotNull
	private EnderecoInput endereco;
	
}
