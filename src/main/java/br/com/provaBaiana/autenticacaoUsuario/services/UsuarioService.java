package br.com.provaBaiana.autenticacaoUsuario.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.provaBaiana.autenticacaoUsuario.model.Usuario;
import br.com.provaBaiana.autenticacaoUsuario.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public Usuario save(Usuario _usuario) {
		return repository.save(_usuario);
	}

	public Object findAll() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		repository.findAll().forEach(usuarios::add);
		return usuarios;
	}
}
