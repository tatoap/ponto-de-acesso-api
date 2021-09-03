package com.digitalinnovationone.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitalinnovationone.api.v1.input.UsuarioInput;
import com.digitalinnovationone.domain.model.CategoriaUsuario;
import com.digitalinnovationone.domain.model.Empresa;
import com.digitalinnovationone.domain.model.JornadaTrabalho;
import com.digitalinnovationone.domain.model.NivelAcesso;
import com.digitalinnovationone.domain.model.Usuario;

@Component
public class UsuarioInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Usuario toDomainModel(UsuarioInput usuarioInput) {
		return modelMapper.map(usuarioInput, Usuario.class);
	}
	
	public void copyToDomainModel(UsuarioInput usuarioInput, Usuario usuario) {
		
		if (usuario.getCategoria() != null) {
			usuario.setCategoria(new CategoriaUsuario());
		}
		
		if (usuario.getEmpresa() != null) {
			usuario.setEmpresa(new Empresa());
		}
		
		if (usuario.getNivelAcesso() != null) {
			usuario.setNivelAcesso(new NivelAcesso());
		}
		
		if (usuario.getJornadaTrabalho() != null) {
			usuario.setJornadaTrabalho(new JornadaTrabalho());
		}
		
		modelMapper.map(usuarioInput, usuario);
	}
	
}
