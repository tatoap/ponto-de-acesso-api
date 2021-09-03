package com.digitalinnovationone.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.digitalinnovationone.domain.exception.EntidadeEmUsoException;
import com.digitalinnovationone.domain.exception.JornadaTrabalhoNaoEncontradaException;
import com.digitalinnovationone.domain.model.JornadaTrabalho;
import com.digitalinnovationone.domain.repository.JornadaTrabalhoRepository;

@Service
public class JornadaTrabalhoService {
	
	private static final String MSG_JORNADA_TRABALHO_EM_USO = "Jornada de trabalho de código %d não pode ser removida, pois esta em uso";

	@Autowired
	private JornadaTrabalhoRepository jornadaTrabalhoRepository;
	
	@Transactional
	public JornadaTrabalho salvar(JornadaTrabalho jornadaTrabalho) {
		return jornadaTrabalhoRepository.save(jornadaTrabalho);
	}
	
	@Transactional
	public void excluir(Long jornadaId) {
		try {
			jornadaTrabalhoRepository.deleteById(jornadaId);
			jornadaTrabalhoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new JornadaTrabalhoNaoEncontradaException(jornadaId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_JORNADA_TRABALHO_EM_USO, jornadaId));
		}
	}
	
	public JornadaTrabalho buscarOuFalhar(Long jornadaId) {
		return jornadaTrabalhoRepository.findById(jornadaId)
				.orElseThrow(() -> new JornadaTrabalhoNaoEncontradaException(jornadaId));
	}
}
