package com.digitalinnovationone.domain.model;

import java.time.LocalDateTime;

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
@Table(name = "calendario")
public class Calendario extends EntidadeBaseLong {

	@ManyToOne(optional = false)
	@JoinColumn(name = "tipo_data_id")
	private TipoData tipo;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private LocalDateTime data;
}
