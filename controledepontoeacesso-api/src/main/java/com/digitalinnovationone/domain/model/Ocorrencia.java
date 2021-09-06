package com.digitalinnovationone.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.digitalinnovationone.domain.model.id.EntidadeBaseLong;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ocorrencia")
public class Ocorrencia extends EntidadeBaseLong {
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String descricao;

}
