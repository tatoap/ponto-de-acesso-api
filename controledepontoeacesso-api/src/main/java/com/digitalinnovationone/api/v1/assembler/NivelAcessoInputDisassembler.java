package com.digitalinnovationone.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitalinnovationone.api.v1.input.NivelAcessoInput;
import com.digitalinnovationone.domain.model.NivelAcesso;

@Component
public class NivelAcessoInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public NivelAcesso toDomainObject(NivelAcessoInput nivelAcessoInput) {
		return modelMapper.map(nivelAcessoInput, NivelAcesso.class);
	}
	
	public void copyToDomainObject(NivelAcessoInput nivelAcessoInput, NivelAcesso nivelAcesso) {
		modelMapper.map(nivelAcessoInput, nivelAcesso);
	}

}
