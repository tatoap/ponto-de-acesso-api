package com.digitalinnovationone.domain.exception;

public class EmpresaCnpjJaInclusoException extends EntidadeJaInclusaException {

	private static final long serialVersionUID = 1L;
	
	private static final String MSG_CNPJ_JA_INCLUSO = "O número de CNPJ '%s' já está cadastrado no sistema";
	
	public EmpresaCnpjJaInclusoException(String cnpj) {
		super(String.format(MSG_CNPJ_JA_INCLUSO, cnpj));
	}

}
