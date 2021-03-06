package com.digitalinnovationone.domain.exception;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;
	
	private static final String MSG_USUARIO_NAO_ENCONTRADO = "N?o foi encontrado um cadastro de usu?rio com o c?digo %d";

	public UsuarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioNaoEncontradoException(Long usuarioId) {
		this(String.format(MSG_USUARIO_NAO_ENCONTRADO, usuarioId));
	}

}
