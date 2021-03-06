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

import com.digitalinnovationone.api.v1.assembler.UsuarioInputDisassembler;
import com.digitalinnovationone.api.v1.assembler.UsuarioModelAssembler;
import com.digitalinnovationone.api.v1.input.UsuarioInput;
import com.digitalinnovationone.api.v1.model.UsuarioModel;
import com.digitalinnovationone.domain.model.Usuario;
import com.digitalinnovationone.domain.repository.UsuarioRepository;
import com.digitalinnovationone.domain.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioModelAssembler usuarioModelAssembler;
	
	@Autowired
	private UsuarioInputDisassembler usuarioInputDisassembler;
	
	@GetMapping
	public List<UsuarioModel> listar() {
		return usuarioModelAssembler.toCollectionModel(usuarioRepository.findAll());
	}
	
	@GetMapping("/{usuarioId}")
	public UsuarioModel buscar(@PathVariable Long usuarioId) throws Exception {
		return usuarioModelAssembler.toModel(usuarioService.buscarOuFalhar(usuarioId));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioModel adicionar(@Valid @RequestBody UsuarioInput usuarioInput) {
		Usuario usuario = usuarioInputDisassembler.toDomainModel(usuarioInput);
		
		return usuarioModelAssembler.toModel(usuarioService.salvar(usuario));
	}
	
	@PutMapping("/{usuarioId}")
	public UsuarioModel atualizar(@PathVariable Long usuarioId, @Valid @RequestBody UsuarioInput usuarioInput) {
		Usuario usuarioSalvo = usuarioService.buscarOuFalhar(usuarioId);
		
		usuarioInputDisassembler.copyToDomainModel(usuarioInput, usuarioSalvo);
		
		return usuarioModelAssembler.toModel(usuarioService.salvar(usuarioSalvo));
	}
	
	@DeleteMapping("/{usuarioId}")
	public void remover(@PathVariable Long usuarioId) throws Exception {
		usuarioService.excluir(usuarioId);
	}

}
