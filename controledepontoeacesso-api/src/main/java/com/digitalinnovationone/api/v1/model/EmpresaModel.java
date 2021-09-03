package com.digitalinnovationone.api.v1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaModel {
	
	private Long id;
	
	private String descricao;
	
	private String cnpj;
	
	private String telefone;
	
	private EnderecoModel endereco;

}
