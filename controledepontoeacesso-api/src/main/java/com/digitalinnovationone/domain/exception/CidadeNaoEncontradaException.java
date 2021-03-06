package com.digitalinnovationone.domain.exception;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	private static final String MSG_CIDADE_NAO_ENCONTRADA = "N?o foi encontrado um cadastro de cidade com o c?digo %d";
	
	public CidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public CidadeNaoEncontradaException(Long cidadeId) {
		this(String.format(MSG_CIDADE_NAO_ENCONTRADA, cidadeId));
	}
}
