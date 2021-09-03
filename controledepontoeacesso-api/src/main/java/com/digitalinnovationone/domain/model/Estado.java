package com.digitalinnovationone.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.digitalinnovationone.domain.model.id.EntidadeBaseLong;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estado")
public class Estado extends EntidadeBaseLong {

	private String nome;
	
}
