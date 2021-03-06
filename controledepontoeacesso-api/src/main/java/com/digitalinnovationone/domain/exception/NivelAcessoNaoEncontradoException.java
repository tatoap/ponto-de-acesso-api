package com.digitalinnovationone.domain.exception;

public class NivelAcessoNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	private static final String MSG_NIVEL_ACESSO_NAO_ENCONTRADO = "N?o foi encontrado um cadastro de n?vel de acesso com o c?digo d%";

	public NivelAcessoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public NivelAcessoNaoEncontradoException(Long nivelAcessoId) {
		this(String.format(MSG_NIVEL_ACESSO_NAO_ENCONTRADO, nivelAcessoId));
	}

}
