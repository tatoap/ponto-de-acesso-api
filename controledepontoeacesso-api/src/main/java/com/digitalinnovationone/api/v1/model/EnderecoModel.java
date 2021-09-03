package com.digitalinnovationone.api.v1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoModel {

	private String logradouro;
	
	private String complemento;
	
	private String numero;
	
	private String cep;
	
	private String bairro;
	
	private CidadeResumoModel cidade;
	
}
