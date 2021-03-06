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

import com.digitalinnovationone.api.v1.assembler.CidadeInputDisassembler;
import com.digitalinnovationone.api.v1.assembler.CidadeModelAssembler;
import com.digitalinnovationone.api.v1.input.CidadeInput;
import com.digitalinnovationone.api.v1.model.CidadeModel;
import com.digitalinnovationone.domain.model.Cidade;
import com.digitalinnovationone.domain.repository.CidadeRepository;
import com.digitalinnovationone.domain.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private CidadeModelAssembler cidadeModelAssembler;
	
	@Autowired
	private CidadeInputDisassembler cidadeInputDisassembler;
	
	@GetMapping
	public List<CidadeModel> listar() {
		return cidadeModelAssembler.toCollectionModel(cidadeRepository.findAll());
	}
	
	@GetMapping("/{cidadeId}")
	public CidadeModel buscar(@PathVariable Long cidadeId) {
		return cidadeModelAssembler.toModel(cidadeService.buscarOuFalhar(cidadeId));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CidadeModel adicionar(@RequestBody @Valid CidadeInput cidadeInput) {
		Cidade cidade = cidadeInputDisassembler.toDomainObject(cidadeInput);
		
		return cidadeModelAssembler.toModel(cidadeService.salvar(cidade));
	}
	
	@PutMapping("/{cidadeId}")
	public CidadeModel atualizar(@PathVariable Long cidadeId, @Valid @RequestBody CidadeInput cidadeInput) {
		Cidade cidadeSalva = cidadeService.buscarOuFalhar(cidadeId);
		
		cidadeInputDisassembler.copyToDomainObject(cidadeInput, cidadeSalva);
		
		return cidadeModelAssembler.toModel(cidadeService.salvar(cidadeSalva));
	}
	
	@DeleteMapping("/{cidadeId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cidadeId) {
		cidadeService.excluir(cidadeId);
	}
	
}
