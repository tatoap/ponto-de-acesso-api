package com.digitalinnovationone.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	
	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	ERRO_NEGOCIO("/erro-negocio", "Erro de negócio"),
	DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"),
	PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
	ERRO_DE_SISTEMA("/erro-sistema", "Erro de sistema"),
	MIDIA_NAO_SUPORTADA("/midia-nao-suportada", "Mídia não suportada");
	
	private String title;
	private String uri;
	
	ProblemType(String path, String title) {
		this.uri = "https://controleacesso.com.br" + path;
		this.title = title;
	}

}
