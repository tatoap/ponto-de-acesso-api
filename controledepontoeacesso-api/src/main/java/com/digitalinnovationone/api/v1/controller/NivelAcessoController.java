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

import com.digitalinnovationone.api.v1.assembler.NivelAcessoInputDisassembler;
import com.digitalinnovationone.api.v1.assembler.NivelAcessoModelAssembler;
import com.digitalinnovationone.api.v1.input.NivelAcessoInput;
import com.digitalinnovationone.api.v1.model.NivelAcessoModel;
import com.digitalinnovationone.domain.model.NivelAcesso;
import com.digitalinnovationone.domain.repository.NivelAcessoRepository;
import com.digitalinnovationone.domain.service.NivelAcessoService;

@RestController
@RequestMapping("/niveis-de-acesso")
public class NivelAcessoController {

	@Autowired
	private NivelAcessoService nivelAcessoService;
	
	@Autowired
	private NivelAcessoRepository nivelAcessoRepository;
	
	@Autowired
	private NivelAcessoModelAssembler nivelAcessoModelAssembler;
	
	@Autowired
	private NivelAcessoInputDisassembler nivelAcessoInputDisassembler;
	
	@GetMapping
	public List<NivelAcessoModel> listar() {
		return nivelAcessoModelAssembler.toCollectionModel(nivelAcessoRepository.findAll());
	}
	
	@GetMapping("/{nivelAcessoId}")
	public NivelAcessoModel buscar(@PathVariable Long nivelAcessoId) {
		return nivelAcessoModelAssembler.toModel(nivelAcessoService.buscarOuFalhar(nivelAcessoId));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public NivelAcessoModel adicionar(@Valid @RequestBody NivelAcessoInput nivelAcessoInput) {
		NivelAcesso nivelAcesso = nivelAcessoInputDisassembler.toDomainObject(nivelAcessoInput);
		
		return nivelAcessoModelAssembler.toModel(nivelAcessoService.salvar(nivelAcesso));
	}
	
	@PutMapping("/{nivelAcessoId}")
	public NivelAcessoModel atualizar(@PathVariable Long nivelAcessoId, @Valid @RequestBody NivelAcessoInput nivelAcessoInput) {
		NivelAcesso nivelAcessoSalvo = nivelAcessoService.buscarOuFalhar(nivelAcessoId);
		
		nivelAcessoInputDisassembler.copyToDomainObject(nivelAcessoInput, nivelAcessoSalvo);
		
		//BeanUtils.copyProperties(nivelAcesso, nivelAcessoSalvo, "id");
		
		return nivelAcessoModelAssembler.toModel(nivelAcessoService.salvar(nivelAcessoSalvo));
	}
	
	@DeleteMapping("/{nivelAcessoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long nivelAcessoId) {
		nivelAcessoService.excluir(nivelAcessoId);
	}
}
