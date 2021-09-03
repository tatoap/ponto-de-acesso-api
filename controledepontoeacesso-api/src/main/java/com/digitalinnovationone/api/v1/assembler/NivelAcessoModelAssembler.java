package com.digitalinnovationone.api.v1.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitalinnovationone.api.v1.model.NivelAcessoModel;
import com.digitalinnovationone.domain.model.NivelAcesso;

@Component
public class NivelAcessoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public NivelAcessoModel toModel(NivelAcesso nivelAcesso) {
		return modelMapper.map(nivelAcesso, NivelAcessoModel.class);
	}
	
	public List<NivelAcessoModel> toCollectionModel(List<NivelAcesso> niveisAcesso) {
		return niveisAcesso.stream()
				.map(nivelAcesso -> toModel(nivelAcesso))
				.collect(Collectors.toList());
	}
	
}
