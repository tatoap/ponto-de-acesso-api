package com.digitalinnovationone.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	
	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreens�vel"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso n�o encontrado"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	ERRO_NEGOCIO("/erro-negocio", "Erro de neg�cio"),
	DADOS_INVALIDOS("/dados-invalidos", "Dados inv�lidos"),
	PARAMETRO_INVALIDO("/parametro-invalido", "Par�metro inv�lido"),
	ERRO_DE_SISTEMA("/erro-sistema", "Erro de sistema"),
	MIDIA_NAO_SUPORTADA("/midia-nao-suportada", "M�dia n�o suportada");
	
	private String title;
	private String uri;
	
	ProblemType(String path, String title) {
		this.uri = "https://controleacesso.com.br" + path;
		this.title = title;
	}

}
