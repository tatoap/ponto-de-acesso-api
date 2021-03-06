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

import com.digitalinnovationone.api.v1.assembler.EstadoInputDisassembler;
import com.digitalinnovationone.api.v1.assembler.EstadoModelAssembler;
import com.digitalinnovationone.api.v1.input.EstadoInput;
import com.digitalinnovationone.api.v1.model.EstadoModel;
import com.digitalinnovationone.domain.model.Estado;
import com.digitalinnovationone.domain.repository.EstadoRepository;
import com.digitalinnovationone.domain.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private EstadoModelAssembler estadoModelAssembler;
	
	@Autowired
	private EstadoInputDisassembler estadoInputDisassembler;
	
	@GetMapping
	public List<EstadoModel> listar() {
		return estadoModelAssembler.toCollectionModel(estadoRepository.findAll());
	}
	
	@GetMapping("/{estadoId}")
	public EstadoModel buscar(@PathVariable Long estadoId) {
		return estadoModelAssembler.toModel(estadoService.buscarOuFalhar(estadoId));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EstadoModel adicionar(@Valid @RequestBody EstadoInput estadoInput) {
		Estado estado = estadoInputDisassembler.toDomainObject(estadoInput);
		
		return estadoModelAssembler.toModel(estadoService.salvar(estado));
	}
	
	@PutMapping("/{estadoId}")
	public EstadoModel atualizar(@PathVariable Long estadoId, @Valid @RequestBody EstadoInput estadoInput) {
		Estado estadoSalvo = estadoService.buscarOuFalhar(estadoId);
		
		//BeanUtils.copyProperties(estado, estadoSalvo, "id");
		
		estadoInputDisassembler.copyToDomainObject(estadoInput, estadoSalvo);
		
		return estadoModelAssembler.toModel(estadoService.salvar(estadoSalvo));
	}
	
	@DeleteMapping("/{estadoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long estadoId) {
		estadoService.excluir(estadoId);
	}
	
}
