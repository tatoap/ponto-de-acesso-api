package com.digitalinnovationone.api.v1.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitalinnovationone.api.v1.model.EmpresaModel;
import com.digitalinnovationone.domain.model.Empresa;

@Component
public class EmpresaModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EmpresaModel toModel(Empresa empresa) {
		return modelMapper.map(empresa, EmpresaModel.class);
	}
	
	public List<EmpresaModel> toCollectionModel(List<Empresa> empresas) {
		return empresas.stream()
				.map(empresa -> toModel(empresa))
				.collect(Collectors.toList());
	}
}
