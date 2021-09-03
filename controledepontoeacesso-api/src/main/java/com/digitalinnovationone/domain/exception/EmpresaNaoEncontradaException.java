package com.digitalinnovationone.domain.exception;

public class EmpresaNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	private static final String MSG_EMPRESA_NAO_ENCONTRADA = "Não foi encontrado um cadastro de empresa com o código %d";

	public EmpresaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public EmpresaNaoEncontradaException(Long empresaId) {
		this(String.format(MSG_EMPRESA_NAO_ENCONTRADA, empresaId));
	}

}
