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

import com.digitalinnovationone.api.v1.assembler.CategoriaUsuarioInputDisassembler;
import com.digitalinnovationone.api.v1.assembler.CategoriaUsuarioModelAssembler;
import com.digitalinnovationone.api.v1.input.CategoriaUsuarioInput;
import com.digitalinnovationone.api.v1.model.CategoriaUsuarioModel;
import com.digitalinnovationone.domain.model.CategoriaUsuario;
import com.digitalinnovationone.domain.repository.CategoriaUsuarioRepository;
import com.digitalinnovationone.domain.service.CategoriaUsuarioService;

@RestController
@RequestMapping("/categorias")
public class CategoriaUsuarioController {

	@Autowired
	private CategoriaUsuarioRepository categoriaRepository;
	
	@Autowired
	private CategoriaUsuarioService categoriaService;
	
	@Autowired
	private CategoriaUsuarioModelAssembler categoriaUsuarioModelAssembler;
	
	@Autowired
	private CategoriaUsuarioInputDisassembler categoriaUsuarioInputDisassembler; 
	
	@GetMapping
	public List<CategoriaUsuarioModel> listar() {
		return categoriaUsuarioModelAssembler.toCollectionModel(categoriaRepository.findAll());
	}
	
	@GetMapping("/{categoriaId}")
	public CategoriaUsuarioModel buscar(@PathVariable Long categoriaId) {
		return categoriaUsuarioModelAssembler.toModel(categoriaService.buscarOuFalhar(categoriaId));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CategoriaUsuarioModel adicionar(@RequestBody @Valid CategoriaUsuarioInput categoriaUsuarioInput) {
		CategoriaUsuario categoriaUsuario = categoriaUsuarioInputDisassembler.toDomainModel(categoriaUsuarioInput);
		
		return categoriaUsuarioModelAssembler.toModel(categoriaService.salvar(categoriaUsuario));
	}
	
	@PutMapping("/{categoriaId}")
	public CategoriaUsuarioModel atualizar(@PathVariable Long categoriaId, @Valid @RequestBody CategoriaUsuarioInput categoriaUsuarioInput) {
		CategoriaUsuario categoriaSalva = categoriaService.buscarOuFalhar(categoriaId);
		
		//BeanUtils.copyProperties(categoriaUsuario, categoriaSalva, "id");
		categoriaUsuarioInputDisassembler.copyToDomainModel(categoriaUsuarioInput, categoriaSalva);
		
		return categoriaUsuarioModelAssembler.toModel(categoriaService.salvar(categoriaSalva));
	}
	
	@DeleteMapping("/{categoriaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long categoriaId) {
		categoriaService.excluir(categoriaId);
	}
}
