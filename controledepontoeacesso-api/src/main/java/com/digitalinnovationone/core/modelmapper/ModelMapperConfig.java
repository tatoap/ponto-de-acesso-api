package com.digitalinnovationone.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.digitalinnovationone.api.v1.model.EnderecoModel;
import com.digitalinnovationone.domain.model.Endereco;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		
		var modelMapper = new ModelMapper();
		
		var enderecoToEnderecoModelTypeMap = modelMapper.createTypeMap(
				Endereco.class, EnderecoModel.class);

		// para pegar o nome do estado da cidade do endere?o para retorno no json
		enderecoToEnderecoModelTypeMap.<String>addMapping(
				enderecoSrc -> enderecoSrc.getCidade().getEstado().getNome(), 
				(enderecoModelDest, value) -> enderecoModelDest.getCidade().setEstado(value));	
		
		return modelMapper;
		
	}

}
