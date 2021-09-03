package com.digitalinnovationone.api.v1.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitalinnovationone.api.v1.model.CategoriaUsuarioModel;
import com.digitalinnovationone.domain.model.CategoriaUsuario;

@Component
public class CategoriaUsuarioModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public CategoriaUsuarioModel toModel(CategoriaUsuario categoriaUsuario) {
		return modelMapper.map(categoriaUsuario, CategoriaUsuarioModel.class);
	}
	
	public List<CategoriaUsuarioModel> toCollectionModel(List<CategoriaUsuario> categoriasUsuario) {
		return categoriasUsuario.stream()
				.map(categoriaUsuario -> toModel(categoriaUsuario))
				.collect(Collectors.toList());
	}
	
}
