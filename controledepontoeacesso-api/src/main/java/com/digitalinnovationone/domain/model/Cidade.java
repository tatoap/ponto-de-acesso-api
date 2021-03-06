package com.digitalinnovationone.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.digitalinnovationone.domain.model.id.EntidadeBaseLong;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cidade")
public class Cidade extends EntidadeBaseLong {

	@Column(nullable = false)
	private String nome;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "estado_id")
	private Estado estado;
}
