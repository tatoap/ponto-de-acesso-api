package com.digitalinnovationone.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.digitalinnovationone.domain.model.id.EntidadeBaseLong;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categoria_usuario")
public class CategoriaUsuario extends EntidadeBaseLong {

	@NotBlank
	private String descricao;
	
}
