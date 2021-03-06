package com.digitalinnovationone.api.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinnovationone.api.v1.assembler.EmpresaInputDisassembler;
import com.digitalinnovationone.api.v1.assembler.EmpresaModelAssembler;
import com.digitalinnovationone.api.v1.input.EmpresaInput;
import com.digitalinnovationone.api.v1.model.EmpresaModel;
import com.digitalinnovationone.domain.model.Empresa;
import com.digitalinnovationone.domain.repository.EmpresaRepository;
import com.digitalinnovationone.domain.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private EmpresaModelAssembler empresaModelAssembler;
	
	@Autowired
	private EmpresaInputDisassembler empresaInputDisassembler;
	
	@GetMapping
	public List<EmpresaModel> listar() {
		return empresaModelAssembler.toCollectionModel(empresaRepository.findAll());
	}
	
	@GetMapping("/{empresaId}")
	public EmpresaModel buscar(@PathVariable Long empresaId) {
		return empresaModelAssembler.toModel(empresaService.buscarOuFalhar(empresaId));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EmpresaModel adicionar(@Valid @RequestBody EmpresaInput empresaInput) {		
		Empresa empresa = empresaInputDisassembler.toDomainModel(empresaInput);
		
		empresaService.buscarPorCnpj(empresaInput.getCnpj(), null);
		
		return empresaModelAssembler.toModel(empresaService.salvar(empresa));
	}
	
	@PutMapping("/{empresaId}")
	public EmpresaModel atualizar(@PathVariable Long empresaId, @Valid @RequestBody EmpresaInput empresaInput) {
		Empresa empresaSalva = empresaService.buscarOuFalhar(empresaId);
								
		empresaService.buscarPorCnpj(empresaInput.getCnpj(), empresaId);
			
		empresaInputDisassembler.copyToDomainModel(empresaInput, empresaSalva);
			
		return empresaModelAssembler.toModel(empresaService.salvar(empresaSalva));
	}
	
	@DeleteMapping("/{empresaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long empresaId) {
		empresaService.excluir(empresaId);
	}
	
}
