package com.digitalinnovationone.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.digitalinnovationone.domain.exception.EntidadeEmUsoException;
import com.digitalinnovationone.domain.exception.UsuarioNaoEncontradoException;
import com.digitalinnovationone.domain.model.CategoriaUsuario;
import com.digitalinnovationone.domain.model.Empresa;
import com.digitalinnovationone.domain.model.JornadaTrabalho;
import com.digitalinnovationone.domain.model.NivelAcesso;
import com.digitalinnovationone.domain.model.Usuario;
import com.digitalinnovationone.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private static final String MSG_USUARIO_EM_USO = "Usuário de código %d não pode ser removido, pois esta em uso";
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CategoriaUsuarioService categoriaUsuarioService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private NivelAcessoService nivelAcessoService;
	
	@Autowired
	private JornadaTrabalhoService jornadaTrabalhoService;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		CategoriaUsuario categoria = categoriaUsuarioService.buscarOuFalhar(usuario.getCategoria().getId());
		
		Empresa empresa = empresaService.buscarOuFalhar(usuario.getEmpresa().getId());
		
		NivelAcesso nivelAcesso = nivelAcessoService.buscarOuFalhar(usuario.getNivelAcesso().getId());
		
		JornadaTrabalho jornadaTrabalho = jornadaTrabalhoService.buscarOuFalhar(usuario.getJornadaTrabalho().getId());
		
		usuario.setCategoria(categoria);
		usuario.setEmpresa(empresa);
		usuario.setNivelAcesso(nivelAcesso);
		usuario.setJornadaTrabalho(jornadaTrabalho);
		
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public void excluir(Long usuarioId) {
		try {
			usuarioRepository.deleteById(usuarioId);
			usuarioRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new UsuarioNaoEncontradoException(usuarioId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_USUARIO_EM_USO, usuarioId));
		}
	}
	
	public Usuario buscarOuFalhar(Long usuarioId) {
		return usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
	}

}
