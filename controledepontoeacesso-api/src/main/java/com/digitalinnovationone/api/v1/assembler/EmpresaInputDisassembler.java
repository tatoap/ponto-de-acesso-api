package com.digitalinnovationone.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitalinnovationone.api.v1.input.EmpresaInput;
import com.digitalinnovationone.domain.model.Cidade;
import com.digitalinnovationone.domain.model.Empresa;

@Component
public class EmpresaInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Empresa toDomainModel(EmpresaInput empresaInput) {
		return modelMapper.map(empresaInput, Empresa.class);
	}
	
	public void copyToDomainModel(EmpresaInput empresaInput, Empresa empresa) {
		// Para evitar essa exception: org.hibernate.HibernateException: identifier of an instance of 
		// com.algaworks.algafood.domain.model.Cozinha was altered from 1 to 3
		if (empresa.getEndereco() != null) {
			empresa.getEndereco().setCidade(new Cidade());
		}
		
		modelMapper.map(empresaInput, empresa);
	}
}
