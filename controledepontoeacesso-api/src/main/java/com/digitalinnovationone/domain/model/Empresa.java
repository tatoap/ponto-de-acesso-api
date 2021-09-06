package com.digitalinnovationone.domain.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.digitalinnovationone.domain.model.id.EntidadeBaseLong;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empresa")
public class Empresa extends EntidadeBaseLong {

	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false, unique = true)
	private String cnpj;
	
	@Column(nullable = false)
	private String telefone;
	
	@Embedded
	private Endereco endereco;

	@Override
	public String toString() {
		return getId() + " - " + getDescricao() + " - " + getCnpj() + " - " + getTelefone() + " - " + getEndereco();
	}
	
	
	
}
