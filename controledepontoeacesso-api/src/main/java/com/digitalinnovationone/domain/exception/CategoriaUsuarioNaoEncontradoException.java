package com.digitalinnovationone.domain.exception;

public class CategoriaUsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final String MSG_CATEGORIA_NAO_ENCONTRADA = "N�o foi encontrado um cadastro de categoria com o c�digo %d";
	private static final long serialVersionUID = 1L;

	public CategoriaUsuarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public CategoriaUsuarioNaoEncontradoException(Long categoriaId) {
		this(String.format(MSG_CATEGORIA_NAO_ENCONTRADA, categoriaId));
	}
}
