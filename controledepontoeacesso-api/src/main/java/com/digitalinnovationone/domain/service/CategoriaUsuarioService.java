package com.digitalinnovationone.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.digitalinnovationone.domain.exception.CategoriaUsuarioNaoEncontradoException;
import com.digitalinnovationone.domain.exception.EntidadeEmUsoException;
import com.digitalinnovationone.domain.model.CategoriaUsuario;
import com.digitalinnovationone.domain.repository.CategoriaUsuarioRepository;

@Service
public class CategoriaUsuarioService {
	
	private static final String MSG_CATEGORIA_EM_USO = "Categoria de c?digo %d n?o pode ser removida, pois esta em uso";

	@Autowired
	private CategoriaUsuarioRepository categoriaUsuarioRepository;
	
	@Transactional
	public CategoriaUsuario salvar(CategoriaUsuario categoriaUsuario) {
		return categoriaUsuarioRepository.save(categoriaUsuario);
	}
	
	@Transactional
	public void excluir(Long categoriaId) {
		try {
			categoriaUsuarioRepository.deleteById(categoriaId);
			categoriaUsuarioRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new CategoriaUsuarioNaoEncontradoException(categoriaId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_CATEGORIA_EM_USO, categoriaId));
		}
	}
	
	public CategoriaUsuario buscarOuFalhar(Long categoriaId) {
		return categoriaUsuarioRepository.findById(categoriaId)
				.orElseThrow(() -> new CategoriaUsuarioNaoEncontradoException(categoriaId));
	}
	
}
