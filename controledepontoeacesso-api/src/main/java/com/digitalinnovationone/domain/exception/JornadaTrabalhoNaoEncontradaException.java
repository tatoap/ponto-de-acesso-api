package com.digitalinnovationone.domain.exception;

public class JornadaTrabalhoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	private static final String MSG_JORNADA_TRABALHO_NAO_ENCONTRADO = "N�o foi encontrado um cadastro de jornada de trabalho com o c�digo %d";

	public JornadaTrabalhoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public JornadaTrabalhoNaoEncontradaException(Long jornadaId) {
		this(String.format(MSG_JORNADA_TRABALHO_NAO_ENCONTRADO, jornadaId));
	}

}
