package com.digitalinnovationone.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.digitalinnovationone.domain.exception.EmpresaNaoEncontradaException;
import com.digitalinnovationone.domain.exception.EntidadeEmUsoException;
import com.digitalinnovationone.domain.model.Empresa;
import com.digitalinnovationone.domain.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	private static final String MSG_EMPRESA_EM_USO = "Empresa de código %d não pode ser removida, pois esta em uso";

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Transactional
	public Empresa salvar(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
	@Transactional
	public void excluir(Long empresaId) {
		try {
			empresaRepository.deleteById(empresaId);
			empresaRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new EmpresaNaoEncontradaException(empresaId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_EMPRESA_EM_USO, empresaId));
		}
	}
	
	public Empresa buscarOuFalhar(Long empresaId) {
		return empresaRepository.findById(empresaId)
				.orElseThrow(() -> new EmpresaNaoEncontradaException(empresaId));
	}
	
}
