package com.digitalinnovationone.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.digitalinnovationone.domain.exception.EntidadeEmUsoException;
import com.digitalinnovationone.domain.exception.NivelAcessoNaoEncontradoException;
import com.digitalinnovationone.domain.model.NivelAcesso;
import com.digitalinnovationone.domain.repository.NivelAcessoRepository;

@Service
public class NivelAcessoService {
	
	private static final String MSG_NIVEL_ACESSO_EM_USO = "Nível de acesso de código %d não pode ser removida, pois esta em uso";

	@Autowired
	private NivelAcessoRepository nivelAcessoRepository;
	
	@Transactional
	public NivelAcesso salvar(NivelAcesso nivelAcesso) {
		return nivelAcessoRepository.save(nivelAcesso);
	}
	
	@Transactional
	public void excluir(Long nivelAcessoId) {
		try {
			nivelAcessoRepository.deleteById(nivelAcessoId);
			nivelAcessoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new NivelAcessoNaoEncontradoException(nivelAcessoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_NIVEL_ACESSO_EM_USO, nivelAcessoId));
		}
	}
	
	public NivelAcesso buscarOuFalhar(Long nivelAcessoId) {
		return nivelAcessoRepository.findById(nivelAcessoId)
				.orElseThrow(() -> new NivelAcessoNaoEncontradoException(nivelAcessoId));
	}

}
