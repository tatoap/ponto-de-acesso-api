package com.digitalinnovationone.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitalinnovationone.api.v1.input.CategoriaUsuarioInput;
import com.digitalinnovationone.domain.model.CategoriaUsuario;

@Component
public class CategoriaUsuarioInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public CategoriaUsuario toDomainModel(CategoriaUsuarioInput categoriaUsuarioInput) {
		return modelMapper.map(categoriaUsuarioInput, CategoriaUsuario.class);
	}
	
	public void copyToDomainModel(CategoriaUsuarioInput categoriaUsuarioInput, CategoriaUsuario categoriaUsuario) {
		modelMapper.map(categoriaUsuarioInput, categoriaUsuario);
	}
}
